package com.example.budget_buddy.presentation.fragments

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.constraintlayout.widget.ConstraintSet.Motion
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.budget_buddy.R
import com.example.budget_buddy.configureToolbar
import com.example.budget_buddy.data.models.FinanceType
import com.example.budget_buddy.databinding.FragmentAddItemListBinding
import com.example.budget_buddy.presentation.providers.ResourcesProvider
import com.example.budget_buddy.presentation.viewmodels.AddItemViewModel
import com.google.android.material.internal.ViewUtils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

    private fun goToAddItem(financeType: FinanceType) {
        val bundle = Bundle().apply {
            putSerializable("financeType", financeType)
        }
        findNavController().navigate(R.id.action_addItem_to_addItemDetails, bundle)
    }

    private fun setupNavigation() {
        binding.layoutIncome.buttonAdd.setOnClickListener {
            goToAddItem(FinanceType.Income)
        }
        binding.layoutExpense.buttonAdd.setOnClickListener {
            goToAddItem(FinanceType.Expense)
        }
        binding.layoutFutureExpense.buttonAdd.setOnClickListener {
            goToAddItem(FinanceType.FutureExpense)
        }
        binding.layoutInvestment.buttonAdd.setOnClickListener {
            goToAddItem(FinanceType.Investment)
        }
    }
}