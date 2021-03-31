package com.sample.app.infrastructure.executors

import io.reactivex.rxjava3.core.Scheduler

interface ExecutionThread {
    fun getSubscribeThread() : Scheduler
    fun getObserverThread() : Scheduler
}