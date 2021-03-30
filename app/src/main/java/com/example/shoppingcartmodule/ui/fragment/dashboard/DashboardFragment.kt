package com.example.shoppingcartmodule.ui.fragment.dashboard

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shoppingcartmodule.ui.adapter.ProductAdapter
import com.example.shoppingcartmodule.constant.Constant
import com.example.shoppingcartmodule.databinding.FragmentDashboardBinding
import com.example.shoppingcartmodule.model.Product
import com.google.android.material.snackbar.Snackbar

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    private lateinit var binding : FragmentDashboardBinding



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
       // val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

         binding = FragmentDashboardBinding.inflate(layoutInflater)

        dashboardViewModel.productList.observe(viewLifecycleOwner, Observer {

            val adapter =
                context?.let { it1 ->
                    ProductAdapter(it,it1) { product: Product, i: Int ->
                        showSnack(product.name)
                    }

                }

            binding.lvProducts.layoutManager = GridLayoutManager(context, 2)
            binding.lvProducts.adapter = adapter


        })

        dashboardViewModel.loadData()

        return binding.root
    }

    fun showSnack(name : String){
         val snackbar1 = Snackbar.make(binding.root, "$name added to your cart.", Snackbar.LENGTH_SHORT)
            snackbar1.show()

    }


    }

