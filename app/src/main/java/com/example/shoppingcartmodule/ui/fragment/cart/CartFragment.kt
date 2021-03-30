package com.example.shoppingcartmodule.ui.fragment.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingcartmodule.R
import com.example.shoppingcartmodule.ui.adapter.CartItemAdapter
import com.example.shoppingcartmodule.constant.Constant
import com.example.shoppingcartmodule.databinding.FragmentNotificationsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class CartFragment : Fragment() {

    private lateinit var cartViewModel: CartViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        cartViewModel =
                ViewModelProvider(this).get(CartViewModel::class.java)
    //    val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val binding = FragmentNotificationsBinding.inflate(layoutInflater)

        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)

        if(navBar.visibility!= View.VISIBLE){
            navBar.visibility=View.VISIBLE
        }

        cartViewModel.cartItems.observe(viewLifecycleOwner, Observer {

            val adapter = context?.let {
                CartItemAdapter(
                    Constant.PRODUCT_LIST,
                    it
                )
            }

            binding.cartList.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            binding.cartList.adapter = adapter

        })

        cartViewModel.loadData()

        binding.continueButton.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.action_navigation_notifications_to_navigation_ordersummary)

        }

        return binding.root
    }


}