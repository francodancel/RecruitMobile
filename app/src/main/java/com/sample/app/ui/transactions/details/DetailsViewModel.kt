package com.sample.app.ui.transactions.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val handle: SavedStateHandle
) : ViewModel() {

    private companion object {
        const val TAG: String = "DetailsViewModel"
    }

}