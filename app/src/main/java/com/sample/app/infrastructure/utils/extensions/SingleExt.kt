package com.sample.app.infrastructure.utils.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import io.reactivex.rxjava3.core.Single

fun <T> Single<T>.toLiveData(): LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher(this.toFlowable())
}