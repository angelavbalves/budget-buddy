package com.example.budget_buddy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.budget_buddy.data.models.FinanceType
import com.example.budget_buddy.databinding.FragmentFinanceListBinding
import com.example.budget_buddy.presentation.adapters.FinanceItemAdapter
import com.example.budget_buddy.presentation.data.models.FinanceItemListPresentation
import com.example.budget_buddy.presentation.providers.ResourcesProvider
import com.example.budget_buddy.presentation.viewmodels.ListDetailsViewModel
import com.example.budget_buddy.presentation.viewmodels.ListDetailsViewModelFactory

class ListDetailsActivity : AppCompatActivity() {
    private lateinit var binding: FragmentFinanceListBinding
    private lateinit var viewModel: ListDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentFinanceListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val financeType = intent.extras?.getSerializable("data") as? FinanceType
        val resourcesProvider = ResourcesProvider(applicationContext)
        val factory = ListDetailsViewModelFactory(resourcesProvider)

        viewModel = ViewModelProvider(this, factory).get(ListDetailsViewModel::class.java)

        val toolBar = binding.toolbar
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        financeType?.let {
            val items = viewModel.getForType(it)
            setup(items)
        }
    }

    private fun setup(items: List<FinanceItemListPresentation>) {
        val adapter = FinanceItemAdapter(items)
        binding.rcFinanceList.adapter = adapter
    }
}