package com.sample.app.ui.transactions.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.databinding.ItemTransactionBinding
import com.sample.app.infrastructure.adapters.BindableListAdapter
import com.sample.app.infrastructure.data.network.TransactionModel
import com.sample.app.infrastructure.listeners.ItemSelectedListener

class TransactionAdapter(
    private val viewModel: ListViewModel
) : ListAdapter<TransactionModel, TransactionAdapter.ViewHolder>(DiffCallback()),
    BindableListAdapter<List<TransactionModel>>
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            binding = ItemTransactionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            itemSelectedListener = viewModel.transactionItemSelectedListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(model = item)
    }

    class ViewHolder(
        private val binding: ItemTransactionBinding,
        private val itemSelectedListener: ItemSelectedListener<TransactionModel>
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(model: TransactionModel) {
            binding.model = model
            binding.itemSelectedListener = itemSelectedListener
        }
    }

    private class DiffCallback: DiffUtil.ItemCallback<TransactionModel>() {
        override fun areItemsTheSame(
            oldItem: TransactionModel,
            newItem: TransactionModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: TransactionModel,
            newItem: TransactionModel
        ): Boolean {
            return oldItem == newItem
        }
    }

}