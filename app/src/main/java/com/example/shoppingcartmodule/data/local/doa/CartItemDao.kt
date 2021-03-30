package com.example.shoppingcartmodule.data.local.doa

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shoppingcartmodule.model.CartItem



@Dao
interface CartItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(cartItem: CartItem)

    @Query("SELECT * FROM cartitem")
    suspend fun getAllItems(): List<CartItem>

    @Query("SELECT * FROM cartitem WHERE id = :itemId")
    suspend fun getItem(itemId: Int): CartItem

    @Query("DELETE FROM cartitem WHERE id = :itemId")
    suspend fun removeItem(itemId: Int)

}