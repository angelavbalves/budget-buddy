package com.example.budget_buddy.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.budget_buddy.R
import com.example.budget_buddy.databinding.FragmentAddItemListBinding
import com.example.budget_buddy.presentation.providers.ResourcesProvider
import com.example.budget_buddy.presentation.viewmodels.AddItemViewModel

class AddItemFragment : Fragment() {
    private lateinit var binding: FragmentAddItemListBinding
    private lateinit var viewModel: AddItemViewModel
    private lateinit var resourcesProvider: ResourcesProvider

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddItemListBinding.inflate(inflater, container, false)
        resourcesProvider = ResourcesProvider(requireContext())
        binding.resourcesProvider = resourcesProvider
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddItemViewModel::class.java)

        binding.itemIncome = viewModel.itemIncome
        binding.itemExpense = viewModel.itemExpenses
        binding.itemFutureExpense = viewModel.itemFutureExpense
        binding.itemInvestment= viewModel.itemInvestment

        setupNavigation()
        binding.lifecycleOwner = viewLifecycleOwner
    }

    private fun goToAddItem() {
        findNavController().navigate(
            R.id.action_addItem_to_addItemDetails
        )
    }

    private fun setupNavigation() {
        binding.layoutIncome.buttonAdd.setOnClickListener {
            goToAddItem()
        }
        binding.layoutExpense.buttonAdd.setOnClickListener {
            goToAddItem()
        }
        binding.layoutFutureExpense.buttonAdd.setOnClickListener {
            goToAddItem()
        }
        binding.layoutInvestment.buttonAdd.setOnClickListener {
            goToAddItem()
        }

    }
}