package com.sample.app.ui.transactions.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sample.app.R
import com.sample.app.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModels()

    // Navigation
    private val navController: NavController by lazy { findNavController() }
    private val args: DetailsFragmentArgs by navArgs()

    // Views
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_details,
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
        binding.transaction = args.transaction
    }

    private companion object {
        const val TAG: String = "DetailsFragment"
    }

}