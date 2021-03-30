package com.example.shoppingcartmodule.ui.fragment.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppingcartmodule.constant.Constant
import com.example.shoppingcartmodule.model.Product
import java.util.ArrayList

class DashboardViewModel : ViewModel() {


    private val _productList = MutableLiveData<ArrayList<Product>>()
    val productList: LiveData<ArrayList<Product>> = _productList


   fun loadData(){
       _productList.value = Constant.PRODUCT_LIST
   }


}