package com.example.ecommerceapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_sign_up.*

class  SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        SignUpBtn.setOnClickListener {
            if (edtSignUpPassword.text.toString().equals(edtSignUpRePassword.text.toString())){
                //Registration process
                val SignUpUrl = "http://192.168.43.135/EventmanAPI/join_new_user.php?email="+edtSignUpEmail.text.toString()+ "&username="+edtSignUpName.text.toString()+"&pass=" + edtSignUpPassword.text.toString()
                val requestQ = Volley.newRequestQueue(this@SignUp)
                val StringRequest =StringRequest(Request.Method.GET, SignUpUrl,
                    Response.Listener { response ->
                        if(response.equals("A user with this Email Address already exists")){
                            val dialogBuilder = AlertDialog.Builder(this)
                            dialogBuilder.setTitle("Message")
                            dialogBuilder.setMessage(response)
                            dialogBuilder.create().show()
                        }else{
                            val dialogBuilder = AlertDialog.Builder(this)
                            dialogBuilder.setTitle("Message")
                            dialogBuilder.setMessage(response)
                            dialogBuilder.create().show()
                        }
                    },
                    Response.ErrorListener { error ->
                        val dialogBuilder = AlertDialog.Builder(this)
                        dialogBuilder.setTitle("Message")
                        dialogBuilder.setMessage(error.message)
                        dialogBuilder.create().show()
                })
                requestQ.add(StringRequest)
            }else{
                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setTitle("Message")
                dialogBuilder.setMessage("Password Mismatch")
                dialogBuilder.create().show()
            }
        }
    }
}
