package com.sample.app.ui.transactions.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sample.app.infrastructure.data.network.TransactionModel
import com.sample.app.infrastructure.utils.extensions.toLiveData
import com.sample.app.ui.transactions.list.interactors.RetrieveTransactionsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleEmitter
import io.reactivex.rxjava3.core.SingleOnSubscribe
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val handle: SavedStateHandle,
    private val retrieveTransactions: RetrieveTransactionsInteractor
) : ViewModel() {

    private val retrieveTransactionsObservable: Single<List<TransactionModel>> by lazy {
        Single.create<List<TransactionModel>>(
            SingleOnSubscribe { emitter: SingleEmitter<List<TransactionModel>> ->
                val list = _transactionModelList.value
                if (list == null || list.isEmpty() == true) {
                    // show a loading state while we retrieve the contents for the list
                    _isLoading.value = true
                    retrieveTransactions(
                        onSuccess = { results: List<TransactionModel> ->
                            _isLoading.value = false
                            emitter.onSuccess(results)
                        },
                        onError = {
                            it.printStackTrace()
                        }
                    )
                }
            }
        )
    }

    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().apply { value = false }
    }

    private val _transactionModelList: LiveData<List<TransactionModel>> =
        retrieveTransactionsObservable.toLiveData()

    /**
     * [isLoading] indicates that the ViewModel is doing some operation.
     */
    val isLoading: LiveData<Boolean> = _isLoading

    /**
     * [transactionModelList] contains the list of transactions loaded from our data source
     */
    val transactionModelList: LiveData<List<TransactionModel>> = _transactionModelList

    private companion object {
        const val TAG: String = "ListViewModel"
    }

}