package com.example.ecommerceapp


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_amount.*

class AmountFragment : android.app.DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var fragmentView = inflater.inflate(R.layout.fragment_amount, container, false)

        var enterAmount = fragmentView.findViewById<EditText>(R.id.enterAmount)
        var btnAddCart = fragmentView.findViewById<ImageButton>(R.id.btnAddCart)

        btnAddCart.setOnClickListener {

            var ptoUrl = "http://192.168.42.211/EventmanAPI/insert_temporary_order.php?email=${Person.email}&" +
                    "product_id=${Person.addCartProductID}&amount=${enterAmount.text.toString()}"
            var requestQ = Volley.newRequestQueue(activity)
            var stringRequest = StringRequest(Request.Method.GET, ptoUrl, Response.Listener { response ->

                var intent = Intent(activity, CartProductsActivity::class.java)
                startActivity(intent)

            }, Response.ErrorListener { 
                error ->
            })

            requestQ.add(stringRequest)

        }

        return fragmentView
    }



}
