package com.sample.app.infrastructure.repository

import com.sample.app.infrastructure.data.network.TransactionModel
import com.sample.app.infrastructure.remote.ApiService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class TransactionRepository @Inject constructor(
    private val apiService: ApiService
) {

    fun getTransactions(): Single<List<TransactionModel>> {
        return apiService.getTransactions()
    }

}