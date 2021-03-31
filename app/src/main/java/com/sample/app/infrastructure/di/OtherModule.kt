package com.sample.app.infrastructure.di

import com.sample.app.infrastructure.executors.ExecutionThread
import com.sample.app.infrastructure.executors.impl.ExecutionThreadImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class OtherModule {

    @Binds
    abstract fun bindExecutionThread(
        impl: ExecutionThreadImpl
    ): ExecutionThread

}