package com.example.budget_buddy.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.budget_buddy.databinding.FragmentAddDetailsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddDetailsBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentAddDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }
}

