package com.example.shoppingcartmodule.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity
data class CartItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name")
     val name: String,
    @ColumnInfo(name = "price")
     val price: Double,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "imageName")
     val imageName: String) {
}

