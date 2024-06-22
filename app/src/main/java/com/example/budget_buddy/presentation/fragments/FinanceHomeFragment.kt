package com.example.budget_buddy.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.budget_buddy.R
import com.example.budget_buddy.commons.utils.FinanceResult
import com.example.budget_buddy.data.models.FinanceType
import com.example.budget_buddy.data.repositories.FinanceItemRepository
import com.example.budget_buddy.databinding.FragmentFinanceHomeBinding
import com.example.budget_buddy.presentation.adapters.FinanceCardAdapter
import com.example.budget_buddy.presentation.providers.ResourcesProvider
import com.example.budget_buddy.presentation.viewmodels.MainViewModel
import com.example.budget_buddy.presentation.viewmodels.MainViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FinanceHomeFragment : Fragment() {
    private lateinit var binding: FragmentFinanceHomeBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: FinanceCardAdapter
    @Inject
    lateinit var repository: FinanceItemRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFinanceHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resourcesProvider = ResourcesProvider(requireContext())
        val factory = MainViewModelFactory(repository, resourcesProvider)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        createAdapter()
        observers()
        viewModel.fetchItemsToHome()
    }

    fun createAdapter() {
        adapter = FinanceCardAdapter {
            goToList(it)
        }

        binding.rcFinanceCardHome.adapter = adapter
    }

    private fun goToList(type: FinanceType) {
        val bundle = bundleOf("financeType" to type)
        findNavController().navigate(
            R.id.action_financeHomeFragment_to_listDetailsActivity,
            bundle
        )
    }

    private fun observers() {
        viewModel.financeItems.observe(viewLifecycleOwner) { result ->
            when(result) {
                is FinanceResult.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.rcFinanceCardHome.visibility = View.GONE
                }

                is FinanceResult.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rcFinanceCardHome.visibility = View.VISIBLE
                    adapter.setUpList(result.data)
                }

                is FinanceResult.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rcFinanceCardHome.visibility = View.GONE
                    Log.d("FinanceHomeFragment", "Error: ${result.e}")
                }
            }
        }
    }
}