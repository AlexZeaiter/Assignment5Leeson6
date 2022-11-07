package com.example.assignment4leason5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_product_list.*

class ProductList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)


        var list = ArrayList<Product>()
        var macbook = Product("Mac Book", 20.00,"Black", "macbook", "1", "Testing Mac Book Desc")
        var iphone = Product("Iphone", 10.00,"Blue", "iphone", "2", "Testing Iphone Desc")
        var alienware = Product("Alienware", 30.00,"Red", "alienware", "3", "Testing Alienware Desc")
        list.add(macbook)
        list.add(iphone)
        list.add(alienware)
        val adapter = MyAdapter(list)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

    }
}