package com.example.shoppingcartmodule.utils.model

import java.math.BigDecimal

interface Saleable {
    fun getPrice():BigDecimal
    fun getName():String
}