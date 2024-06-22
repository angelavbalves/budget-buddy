    package com.example.budget_buddy.presentation.viewmodels

    import androidx.lifecycle.MutableLiveData
    import androidx.lifecycle.ViewModel
    import androidx.lifecycle.ViewModelProvider
    import androidx.lifecycle.viewModelScope
    import com.example.budget_buddy.commons.utils.FinanceResult
    import com.example.budget_buddy.data.models.FinanceType
    import com.example.budget_buddy.data.repositories.FinanceItemRepository
    import com.example.budget_buddy.presentation.data.mappers.toMoney
    import com.example.budget_buddy.presentation.data.mappers.toPresentation
    import com.example.budget_buddy.presentation.data.models.FinanceItemHomePresentation
    import com.example.budget_buddy.presentation.providers.ResourcesProvider
    import dagger.hilt.android.lifecycle.HiltViewModel
    import kotlinx.coroutines.Dispatchers
    import kotlinx.coroutines.delay
    import kotlinx.coroutines.invoke
    import kotlinx.coroutines.launch
    import javax.inject.Inject

    @HiltViewModel
    class MainViewModel @Inject constructor(
        private val repository: FinanceItemRepository,
        private val resourcesProvider: ResourcesProvider
    ) : ViewModel() {

        private val _financeItems = MutableLiveData<FinanceResult<List<FinanceItemHomePresentation>>>()
        val financeItems = _financeItems

        fun fetchItemsToHome() {
            _financeItems.postValue(FinanceResult.Loading)

            viewModelScope.launch(Dispatchers.IO) {
                delay(3000)
                try {
                    val presentation = mutableListOf<FinanceItemHomePresentation>()

                    for (type in FinanceType.entries) {
                        val total = repository.getTotalValueByType(type)
                        if (type == FinanceType.Balance) {
                            val totalIncome = repository.getTotalValueByType(FinanceType.Income)
                            val totalExpense = repository.getTotalValueByType(FinanceType.Expense)
                            val balance = (totalIncome - totalExpense).toMoney()
                            presentation.add(
                                FinanceItemHomePresentation(
                                    title = type.title,
                                    balance = balance,
                                    textColor = type.toPresentation().getColor(resourcesProvider),
                                    type = type
                                )
                            )
                        } else {
                            presentation.add(
                                FinanceItemHomePresentation(
                                    title = type.title,
                                    balance = total.toMoney(),
                                    textColor = type.toPresentation().getColor(resourcesProvider),
                                    type = type
                                )
                            )
                        }
                    }

                    _financeItems.postValue(FinanceResult.Success(data = presentation))
                } catch (e: Exception) {
                    _financeItems.postValue(FinanceResult.Error(e))
                }
            }
        }
    }
    class MainViewModelFactory(
        private val repository: FinanceItemRepository,
        private val resourcesProvider: ResourcesProvider
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(repository, resourcesProvider) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

