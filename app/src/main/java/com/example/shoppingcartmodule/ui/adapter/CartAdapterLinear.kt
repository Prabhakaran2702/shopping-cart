package com.example.shoppingcartmodule.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingcartmodule.R
import com.example.shoppingcartmodule.constant.Constant
import com.example.shoppingcartmodule.model.Product
import java.lang.String
import java.math.BigDecimal
import java.util.ArrayList

class CartItemAdapterLinear(private val userList: ArrayList<Product>, private val context: Context) : RecyclerView.Adapter<CartItemAdapterLinear.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemAdapterLinear.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_cart_linear, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: CartItemAdapterLinear.ViewHolder, position: Int) {
        holder.bindItems(userList[position],context)
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(product: Product, context: Context) {
            val tvProductName = itemView.findViewById(R.id.tvCartItemName) as TextView
            val tvProductPrice = itemView.findViewById(R.id.tvCartItemUnitPrice) as TextView
            val ivProductImage = itemView.findViewById(R.id.tvCartItemImage) as ImageView

            tvProductName.text = product.name
            tvProductPrice.text =  Constant.CURRENCY + String.valueOf(
                product.price)
            ivProductImage.setImageResource(
                context.resources.getIdentifier(
                    product.imageName, "drawable", context.packageName
                )
            )
        }
    }
}
