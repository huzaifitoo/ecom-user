package com.example.ecommerceapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerceapp.Fragment.Modal.AddProductModal
import com.example.ecommerceapp.ProductDetailsActivity
import com.example.ecommerceapp.databinding.LayoutProductItemBinding

class ProductAdapter(val context: Context, val list : ArrayList<AddProductModal>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
   inner class ProductViewHolder (var binding: LayoutProductItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
       val binding = LayoutProductItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val data = list[position]

        Glide.with(context).load(data.productCoverImg).into(holder.binding.imageView)
        holder.binding.textview1.text=data.productName
        holder.binding.textview2.text=data.productCategory
        holder.binding.textview3.text=data.productMrp

        holder.binding.button1.text= data.productSp

        holder.itemView.setOnClickListener {
            val intent = Intent (context, ProductDetailsActivity::class.java)
            intent.putExtra("id",list[position].productId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }


}