package com.example.recipe.fragments.results

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.recipe.R
import com.example.recipe.fragments.Camera
import com.example.recipe.fragments.Recipe3
import com.example.recipe.fragments.Recipe4


class Western : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_western, container, false)


        val likebtn: ImageView = view.findViewById(R.id.likerecipe)
        likebtn.setOnClickListener{
            val bgShape = likebtn.getBackground() as GradientDrawable
            bgShape.setColor(Color.RED)
        }



        recipeOptions(view)
        backBtn(view)
        return view
    }

    fun recipeOptions(view: View) {
        var recipe1: LinearLayout = view.findViewById(R.id.result_recipe_1)
        var recipe2: LinearLayout = view.findViewById(R.id.result_recipe_2)
        var recipe3: LinearLayout = view.findViewById(R.id.result_recipe_3)
        var recipe4: LinearLayout = view.findViewById(R.id.result_recipe_4)
        var recipe5: LinearLayout = view.findViewById(R.id.result_recipe_5)
        var recipe6: LinearLayout = view.findViewById(R.id.result_recipe_6)


        val fragments: Array<Fragment> = arrayOf(Recipe3(), Recipe3(), Camera())

        // Function to replace fragments on click

        commitChange(recipe1, fragments[0], "recip1")
        commitChange(recipe2, fragments[1], "recip2")
        commitChange(recipe3, fragments[0], "recip3")
        commitChange(recipe4, fragments[0], "recip4")
        commitChange(recipe5, fragments[0], "recip5")
        commitChange(recipe6, fragments[0], "recip6")


    }

    fun commitChange(
        linearLayout: LinearLayout,
        new_fragment: Fragment,
        fragment_name: String
    ) {
        linearLayout.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frame, new_fragment)

                //Handling backBtn
                val lastFragEntry = parentFragmentManager.backStackEntryCount - 1
                if (lastFragEntry >= 0) {
                    val lastFragTag =
                        parentFragmentManager.getBackStackEntryAt(lastFragEntry).name!!
                    if (fragment_name != lastFragTag) {
                        addToBackStack(fragment_name)
                    }
                } else {
                    addToBackStack(fragment_name)
                }
                commit()
            }

        }
    }
    fun backBtn(view: View) {
        // Find back button
        val backButton: ImageView = view.findViewById(R.id.recipe1_back_btn)
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

                    replace(R.id.frame, new_fragment)

                    commit()
                }

            }



        }
    }

}