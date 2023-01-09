package com.example.recipe

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.recipe.databinding.ActivityMainBinding
import com.example.recipe.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity : AppCompatActivity() {


    private lateinit var bottomNavView: BottomNavigationView

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initializing binding + binding setup
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

        //hiding the top action bar
        supportActionBar?.hide()
        bottomNavView = binding.bottomNavView

        // Setting default fragment
        replaceFragment(Home(), "home")

        // putting a listener to detect user input and act on it
        bottomNavView.setOnItemSelectedListener {

            //Using a switch case (the id used here are declared in menu folder
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(Home(), "home")

                }
                R.id.explore -> {
                    replaceFragment(Explore(), "explore")
                }
                R.id.camera -> {
                    var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivity(intent)
                    replaceFragment(Home(), "camera")
                }
                R.id.upload -> {
//                    replaceFragment(Upload())
                    replaceFragment(Upload(), "upload")
                }
                R.id.profile -> {
                    replaceFragment(Profile(), "profile")
                }
            }
            true
        }


    }

    private fun replaceFragment(fragment: Fragment, fragment_name: String) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame, fragment, fragment_name)

            val lastFragEntry = supportFragmentManager.backStackEntryCount - 1
            if (lastFragEntry >= 0) {
                val lastFragTag = supportFragmentManager.getBackStackEntryAt(lastFragEntry).name!!
                if (fragment_name != lastFragTag) {
                    addToBackStack(fragment_name)

                }
            } else {
                addToBackStack(fragment_name)
            }

            commit()
        }

    }


    // overriding back button and handling the menu when navigating
    override fun onBackPressed(){

        super.onBackPressed()
        Log.d("TAG", "shittt")
        val lastFragEntry = supportFragmentManager.backStackEntryCount - 1
        val item : String
        if (lastFragEntry >= 0) {
            item = supportFragmentManager.getBackStackEntryAt(lastFragEntry).name!!
            val BottomNavigationView = binding.bottomNavView



            when(item){
                "home" -> BottomNavigationView.menu.getItem(0).isChecked = true
                "explore" -> BottomNavigationView.menu.getItem(1).isChecked = true
                "camera" -> BottomNavigationView.menu.getItem(2).isChecked = true
                "upload" -> BottomNavigationView.menu.getItem(3).isChecked = true
                "profile" -> BottomNavigationView.menu.getItem(4).isChecked = true
            }
        Log.d("TAG", "pressed")
    }


    }

}


