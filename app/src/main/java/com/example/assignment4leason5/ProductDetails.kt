package com.example.assignment4leason5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        if(intent.hasExtra("image") && intent.hasExtra("title")&& intent.hasExtra("price")&& intent.hasExtra("color")&& intent.hasExtra("desc")){
            var ig =intent.getIntExtra("image",0)
            var t1 = intent.getStringExtra("title").toString()
            var t2 = intent.getStringExtra("desc").toString()
            var t3 = intent.getStringExtra("price").toString()
            var t4 = intent.getStringExtra("color").toString()

            name.text = "Name : $t1"
            desc.text = "Description : $t2"
            price.text = "Price : $t3$"
            color.text = "Color : $t4"
            imageView.setImageResource(ig)
        }

    }
}