package com.example.assignment4leason5

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.product_item.view.*
import java.lang.reflect.Field


class MyAdapter (var plist: ArrayList<Product>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent,false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

        val context: Context = holder.itemView.imageView.getContext()
        val resID: Int = context.resources.getIdentifier(
            plist[position].image, "drawable",
            context.packageName
        )
        holder.itemView.imageView.setImageResource(resID)

        holder.itemView.name.text = "Name :" + plist[position].Title
        holder.itemView.price.text = "Price :" + plist[position].price.toString() + "$"
        holder.itemView.color.text = "Color :" + plist[position].color
        holder.itemView.playout.setOnClickListener{
            val intent = Intent(context, ProductDetails::class.java)

            var res = plist[position]
            intent.putExtra("image", resID)
            intent.putExtra("title", plist[position].Title)
            intent.putExtra("price", plist[position].price.toString())
            intent.putExtra("color",plist[position].color)
            intent.putExtra("desc",plist[position].desc)
            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return plist.size
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}