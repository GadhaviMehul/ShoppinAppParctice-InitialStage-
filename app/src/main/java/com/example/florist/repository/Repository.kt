package com.example.florist.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.florist.model.ProductItem
import com.example.florist.api.ApiService


class Repository(
    private val apiService: ApiService,
    private val applicationContext: Context,
) {

    private val productLiveData = MutableLiveData<MutableList<ProductItem>>()


    val product: LiveData<MutableList<ProductItem> >

        get() = productLiveData

    suspend fun getProduct() {

            val result = apiService.getProduct()
            if (result.body() != null) {
               productLiveData.postValue(result.body())


        }
    }
}








