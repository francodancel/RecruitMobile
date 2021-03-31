package com.sample.app.infrastructure.data.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TransactionModel(

    @SerializedName("id")
    val id: String,

    @SerializedName("transactionDate")
    val transactionDate: String,

    @SerializedName("summary")
    val summary: String,

    @SerializedName("debit")
    val debit: Double,

    @SerializedName("credit")
    val credit: Double

) : Parcelable