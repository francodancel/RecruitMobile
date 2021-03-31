package com.sample.app.infrastructure.executors.impl

import com.sample.app.infrastructure.executors.ExecutionThread
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ExecutionThreadImpl @Inject constructor(

) : ExecutionThread {

    override fun getObserverThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun getSubscribeThread(): Scheduler {
        return Schedulers.newThread()
    }

}