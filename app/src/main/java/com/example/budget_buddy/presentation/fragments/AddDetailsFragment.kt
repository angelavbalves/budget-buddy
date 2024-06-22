package com.example.budget_buddy.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.budget_buddy.ListDetailsActivity
import com.example.budget_buddy.R
import com.example.budget_buddy.data.FinanceItem
import com.example.budget_buddy.data.models.FinanceType
import com.example.budget_buddy.databinding.FragmentAddDetailsBinding
import com.example.budget_buddy.presentation.viewmodels.AddItemViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddDetailsBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentAddDetailsBinding
    private lateinit var viewModel: AddItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AddItemViewModel::class.java]
        val financeType = arguments?.getSerializable("financeType") as? FinanceType
        setSaveButton(financeType ?: FinanceType.Unknown)
        setCancelButton()
    }

    private fun navigateToListActivity(financeType: FinanceType) {
        val bundle = Bundle().apply {
            putString("financeType", financeType.name)
        }
        findNavController().navigate(R.id.action_addItemDetailsFragment_to_listActivity, bundle)
    }

    private fun setSaveButton(financeType: FinanceType) {
        binding.btnSave.setOnClickListener {
            val title = binding.inputTitle.text.toString()
            val description = binding.inputDescription.text.toString()
            val valueText = binding.inputValue.text.toString()
            if (valueText.isNotEmpty()) {
                try {
                    val value = valueText.toDouble()
                    val financeItem = FinanceItem(
                        title = title,
                        description = description,
                        value = value,
                        type = financeType
                    )
                    viewModel.addItem(financeItem)
                    navigateToListActivity(financeItem.type)
                } catch (e: NumberFormatException) {
                    Toast.makeText(requireContext(), "Valor inválido", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Digite um valor válido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setCancelButton() {
        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }
}
