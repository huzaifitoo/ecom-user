package com.example.ecommerceapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerceapp.CategoryActivity
import com.example.ecommerceapp.Fragment.Modal.CategoryModal
import com.example.ecommerceapp.R
import com.example.ecommerceapp.databinding.LayoutCategoryItemBinding

class CategoryAdapter(var context: Context, var list: ArrayList<CategoryModal>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = LayoutCategoryItemBinding.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        return CategoryViewHolder(
            LayoutInflater.from(context).inflate(R.layout.layout_category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.binding.textview2.text = list[position].cate
        Glide.with(context).load(list[position].img).into(holder.binding.imageview)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, CategoryActivity::class.java)
            intent.putExtra("cat", list[position].cate)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }


}