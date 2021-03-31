package com.sample.app.ui.transactions.details.models

import androidx.annotation.ColorRes
import com.sample.app.R
import com.sample.app.infrastructure.data.network.TransactionModel

sealed class Transaction {

    abstract val summary: String
    abstract val transactionDate: String

    abstract fun getAmount(): Double
    @ColorRes abstract fun getTransactionColour(): Int

    data class Credit(
        override val summary: String,
        override val transactionDate: String,
        private val creditedAmount: Double
    ): Transaction() {

        override fun getAmount(): Double = creditedAmount

        override fun getTransactionColour(): Int = R.color.transaction_credit

    }

    data class Debit(
        override val summary: String,
        override val transactionDate: String,
        private val debitedAmount: Double
    ): Transaction() {
        override fun getAmount(): Double = debitedAmount

        override fun getTransactionColour(): Int = R.color.transaction_debit
    }

    companion object {

        fun newInstance(transaction: TransactionModel): Transaction {
            return when {
                transaction.credit > 0 -> {
                    Credit(
                        summary = transaction.summary,
                        transactionDate = transaction.transactionDate,
                        creditedAmount = transaction.credit
                    )
                }
                else -> {
                    Debit(
                        summary = transaction.summary,
                        transactionDate = transaction.transactionDate,
                        debitedAmount = transaction.debit
                    )
                }
            }
        }

    }

}