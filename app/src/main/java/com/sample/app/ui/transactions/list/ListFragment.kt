package com.sample.app.ui.transactions.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.sample.app.R
import com.sample.app.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModels()

    // Navigation
    private val navController: NavController by lazy { findNavController() }

    // Views
    private lateinit var binding: FragmentListBinding

    // RecyclerView components
    private val transactionAdapter: TransactionAdapter by lazy {
        TransactionAdapter(viewModel = viewModel)
    }

    private val transactionItemDecoration: DividerItemDecoration by lazy {
        DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list,
            container,
            false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        addObservers()
        setupNavigation()
        setupViews()

        return binding.root
    }

    private fun addObservers() {}

    private fun setupNavigation() {}

    private fun setupViews() {
        with (binding.recyclerView) {
            addItemDecoration(transactionItemDecoration)
            adapter = transactionAdapter
        }
    }

    private companion object {
        const val TAG: String = "ListFragment"
    }

}