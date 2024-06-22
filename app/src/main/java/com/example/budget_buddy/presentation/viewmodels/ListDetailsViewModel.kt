package com.example.budget_buddy.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.budget_buddy.commons.utils.FinanceResult
import com.example.budget_buddy.data.database.toDomainModelList
import com.example.budget_buddy.data.models.FinanceItemList
import com.example.budget_buddy.data.models.FinanceType
import com.example.budget_buddy.data.repositories.FinanceItemRepository
import com.example.budget_buddy.presentation.data.mappers.toMoney
import com.example.budget_buddy.presentation.data.mappers.toPresentation
import com.example.budget_buddy.presentation.data.models.FinanceItemHomePresentation
import com.example.budget_buddy.presentation.data.models.FinanceItemListPresentation
import com.example.budget_buddy.presentation.providers.ResourcesProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListDetailsViewModel @Inject constructor(
    private val repository: FinanceItemRepository,
    private val resourcesProvider: ResourcesProvider
) : ViewModel() {

    private val _financeItems = MutableLiveData<FinanceResult<List<FinanceItemListPresentation>>>()
    val financeItems = _financeItems

    fun fetchForType(type: FinanceType) {
        _financeItems.postValue(FinanceResult.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repository.getAllItemsByType(type).map {
                    it.toDomainModelList().toPresentation(resourcesProvider)
                }
                financeItems.postValue(FinanceResult.Success(data = result))
            } catch (e: Exception) {
                _financeItems.postValue(FinanceResult.Error(e))
            }
        }
    }
}

class ListDetailsViewModelFactory @Inject constructor(
    private val repository: FinanceItemRepository,
    private val resourcesProvider: ResourcesProvider
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListDetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListDetailsViewModel(repository, resourcesProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}