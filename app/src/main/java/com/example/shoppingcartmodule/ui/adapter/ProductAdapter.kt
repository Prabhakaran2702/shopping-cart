package com.example.shoppingcartmodule.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingcartmodule.R
import com.example.shoppingcartmodule.constant.Constant
import com.example.shoppingcartmodule.model.Product
import java.lang.String
import java.util.*


class ProductAdapter(private val userList: ArrayList<Product>, private val context: Context,val clickListener: (Product, Int) -> Unit) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_product, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position], context,clickListener)
        // Calling the clickListener sent by the constructor

    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)


    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(product: Product, context: Context, clickListener: (Product, Int) -> Unit) {
            val tvProductName = itemView.findViewById(R.id.tvProductName) as TextView
            val tvProductPrice = itemView.findViewById(R.id.tvProductPrice) as TextView
            val ivProductImage = itemView.findViewById(R.id.ivProductImage) as ImageView
            val ivAddProduct = itemView.findViewById(R.id.btn_add) as Button

            tvProductName.text = product.name
            tvProductPrice.text =  Constant.CURRENCY + String.valueOf(
                product.price
            )
            ivProductImage.setImageResource(
                context.resources.getIdentifier(
                    product.imageName, "drawable", context.packageName
                )
            )

            ivAddProduct.setOnClickListener  { clickListener(product, position) }

        }
    }
}


