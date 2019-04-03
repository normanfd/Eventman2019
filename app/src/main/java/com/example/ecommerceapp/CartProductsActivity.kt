package com.example.ecommerceapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_cart_products.*
import java.util.ArrayList

class CartProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_products)

        var cartProductsUrl = "http://192.168.43.135/EventmanAPI/fetch_temporary_order.php?email=${Person.email}"
        var cartProductsList = ArrayList<String>()
        var requestQ = Volley.newRequestQueue(this@CartProductsActivity)
        var jsonAR = JsonArrayRequest(Request.Method.GET, cartProductsUrl, null,Response.Listener {
            response ->

            for (joIndex in 0.until(response.length())) { //id, name, price, email, amount
                cartProductsList.add("${response.getJSONObject(joIndex).getInt("id")} \n " +
                        "${response.getJSONObject(joIndex).getString("name")} \n " +
                        "${response.getJSONObject(joIndex).getInt("price")} \n " +
                        "${response.getJSONObject(joIndex).getString("email")} \n " +
                        "${response.getJSONObject(joIndex).getInt("amount")}")
            }

            var cartProductAdapter = ArrayAdapter(this@CartProductsActivity, android.R.layout.simple_list_item_1, cartProductsList)
            cartProductListView.adapter = cartProductAdapter


        }, Response.ErrorListener {
            error ->
        })

        requestQ.add(jsonAR)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.cart_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == R.id.continueShoppingItem) {

            var intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)

        }else if(item?.itemId == R.id.declineOrderItem){
            var deleteUrl = "http://192.168.43.135/EventmanAPI/decline_order.php?email=${Person.email}"
            var requestQ = Volley.newRequestQueue(this@CartProductsActivity)
            var stringRequest = StringRequest(Request.Method.GET, deleteUrl, Response.Listener {
                    response ->
                    var intent = Intent(this, HomeScreen::class.java)
                    startActivity(intent)
            }, Response.ErrorListener {
                    error -> })
            requestQ.add(stringRequest)
        }

        return super.onOptionsItemSelected(item)
    }

}
