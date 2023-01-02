package com.example.ecommerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu

import androidx.navigation.fragment.findNavController
import com.example.ecommerceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        val navController = navHostFragment!!.findNavController()

        val popupMenu = PopupMenu(this, null)
        popupMenu.inflate(R.menu.bottom_nav)
        binding.bottomBar.setupWithNavController(popupMenu.menu, navController)


        binding.bottomBar.onItemSelected = {
            when(it){
                0-> {
                    var i = 0;
                    navController.navigate(R.id.homeFragment)
                }
                1-> i=1
                2-> i=2
            }
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (i==0){
            finish()
        }
    }
}