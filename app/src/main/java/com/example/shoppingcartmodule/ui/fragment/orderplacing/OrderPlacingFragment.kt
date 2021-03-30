package com.example.shoppingcartmodule.ui.fragment.orderplacing

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingcartmodule.ui.activity.MainActivity
import com.example.shoppingcartmodule.R
import com.example.shoppingcartmodule.constant.Constant
import com.example.shoppingcartmodule.databinding.OrderPlacingFragmentBinding
import com.example.shoppingcartmodule.ui.adapter.CartItemAdapterLinear
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog


class OrderPlacingFragment : Fragment() {

    companion object {
        fun newInstance() = OrderPlacingFragment()
    }

    private lateinit var viewModel: OrderPlacingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = OrderPlacingFragmentBinding.inflate(layoutInflater)

        val adapter = context?.let {
            CartItemAdapterLinear(
                Constant.PRODUCT_LIST,
                it
            )
        }

        binding.cartList.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.cartList.adapter = adapter


        binding.seekbar.setProgress(10)

        binding.deliverHere.setOnClickListener {

            binding.address.visibility=(View.GONE)
            binding.orderSummary.visibility=(View.VISIBLE)

            binding.seekbar.progress = (48)

        }

        binding.continueButton.setOnClickListener {

            binding.orderSummary.visibility=(View.GONE)
            binding.payment.visibility=(View.VISIBLE)
            binding.linearlayout2.visibility=(View.VISIBLE)
            binding.seekbar.progress = (100)

        }


        binding.textAddress.setOnClickListener {

            binding.orderSummary.visibility=(View.GONE)
            binding.payment.visibility=(View.GONE)
            binding.linearlayout2.visibility=(View.GONE)
            binding.address.visibility=(View.VISIBLE)

            binding.seekbar.setProgress(10)

        }

        binding.textOrderSummary.setOnClickListener {
            binding.address.visibility=(View.GONE)
            binding.payment.visibility=(View.GONE)
            binding.linearlayout2.visibility=(View.GONE)

            binding.orderSummary.visibility=(View.VISIBLE)

            binding.seekbar.progress = (48)
        }

        binding.textPayment.setOnClickListener {

            binding.address.visibility=(View.GONE)
            binding.orderSummary.visibility=(View.GONE)
            binding.payment.visibility=(View.VISIBLE)
            binding.linearlayout2.visibility=(View.VISIBLE)
            binding.seekbar.progress = (100)
        }

        binding.seekbar.setOnTouchListener({ v, event -> true })

        binding.addAddress.setOnClickListener {
            val mBottomSheetDialog = activity?.let { it1 -> BottomSheetDialog(it1) }
            val sheetView: View? =
               activity?.layoutInflater?.inflate(R.layout.address_bottom_sheet, null)
            if (sheetView != null) {
                mBottomSheetDialog?.setContentView(sheetView)
            }

            val dialog_title = sheetView?.findViewById<TextView>(R.id.dialog_title)
            dialog_title?.setText("Add Address")

            mBottomSheetDialog?.show()
        }

        binding.editAddress.setOnClickListener {

            val mBottomSheetDialog = activity?.let { it1 -> BottomSheetDialog(it1) }
            val sheetView: View? =
                activity?.layoutInflater?.inflate(R.layout.address_bottom_sheet, null)
            if (sheetView != null) {
                mBottomSheetDialog?.setContentView(sheetView)
            }

            val dialog_title = sheetView?.findViewById<TextView>(R.id.dialog_title)
            dialog_title?.setText("Edit Address")

            val edt_address = sheetView?.findViewById<EditText>(R.id.edt_address)
            edt_address?.setText("8,Al Ghurair properties, Deira, Dubai")

            mBottomSheetDialog?.show()

        }

        binding.changeAddAddress.setOnClickListener {

            binding.orderSummary.visibility=(View.GONE)
            binding.payment.visibility=(View.GONE)
            binding.linearlayout2.visibility=(View.GONE)
            binding.address.visibility=(View.VISIBLE)
            binding.seekbar.setProgress(10)

        }

        binding.continuePayment.setOnClickListener {
            showDialog()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hideBottomNav()

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OrderPlacingViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun hideBottomNav(){
        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility=View.GONE
    }

    private fun showDialog(){

        val mDialogView = LayoutInflater.from(context).inflate(R.layout.success_dialog, null)
        val messageBoxBuilder = AlertDialog.Builder(activity).setView(mDialogView)
        val  messageBoxInstance = messageBoxBuilder.show()
        val btDismiss = mDialogView.findViewById<Button>(R.id.btn_done)
        btDismiss.setOnClickListener {
            messageBoxInstance.dismiss()
            val intent = Intent (activity, MainActivity::class.java)
            activity?.startActivity(intent)
            activity?.finish()
        }

    }

}