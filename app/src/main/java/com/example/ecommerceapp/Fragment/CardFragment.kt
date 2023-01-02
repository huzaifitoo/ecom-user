package com.example.ecommerceapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerceapp.Adapter.CartAdapter
import com.example.ecommerceapp.R
import com.example.ecommerceapp.RoomDB.AppDatabase
import com.example.ecommerceapp.databinding.FragmentCardBinding


class CardFragment : Fragment() {

    private lateinit var binding: FragmentCardBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentCardBinding.inflate(layoutInflater)

        val preferences = requireContext().getSharedPreferences("info", AppCompatActivity.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putBoolean("isCart", false)
        editor.apply()

        val dao = AppDatabase.getInstance(requireContext()).productDao()
        dao.getAllProducts().observe(requireActivity()){

            binding.cartRecycler.adapter = CartAdapter(requireContext(),it)
        }

        return binding.root
    }


}