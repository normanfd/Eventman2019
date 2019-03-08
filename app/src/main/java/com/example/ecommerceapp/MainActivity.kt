package com.example.ecommerceapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            val loginURL = "http://192.168.42.211/EventmanAPI/login_app_user.php?" +
                    "email=" +
                    edtLoginEmail.text.toString() +
                    "&pass=" +
                    edtLoginPassword.text.toString()
            val requestQ = Volley.newRequestQueue(this@MainActivity)
            val stringRequest = StringRequest(Request.Method.GET, loginURL, Response.Listener { response ->
                if (response.equals("The user does exist")) {
                    Person.email = edtLoginEmail.text.toString()
                    Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()
                    val homeIntent = Intent(this@MainActivity, HomeScreen::class.java)
                    startActivity(homeIntent)
                } else {
                    val dialogBuilder = AlertDialog.Builder(this)
                    dialogBuilder.setTitle("Message")
                    dialogBuilder.setMessage(response)
                    dialogBuilder.create().show()
                }
            }, Response.ErrorListener { error ->
                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setTitle("Message")
                dialogBuilder.setMessage(error.message)
                dialogBuilder.create().show()
            })

            requestQ.add(stringRequest)
        }

        btnSignUp.setOnClickListener {
            val SignUpIntent = Intent(this@MainActivity, SignUp::class.java)
            startActivity(SignUpIntent)
        }
    }
}
