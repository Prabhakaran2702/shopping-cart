package com.example.shoppingcartmodule.model

import java.io.Serializable
import java.math.BigDecimal

data class Product(val id: Int,val name: String, val price: Double, val description: String, val imageName: String) {

}
