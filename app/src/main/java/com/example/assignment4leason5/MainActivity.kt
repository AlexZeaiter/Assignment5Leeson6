package com.example.assignment4leason5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val REQUEST_RESULT = "REQUEST_RESULT"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var users: List<User> = mutableListOf(
            User("f", "f", "First", " User"),
            User("second@test.com", "second", "Second", " User"),
            User("third@test.com", "third", "Third", " User"),
            User("fourth@test.com", "fourth", "Fourth", " User"),
            User("fifth@test.com", "fifth", "Fifth", " User")
        )


        login.setOnClickListener {

            var email = email.text.toString()
            var password = password.text.toString()

            if (email != null || email != "" || password != null || password != "") {
                for ((i, user) in users.withIndex()) {
                    if (user.emailAddress == email) {
                        if (user.passWord == password) {
                            var intent = Intent(this, ShoppingCategory::class.java)
                            intent.putExtra("username", "${user.firstName} ${user.lastName}")
                            startActivity(intent)
                        }
                    }
                    if (i == users.size) {
                        Toast.makeText(this, "Wrong Email or Password", Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                Toast.makeText(this, "Please Enter Email and Password to Login", Toast.LENGTH_LONG)
                    .show()
            }
        }

        forgotPass.setOnClickListener {
            val recipients = "Alex.Zeatar@Gmail.Com"

            val subject: String = "test"
            val message: String = "test"

            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, recipients)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, message)

            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, recipients))
        }
        var resultContracts =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                Toast.makeText(this, "BEFORE COND", Toast.LENGTH_LONG)

                if (result.resultCode == Activity.RESULT_OK) {
                    var newUser = result.data?.dataString
                    users.plus(newUser)

                    Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_LONG)
                } else {
                    Toast.makeText(this, "Failed to Create new Account", Toast.LENGTH_LONG)
                }
            }
        register.setOnClickListener {
            var intent = Intent(this, Register::class.java)
            resultContracts.launch(intent)
        }

    }
    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            Toast.makeText(
                this, Integer.toString(
                    data.getIntExtra(
                        REQUEST_RESULT,
                        0
                    )
                ), Toast.LENGTH_LONG
            ).show()
        }
    }*/


}