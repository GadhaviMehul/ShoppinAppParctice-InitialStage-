package com.example.florist.api

import com.example.florist.model.ProductItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/products")
    suspend fun
            getProduct(): Response<MutableList<ProductItem>>

}
