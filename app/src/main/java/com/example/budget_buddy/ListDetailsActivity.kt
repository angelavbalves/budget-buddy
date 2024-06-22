package com.example.budget_buddy

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.budget_buddy.commons.utils.FinanceResult
import com.example.budget_buddy.data.models.FinanceType
import com.example.budget_buddy.data.repositories.FinanceItemRepository
import com.example.budget_buddy.databinding.FragmentFinanceListBinding
import com.example.budget_buddy.presentation.adapters.FinanceCardAdapter
import com.example.budget_buddy.presentation.adapters.FinanceItemAdapter
import com.example.budget_buddy.presentation.data.models.FinanceItemListPresentation
import com.example.budget_buddy.presentation.providers.ResourcesProvider
import com.example.budget_buddy.presentation.viewmodels.ListDetailsViewModel
import com.example.budget_buddy.presentation.viewmodels.ListDetailsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListDetailsActivity : AppCompatActivity() {
    private lateinit var binding: FragmentFinanceListBinding
    private lateinit var viewModel: ListDetailsViewModel
    private lateinit var adapter: FinanceItemAdapter
    @Inject
    lateinit var repository: FinanceItemRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentFinanceListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val financeType = intent.extras?.getSerializable("financeType") as? FinanceType

        val resourcesProvider = ResourcesProvider(applicationContext)
        val factory = ListDetailsViewModelFactory(repository, resourcesProvider)

        viewModel = ViewModelProvider(this, factory).get(ListDetailsViewModel::class.java)

        setSupportActionBar(binding.toolbar)
        configureToolbar("Itens Cadastrados", true)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val financeTypeString = intent?.extras?.getString("financeType")
        val financeType = financeTypeString?.let { FinanceType.valueOf(it) }
        financeType?.let {
            viewModel.fetchForType(it)
        }
        adapter = FinanceItemAdapter()
        binding.rcFinanceList.adapter = adapter
        observers()
    }

    private fun observers() {
        viewModel.financeItems.observe(this, Observer { result ->
            when(result) {
                is FinanceResult.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.rcFinanceList.visibility = View.GONE
                }

                is FinanceResult.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rcFinanceList.visibility = View.VISIBLE
                    adapter.setUpList(result.data)
                }

                is FinanceResult.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rcFinanceList.visibility = View.GONE
                    Log.i("Erro", "erro")
                }
            }
        })
    }

}