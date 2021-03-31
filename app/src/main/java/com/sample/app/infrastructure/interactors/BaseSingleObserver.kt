import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseSingleObserver<T> : SingleObserver<T> {

    override fun onSubscribe(d: Disposable?) {}
    override fun onSuccess(value: T) {}
    override fun onError(e: Throwable?) {}

}