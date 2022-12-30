package com.example.ecommerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.ecommerceapp.Adapter.CategoryProductAdapter
import com.example.ecommerceapp.Adapter.ProductAdapter
import com.example.ecommerceapp.Fragment.Modal.AddProductModal
import com.example.ecommerceapp.databinding.ActivityCategoryBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getProducts(intent.getStringExtra("cat"))
    }

    private fun getProducts(category: String?) {

        val list = ArrayList<AddProductModal>()
        Firebase.firestore.collection("products").whereEqualTo("productCategory",category)
            .get().addOnSuccessListener {
                list.clear()
                for (doc in it.documents) {
                    val data = doc.toObject(AddProductModal::class.java)
                    list.add(data!!)
                }
                binding.recyclerView.adapter = CategoryProductAdapter(this, list)
            }
    }
}