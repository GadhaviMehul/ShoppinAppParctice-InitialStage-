package com.example.florist.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.florist.model.ProductItem
import com.example.florist.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProduct()
        }
    }

    val product: LiveData<MutableList<ProductItem>>
        get() = repository.product
}
