package com.example.recipe.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.recipe.R
import com.example.recipe.fragments.IngredientsOptions.IngredientsFruits
import com.example.recipe.fragments.IngredientsOptions.IngredientsMeat
import com.example.recipe.fragments.IngredientsOptions.IngredientsSpices

class Ingredients : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ingredients_vege, container, false)
        recipeOptions(view)
        searchOptions(view)
        return view
    }

    fun recipeOptions(view: View) {
        val addBtn1: ImageView = view.findViewById(R.id.ingredient_vege_add1)
        val addBtn2: ImageView = view.findViewById(R.id.ingredient_vege_add2)
        val addBtn3: ImageView = view.findViewById(R.id.ingredient_vege_add3)
        val addBtn4: ImageView = view.findViewById(R.id.ingredient_vege_add4)
        val addBtn5: ImageView = view.findViewById(R.id.ingredient_vege_add5)
        val addBtn6: ImageView = view.findViewById(R.id.ingredient_vege_add6)
        val addBtn7: ImageView = view.findViewById(R.id.ingredient_vege_add7)
        val addBtn8: ImageView = view.findViewById(R.id.ingredient_vege_add8)
        val addBtn9: ImageView = view.findViewById(R.id.ingredient_vege_add9)
        val addBtn10: ImageView = view.findViewById(R.id.ingredient_vege_add10)
        val addBtn11: ImageView = view.findViewById(R.id.ingredient_vege_add11)
        val addBtn12: ImageView = view.findViewById(R.id.ingredient_vege_add12)

        val b1 = 0;
        val b2 = 0;
        val b3 = 0;
        val b4 = 0;
        val b5 = 0;
        val b6 = 0;
        val b7 = 0;
        val b8 = 0;
        val b9 = 0;
        val b10 = 0;
        val b11 = 0;
        val b12 = 0;
        val b = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

        addBtn1.setOnClickListener {
            if (b[0] == 0){
                addBtn1.setBackgroundResource(R.drawable.ic_baseline_remove_circle_outline_24)
                b[0] = 1;
            }
            else {
                b[0] = 0;
                addBtn1.setBackgroundResource(R.drawable.ic_baseline_add_circle_outline_24)

            }
        }
        addBtn2.setOnClickListener {
            if (b[1] == 0){
                addBtn2.setBackgroundResource(R.drawable.ic_baseline_remove_circle_outline_24)
                b[1] = 1;
            }
            else {
                b[1] = 0;
                addBtn2.setBackgroundResource(R.drawable.ic_baseline_add_circle_outline_24)

            }
        }
        addBtn3.setOnClickListener {
            if (b[2] == 0){
                addBtn3.setBackgroundResource(R.drawable.ic_baseline_remove_circle_outline_24)
                b[2] = 1;
            }
            else {
                b[2] = 0;
                addBtn3.setBackgroundResource(R.drawable.ic_baseline_add_circle_outline_24)

            }
        }
        addBtn4.setOnClickListener {
            if (b[3] == 0){
                addBtn4.setBackgroundResource(R.drawable.ic_baseline_remove_circle_outline_24)
                b[3] = 1;
            }
            else {
                b[3] = 0;
                addBtn4.setBackgroundResource(R.drawable.ic_baseline_add_circle_outline_24)

            }
        }
        addBtn5.setOnClickListener {
            if (b[4] == 0){
                addBtn5.setBackgroundResource(R.drawable.ic_baseline_remove_circle_outline_24)
                b[4] = 1;
            }
            else {
                b[4] = 0;
                addBtn5.setBackgroundResource(R.drawable.ic_baseline_add_circle_outline_24)

            }
        }
        addBtn6.setOnClickListener {
            if (b[5] == 0){
                addBtn6.setBackgroundResource(R.drawable.ic_baseline_remove_circle_outline_24)
                b[5] = 1;
            }
            else {
                b[5] = 0;
                addBtn6.setBackgroundResource(R.drawable.ic_baseline_add_circle_outline_24)

            }
        }
        addBtn7.setOnClickListener {
            if (b[6] == 0){
                addBtn7.setBackgroundResource(R.drawable.ic_baseline_remove_circle_outline_24)
                b[6] = 1;
            }
            else {
                b[7] = 0;
                addBtn7.setBackgroundResource(R.drawable.ic_baseline_add_circle_outline_24)

            }
        }
        addBtn8.setOnClickListener {
            if (b[8] == 0){
                addBtn8.setBackgroundResource(R.drawable.ic_baseline_remove_circle_outline_24)
                b[7] = 1;
            }
            else {
                b[7] = 0;
                addBtn8.setBackgroundResource(R.drawable.ic_baseline_add_circle_outline_24)

            }
        }
        addBtn9.setOnClickListener {
            if (b[8] == 0){
                addBtn9.setBackgroundResource(R.drawable.ic_baseline_remove_circle_outline_24)
                b[8] = 1;
            }
            else {
                b[8] = 0;
                addBtn9.setBackgroundResource(R.drawable.ic_baseline_add_circle_outline_24)

            }
        }
        addBtn10.setOnClickListener {
            if (b[9] == 0){
                addBtn10.setBackgroundResource(R.drawable.ic_baseline_remove_circle_outline_24)
                b[9] = 1;
            }
            else {
                b[9] = 0;
                addBtn10.setBackgroundResource(R.drawable.ic_baseline_add_circle_outline_24)

            }
        }
        addBtn11.setOnClickListener {
            if (b[10] == 0){
                addBtn11.setBackgroundResource(R.drawable.ic_baseline_remove_circle_outline_24)
                b[10] = 1;
            }
            else {
                b[10] = 0;
                addBtn11.setBackgroundResource(R.drawable.ic_baseline_add_circle_outline_24)

            }
        }
        addBtn12.setOnClickListener {
            if (b[11] == 0){
                addBtn12.setBackgroundResource(R.drawable.ic_baseline_remove_circle_outline_24)
                b[11] = 1;
            }
            else {
                b[11] = 0;
                addBtn12.setBackgroundResource(R.drawable.ic_baseline_add_circle_outline_24)

            }
        }

    }
    fun searchOptions(view: View) {
        var vege: LinearLayout = view.findViewById(R.id.ingredient_search_vegetables)
        var spices: LinearLayout = view.findViewById(R.id.ingredient_search_spices)
        var meat: LinearLayout = view.findViewById(R.id.ingredient_search_meat)
        var fruits: LinearLayout = view.findViewById(R.id.ingredient_search_fruits)


        val fragments: Array<Fragment> = arrayOf(IngredientsVege(), IngredientsSpices(), IngredientsMeat(), IngredientsFruits())

        // Function to replace fragments on click

        commitChange(vege, fragments[0], "ingredient_search_vegetables")
        commitChange(spices, fragments[1], "ingredient_search_spices")
        commitChange(meat, fragments[2], "ingredient_search_meat")
        commitChange(fruits, fragments[3], "ingredient_search_fruits")


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

}