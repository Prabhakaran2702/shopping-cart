package com.example.shoppingcartmodule.di

import android.app.Application
import com.example.shoppingcartmodule.data.local.doa.CartItemDao
import com.example.shoppingcartmodule.data.remote.ShopAPI
import com.example.shoppingcartmodule.data.repository.CartRepository
import com.example.shoppingcartmodule.data.repository.ProductRepository

import org.koin.dsl.module

val repositoryModule = module {
    fun provideProductRepository(application: Application,api: ShopAPI): ProductRepository {
        return ProductRepository(application,api)
    }

    fun provideCartRepository(dao: CartItemDao): CartRepository {
        return CartRepository(dao)
    }


    single { provideProductRepository(get(),get()) }
    single { provideCartRepository(get()) }


}