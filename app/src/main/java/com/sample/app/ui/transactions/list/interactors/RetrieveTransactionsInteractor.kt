package com.sample.app.ui.transactions.list.interactors

import BaseSingleObserver
import com.sample.app.infrastructure.data.network.TransactionModel
import com.sample.app.infrastructure.executors.ExecutionThread
import com.sample.app.infrastructure.interactors.BaseSingleInteractor
import com.sample.app.infrastructure.repository.TransactionRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RetrieveTransactionsInteractor @Inject constructor(
    thread: ExecutionThread,
    private val repository: TransactionRepository
) : BaseSingleInteractor<List<TransactionModel>>(thread) {

    operator fun invoke(
        onSuccess: (List<TransactionModel>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        execute(
            action = { asObservable() },
            observer = object: BaseSingleObserver<List<TransactionModel>>() {
                override fun onSuccess(value: List<TransactionModel>) {
                    onSuccess(value)
                }
                override fun onError(e: Throwable?) {
                    onError(e)
                }
            }
        )
    }

    fun asObservable(): Single<List<TransactionModel>> {
        return repository.getTransactions()
    }

}