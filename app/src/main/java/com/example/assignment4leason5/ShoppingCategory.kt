package com.example.assignment4leason5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategory : AppCompatActivity() {
    val list = arrayListOf<Product>()
    var macbook = Product("Mac Book", 20.00,"Black", "macbook", "1", "Testing Mac Book Desc")
    var iphone = Product("Iphone", 10.00,"Blue", "iphone", "2", "Testing Iphone Desc")
    var alienware = Product("Alienware", 30.00,"Red", "alienware", "3", "Testing Alienware Desc")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)
        list.plus(macbook)
        list.plus(iphone)
        list.plus(alienware)

        val sintent = intent
        var userName = sintent.getStringExtra("username")

        var welcomeMessage = "Welcome $userName"

        username.text = welcomeMessage
    }

    fun click(view: View) {
        when (view.id) {
            R.id.electronics -> {
                var intent = Intent(this, ProductList::class.java)
                intent.putExtra("productlist", list.toString())
                startActivity(intent)
            }
            R.id.clothes -> {
                Toast.makeText(this, "You have chosen Clothes", Toast.LENGTH_LONG).show()
            }
            R.id.makeup -> {
                Toast.makeText(this, "You have chosen Makeup", Toast.LENGTH_LONG).show()
            }
            R.id.food -> {
                Toast.makeText(this, "You have chosen Food", Toast.LENGTH_LONG).show()
            }
        }
    }
}