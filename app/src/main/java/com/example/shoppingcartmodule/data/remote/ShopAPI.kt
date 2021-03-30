package com.example.shoppingcartmodule.data.remote

import com.example.shoppingcartmodule.model.Product
import retrofit2.http.GET

interface ShopAPI {

    @GET("products")
    suspend fun getPosts(): List<Product>

}