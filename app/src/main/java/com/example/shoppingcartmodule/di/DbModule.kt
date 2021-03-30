package com.example.shoppingcartmodule.di

import android.app.Application
import androidx.room.Room
import com.example.shoppingcartmodule.data.local.AppDatabase
import com.example.shoppingcartmodule.data.local.doa.CartItemDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "eds.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }


    fun provideCartItemDao(database: AppDatabase): CartItemDao {
        return database.cartItemDao
    }



    single { provideAppDatabase(androidApplication()) }
    single { provideCartItemDao(get()) }

}