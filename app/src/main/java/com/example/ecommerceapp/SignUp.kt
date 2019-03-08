package com.example.ecommerceapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_sign_up.*

class  SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        SignUpBtn.setOnClickListener {
            if (edtSignUpPassword.text.toString().equals(edtSignUpRePassword)){
                //Registration process
            }else{
                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setTitle("Message")
                dialogBuilder.setMessage("Password Mismatch")
                dialogBuilder.create().show()
            }
        }
    }
}
