package com.example.assignment4leason5

import android.app.Activity
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        createAccount.setOnClickListener {
            if (firstName.text.toString() == null || firstName.text.toString() == "") {
                Toast.makeText(this, "Please Enter Your First Name", Toast.LENGTH_LONG).show()
            } else if (lastName.text.toString() == null || firstName.text.toString() == "") {
                Toast.makeText(this, "Please Enter Your Last Name", Toast.LENGTH_LONG).show()
            } else if (emailAddress.text.toString() == null || emailAddress.text.toString() == "") {
                Toast.makeText(this, "Please Enter Your Email Address", Toast.LENGTH_LONG).show()
            } else if (password.text.toString() == null || password.text.toString() == "") {
                Toast.makeText(this, "Please Enter Your Password", Toast.LENGTH_LONG).show()
            } else {
                var firstNameText = firstName.text.toString()
                var lastNameText = lastName.text.toString()
                var emailAddressText = emailAddress.text.toString()
                var passwordText = password.text.toString()
                var user = User(firstNameText, lastNameText, emailAddressText, passwordText)

                var rintent = intent

                rintent.data = Uri.parse("tEST tEXT")
                setResult(Activity.RESULT_OK, rintent)


                finish()
            }
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}