package com.example.recipe.fragments

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.recipe.R
import com.example.recipe.VideoAdapter
import com.example.recipe.VideoModel
import kotlinx.android.synthetic.main.fragment_explore.view.*
import kotlinx.android.synthetic.main.tiktok_video.view.*


class Explore : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_explore, container, false)
        shorts(view)
        return view
    }

    private fun shorts(view: View) {
        val arrVideoModel = ArrayList<VideoModel>()
        var videoAdapter: VideoAdapter? = null
//        var viewPager : ViewPager? = view.findViewById(R.id.viewPager)
        var videoURL = Uri.parse("android.resource://${activity?.packageName}/${R.raw.short1}")


        arrVideoModel.add(
            VideoModel(
                "Ramzy",
                "This is Ramzy's video",
                videoURL,
                R.drawable.user_profile,
                R.drawable.user_profile
            )

        )
        videoURL = Uri.parse("android.resource://${activity?.packageName}/${R.raw.shorts5}")
        arrVideoModel.add(
            VideoModel(
                "Shami",
                "Lasgana Recipe",
                videoURL,
                R.drawable.user_profile,
                R.drawable.user_profile
            )
        )

        videoURL = Uri.parse("android.resource://${activity?.packageName}/${R.raw.shorts3}")
        arrVideoModel.add(
            VideoModel(
                "Shami",
                "This is Shami's video",
                videoURL,
                R.drawable.user_profile,
                R.drawable.user_profile
            )
        )
        videoURL = Uri.parse("android.resource://${activity?.packageName}/${R.raw.shorts4}")
        arrVideoModel.add(
            VideoModel(
                "Shami",
                "This is Shami's video",
                videoURL,
                R.drawable.user_profile,
                R.drawable.user_profile
            )
        )
//        arrVideoModel.add(
//            VideoModel(
//                "Shami",
//                "This is Shami's video",
//                "https://i.imgur.com/LMMfjMZ.mp4",
//                R.drawable.user_profile,
//                R.drawable.user_profile
//            )
//        )
//
//        arrVideoModel.add(
//            VideoModel(
//                "Shami",
//                "This is Shami's video",
//                "https://i.imgur.com/LMMfjMZ.mp4",
//                R.drawable.user_profile,
//                R.drawable.user_profile
//            )
//        )
//


        videoAdapter = VideoAdapter(arrVideoModel)




        view.viewPager.adapter = videoAdapter
//        commitChange(view.viewPager.tiktok_lasagna, Recipe3(), "recip3")


    }


    fun commitChange(
        linearLayout: ImageView,
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