package com.example.shoppingcartmodule.di

import com.example.shoppingcartmodule.ui.fragment.cart.CartViewModel
import com.example.shoppingcartmodule.ui.fragment.dashboard.DashboardViewModel
import com.example.shoppingcartmodule.ui.fragment.orderplacing.OrderPlacingViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { DashboardViewModel() }
    single { CartViewModel() }
    single { OrderPlacingViewModel() }
}