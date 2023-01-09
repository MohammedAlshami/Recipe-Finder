package com.example.recipe.fragments

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.recipe.MainActivity
import com.example.recipe.R
import com.example.recipe.fragments.results.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.tiktok_video.view.*

import android.media.MediaPlayer

class Home : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        var view = inflater.inflate(R.layout.fragment_home, container, false)
        val listView: ListView = view.findViewById(R.id.userList)
        listView.visibility = View.GONE
        search(view)
        changePage(view)
        searchOptions(view)
        videoPlayer(view)
        return view
    }

    fun search(view: View) {

        backBtn(view)








        lateinit var listView: ListView
        var arrayAdapter: ArrayAdapter<String>? = null
        lateinit var search: SearchView
        lateinit var linearLayout: LinearLayout
        lateinit var saerchOptions: LinearLayout
        lateinit var bgStyle: ImageView


        // Data
        var months =
            arrayOf(
                "Western",
                "Middle Eastern",
                "Malay",
                "Indian",
                "Chicken Recipe",
                "Rice",
                "Chinese",
                "spaghetti",
                "Fish",
                "Tandoori",
                "Yemeni",
                "Vietnamese",
                "gordon ramsay"

            )
        arrayAdapter = activity?.let {
            ArrayAdapter<String>(
                it,
                android.R.layout.simple_list_item_1,
                months
            )
        }



        listView = view.findViewById(R.id.userList)
        search = view.findViewById(R.id.searchfun)
        linearLayout = view.findViewById(R.id.home_components)
        saerchOptions = view.findViewById(R.id.home_search_options)
        bgStyle = view.findViewById(R.id.bg_style)
        val backButton: ImageView = view.findViewById(R.id.searchBarBtn)

        var searchRecipes: LinearLayout = view.findViewById(R.id.search_recipes)
        searchRecipes.setOnClickListener{
            listView.visibility = View.VISIBLE
            linearLayout.visibility = View.GONE
            saerchOptions.visibility = View.GONE
            backButton.visibility = View.VISIBLE

        }

        listView.adapter = arrayAdapter
        goToSearchResult(listView)

        // Default settings
        listView.visibility = View.GONE
        bgStyle.visibility = View.VISIBLE
        linearLayout.visibility = View.VISIBLE
        saerchOptions.visibility = View.GONE
        backButton.visibility = View.GONE


        search.setOnClickListener(View.OnClickListener {
            search.setIconified(false)
            bgStyle.visibility = View.GONE
            linearLayout.visibility = View.GONE
            saerchOptions.visibility = View.VISIBLE
            backButton.visibility = View.VISIBLE
            listView.visibility = View.GONE

            val inputMethodManager =
                activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

        })


        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                search.clearFocus()
                if (months.contains(query)) {
//                    listView.visibility = View.VISIBLE
                    arrayAdapter!!.filter.filter(query)
                }

                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
//               listView.adapter = arrayAdapter
//                listView.visibility = View.VISIBLE
                Log.d("Tag", "you're writing something")
                listView.visibility = View.VISIBLE
                linearLayout.visibility = View.GONE
                saerchOptions.visibility = View.GONE
                arrayAdapter!!.filter.filter(query)
                backButton.visibility = View.VISIBLE
                return false
            }
        })


    }

    fun changePage(view: View) {
        var linearLayout1: LinearLayout = view.findViewById(R.id.top_recipe_first)
        var linearLayout2: LinearLayout = view.findViewById(R.id.top_recipe_second)
        var linearLayout3: LinearLayout = view.findViewById(R.id.top_recipe_third)

        val fragments: Array<Fragment> = arrayOf(Result(), Recipe2(), Recipe3())

        // Function to replace fragments on click

        commitChange(linearLayout1, fragments[0], "top_recipe_first")
        commitChange(linearLayout2, fragments[1], "top_recipe_second")
        commitChange(linearLayout3, fragments[2], "top_recipe_second")

    }

    fun backBtn(view: View) {
        // Find back button
        val listView: ListView = view.findViewById(R.id.userList)

        val backButton: ImageView = view.findViewById(R.id.searchBarBtn)
        val linearLayout: LinearLayout = view.findViewById(R.id.home_components)
        val saerchOptions: LinearLayout = view.findViewById(R.id.home_search_options)
        val bgStyle: ImageView = view.findViewById(R.id.bg_style)

        val inputMethodManager =
            activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager

        // going back to previous page
        backButton.setOnClickListener {

            parentFragmentManager.beginTransaction().apply {
                // Finding last fragment in the backstack

                replace(R.id.frame, Home())
                backButton.visibility = View.GONE
                bgStyle.visibility = View.VISIBLE
                linearLayout.visibility = View.VISIBLE
                saerchOptions.visibility = View.GONE
                listView.visibility = View.INVISIBLE
                inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

                commit()
            }

        }


    }

    fun goToSearchResult(listView: ListView) {

        var resultFragments = mapOf<String, Fragment>(
            "Western" to Western(),
            "Middle Eastern" to Middle(),
            "Malay" to Malay(),
            "Indian" to Indian(),
            "Chicken Recipe" to Chicken(),
            "Rice" to Rice(),
            "Chinese" to Chinese(),
            "Spaghetti" to Spaghetti(),
            "Fish" to Fish(),
            "Tandoori" to Tandoori(),
            "Yemeni" to Yemeni(),
            "Vietnamese" to Vietnamese()

        )
        val inputMethodManager =
            activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        listView.setOnItemClickListener { parent, view, position, id ->
            // Get selected item name
            val selectedFromList = listView.getItemAtPosition(position) as String
            parentFragmentManager.beginTransaction().apply {
                // Finding last fragment in the backstack
                // find the item in the list using teh key then replace the fragment
                resultFragments[selectedFromList]?.let { replace(R.id.frame, it) }
                addToBackStack(selectedFromList)
                inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

                commit()
            }

        }
    }

    fun searchOptions(view: View) {
        var searchIngredient: LinearLayout = view.findViewById(R.id.search_ingredients)
        var searchRecipes: LinearLayout = view.findViewById(R.id.search_recipes)
        var searchImage: LinearLayout = view.findViewById(R.id.search_image)

        val fragments: Array<Fragment> = arrayOf(IngredientsVege(), Recipe2(), Camera())

        // Function to replace fragments on click

        commitChange(searchIngredient, fragments[0], "search_ingredients")
//        commitChange(searchRecipes, fragments[1], "search_recipes")
        commitChange(searchImage, fragments[2], "search_image")



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
     fun onBackPressed(view: View){

         activity?.onBackPressed()

        val lastFragEntry = parentFragmentManager.backStackEntryCount - 1
        val item : String
        if (lastFragEntry >= 0) {
            item = parentFragmentManager.getBackStackEntryAt(lastFragEntry).name!!
            val BottomNavigationView = view.bottomNavView

            when(item){
                "home" -> BottomNavigationView.menu.getItem(0).isChecked = true
                "explore" -> BottomNavigationView.menu.getItem(1).isChecked = true
                "camera" -> BottomNavigationView.menu.getItem(2).isChecked = true
                "upload" -> BottomNavigationView.menu.getItem(3).isChecked = true
                "profile" -> BottomNavigationView.menu.getItem(4).isChecked = true
            }
        }


    }




    fun videoPlayer(view : View){
        var videoView1 : VideoView? = null
        var videoView2 : VideoView? = null
        var videoView3 : VideoView? = null


        videoView1 = view.findViewById(R.id.HomeVid1) as VideoView?
        videoView2 = view.findViewById(R.id.HomeVid2) as VideoView?
        videoView3 = view.findViewById(R.id.HomeVid3) as VideoView?

        fun playHomeVideo(videoView: VideoView?, video : Int, height: Int, width: Int){
            var mediaController : MediaController? = null

            if (mediaController == null){

                mediaController = MediaController(activity)
                mediaController!!.hide()
                mediaController!!.setAnchorView(videoView)

                videoView!!.setMediaController(mediaController)

                val videoURL = Uri.parse("android.resource://${activity?.packageName}/${video}")
                videoView.setLayoutParams(setDimension(videoView, height, width))

                videoView
                videoView.setVideoURI(videoURL)
//                videoView.requestFocus()
                videoView.start()



            }
        }


        playHomeVideo(videoView1, R.raw.shorts4, 1000, 1000)
        playHomeVideo(videoView2, R.raw.lasagna, 1000, 700)
        playHomeVideo(videoView3, R.raw.lasagna_2, 1000, 700)





    }

    private fun setDimension(videoView: VideoView, height : Int, width: Int) : ViewGroup.LayoutParams {
        // Adjust the size of the video
        // so it fits on the screen


        val videoProportion = getVideoProportion()
        val screenWidth = resources.displayMetrics.widthPixels
        val screenHeight = resources.displayMetrics.heightPixels
        val screenProportion = screenHeight.toFloat() / screenWidth.toFloat()
        val lp: ViewGroup.LayoutParams = videoView.getLayoutParams()
        if (videoProportion < screenProportion) {

            lp.height = height
            Log.d("Size1 (Height): ", lp.height.toString())
            lp.width = width
            Log.d("Size1 (width): ", lp.width.toString())
        } else {
            lp.width = screenWidth
            Log.d("Size2: ", lp.width.toString())

            lp.height = (screenWidth.toFloat() * videoProportion).toInt()
            Log.d("Size2: ", lp.height.toString())

        }

        return lp

    }

    // This method gets the proportion of the video that you want to display.
    // I already know this ratio since my video is hardcoded, you can get the
    // height and width of your video and appropriately generate  the proportion
    //    as :height/width
    private fun getVideoProportion(): Float {
        return 1.5f
    }



}
