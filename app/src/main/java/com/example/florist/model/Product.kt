package com.example.florist.model

data class Product(
    var list: MutableList<ProductItem>? = arrayListOf()
)