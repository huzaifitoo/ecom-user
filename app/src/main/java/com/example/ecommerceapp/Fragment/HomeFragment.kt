package com.example.ecommerceapp.Fragment

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.ecommerceapp.Adapter.CategoryAdapter
import com.example.ecommerceapp.Adapter.ProductAdapter
import com.example.ecommerceapp.Fragment.Modal.AddProductModal
import com.example.ecommerceapp.Fragment.Modal.CategoryModal
import com.example.ecommerceapp.R
import com.example.ecommerceapp.databinding.FragmentHomeBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        val preferences =
            requireContext().getSharedPreferences("info", AppCompatActivity.MODE_PRIVATE)
        if (preferences.getBoolean("isCart", false))

            findNavController().navigate(R.id.action_homeFragment_to_cardFragment)
        getCategory()

        getProducts()

        getSliderImage()


        return binding.root
    }

    private fun getSliderImage() {
        Firebase.firestore.collection("slider").document("item").get().addOnSuccessListener {

                Glide.with(requireContext()).load(it.get("img")).into(binding.sliderimage)
            }
    }

    private fun getCategory() {
        val list = ArrayList<CategoryModal>()
        Firebase.firestore.collection("categories").get().addOnSuccessListener {
                list.clear()
                for (doc in it.documents) {
                    val data = doc.toObject(CategoryModal::class.java)
                    list.add(data!!)
                }
                binding.rcCategory.adapter = CategoryAdapter(requireContext(), list)
            }
    }


    private fun getProducts() {
        val list = ArrayList<AddProductModal>()
        Firebase.firestore.collection("products").get().addOnSuccessListener {
                list.clear()
                for (doc in it.documents) {
                    val data = doc.toObject(AddProductModal::class.java)
                    list.add(data!!)
                }
                binding.rcProducts.adapter = ProductAdapter(requireContext(), list)
            }


    }
}