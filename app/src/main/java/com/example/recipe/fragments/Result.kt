package com.example.recipe.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import com.example.recipe.MainActivity
import com.example.recipe.R
import com.example.recipe.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_home.*


class Result : Fragment() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_result, container, false)
        backBtn(view)
        return view
    }

    fun backBtn(view: View) {
        // Find back button
        val backButton: ImageView = view.findViewById(R.id.Result_back_btn)
        // going back to previous page
        backButton.setOnClickListener {
            Log.d("TAG", "button pressed")


            // Finding previous page
            val lastFragEntry = parentFragmentManager.backStackEntryCount - 1
            val lastFragTag =
                parentFragmentManager.getBackStackEntryAt(lastFragEntry-1).name!!
            Log.d("TAG", lastFragTag)


            val new_fragment =
                parentFragmentManager.findFragmentByTag(lastFragTag)

            parentFragmentManager.beginTransaction().apply {
                // Finding last fragment in the backstack
                if (new_fragment != null) {
                    Log.d("TAG", "Yay It's not null")
                    parentFragmentManager.popBackStack()

                    replace(R.id.frame, Home())

                    commit()
                }

            }



        }
    }

}