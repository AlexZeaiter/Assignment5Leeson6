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
            var t1 = intent.getStringExtra("title")
            var t2 = intent.getStringExtra("desc")
            var t3 = intent.getStringExtra("price")
            var t4 = intent.getStringExtra("color")

            name.text = t1.toString()
            desc.text = t2.toString()
            price.text = t3.toString()
            color.text = t4.toString()
            imageView.setImageResource(ig)
        }

    }
}