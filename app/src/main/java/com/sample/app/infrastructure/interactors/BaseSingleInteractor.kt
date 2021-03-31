package com.sample.app.infrastructure.interactors

import com.sample.app.infrastructure.executors.ExecutionThread
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.subjects.SingleSubject

abstract class BaseSingleInteractor<T>(
    private val thread: ExecutionThread
) {

    private var subject: SingleSubject<T>? = null
    private var disposable: Disposable? = null
    private var originalObserver: SingleObserver<T>? = null
    private val internalObserver: SingleObserver<T> by lazy {
        object: SingleObserver<T> {

            override fun onSubscribe(d: Disposable) {
                disposable = d
                originalObserver?.onSubscribe(d)
            }

            override fun onSuccess(t: T) {
                originalObserver?.onSuccess(t)
            }

            override fun onError(e: Throwable) {
                originalObserver?.onError(e)
            }

        }
    }

    fun execute(action: () -> Single<T>, observer: SingleObserver<T>) {
        originalObserver = observer
        subject = SingleSubject.create<T>().apply {
            subscribe(internalObserver)

            action.invoke()
                .subscribeOn(thread.getSubscribeThread())
                .observeOn(thread.getObserverThread())
                .doOnSuccess { subject = null }
                .doOnError { subject = null }
                .subscribe(this)
        }
    }

}