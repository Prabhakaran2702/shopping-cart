package com.example.shoppingcartmodule.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shoppingcartmodule.data.local.doa.CartItemDao
import com.example.shoppingcartmodule.model.CartItem

@Database(entities = [CartItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val cartItemDao: CartItemDao

}