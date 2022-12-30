package com.example.ecommerceapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerceapp.Fragment.Modal.AddProductModal
import com.example.ecommerceapp.ProductDetailsActivity
import com.example.ecommerceapp.databinding.ItemCategoryProductLayoutBinding

class CategoryProductAdapter(val context: Context, val list : ArrayList<AddProductModal>) : RecyclerView.Adapter<CategoryProductAdapter.CategoryProductViewHolder>() {
   inner class CategoryProductViewHolder(val binding: ItemCategoryProductLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryProductViewHolder {
       val binding = ItemCategoryProductLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return CategoryProductViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CategoryProductViewHolder, position: Int) {
        Glide.with(context).load(list[position].productCoverImg).into(holder.binding.imageView3)

        holder.binding.textView5.text=list[position].productName
        holder.binding.texView6.text=list[position].productSp

        holder.itemView.setOnClickListener {
            val intent = Intent (context,ProductDetailsActivity::class.java)
            intent.putExtra("id",list[position].productId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}