package com.example.ecommerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.transition.Slide
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.ecommerceapp.databinding.ActivityProductDetailsBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.checkerframework.checker.units.qual.A

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductDetailsBinding.inflate(layoutInflater)

        getProductDetails(intent.getStringExtra("id"))


        setContentView(binding.root)



    }

    private fun getProductDetails(proId: String?) {

        Firebase.firestore.collection("products")
            .document(proId!!).get().addOnSuccessListener {
                val list = it.get("productImages") as ArrayList<String>
                binding.textView7.text=it.getString("productName")
                binding.textView8.text=it.getString("productSp")
                binding.textView9.text=it.getString("productDescription")

                val slideList = arrayListOf<SlideModel>()
                for (data in list){
                    slideList.add(SlideModel(data,ScaleTypes.CENTER_CROP))
                }
                binding.imageSlider.setImageList(slideList)

            }
            .addOnFailureListener {

                Toast.makeText(this,"something went wrong",Toast.LENGTH_SHORT)
            }
    }
}