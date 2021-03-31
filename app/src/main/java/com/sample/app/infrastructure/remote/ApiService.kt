package com.sample.app.infrastructure.remote

import com.sample.app.infrastructure.data.network.TransactionModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {

    @GET("transactions")
    fun getTransactions(): Single<List<TransactionModel>>

}