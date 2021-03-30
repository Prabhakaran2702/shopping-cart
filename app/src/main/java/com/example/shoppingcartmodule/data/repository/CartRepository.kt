package com.example.shoppingcartmodule.data.repository

import com.example.shoppingcartmodule.data.local.doa.CartItemDao
import com.example.shoppingcartmodule.model.CartItem

class CartRepository(private val cartItemDao: CartItemDao) {

    suspend fun addItem(cartItem: CartItem) {
        cartItemDao.insertItem(cartItem)
    }

    suspend fun removeItem(id:Int) {
        return cartItemDao.removeItem(id)
    }

    suspend fun getAllItems(): List<CartItem> {
        return cartItemDao.getAllItems()
    }

}