package com.example.budget_buddy.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.budget_buddy.R
import com.example.budget_buddy.data.models.FinanceType
import com.example.budget_buddy.databinding.FragmentFinanceHomeBinding
import com.example.budget_buddy.presentation.adapters.FinanceCardAdapter
import com.example.budget_buddy.presentation.viewmodels.MainViewModel
import com.example.budget_buddy.presentation.viewmodels.MainViewModelFactory

class FinanceHomeFragment : Fragment() {
    private lateinit var binding: FragmentFinanceHomeBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFinanceHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val factory = MainViewModelFactory(requireContext().applicationContext)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        val rc = binding.rcFinanceCardHome
        val financeCardAdapter = FinanceCardAdapter(
            financeCards = viewModel.financeItems
        ) {
            goToList(it)
        }

        rc.adapter = financeCardAdapter

        super.onViewCreated(view, savedInstanceState)
    }

    private fun goToList(type: FinanceType) {
        val bundle = bundleOf("data" to type)
        findNavController().navigate(
            R.id.action_financeHomeFragment_to_listDetailsActivity,
            bundle
        )
    }
}