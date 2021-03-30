package com.example.shoppingcartmodule.ui.fragment.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppingcartmodule.constant.Constant
import com.example.shoppingcartmodule.model.Product
import java.util.ArrayList

class CartViewModel : ViewModel() {


    private val _cartItems = MutableLiveData<ArrayList<Product>>()
    val cartItems: LiveData<ArrayList<Product>> = _cartItems


    fun loadData(){
        _cartItems.value = Constant.PRODUCT_LIST
    }

}