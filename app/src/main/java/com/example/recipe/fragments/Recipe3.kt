package com.example.recipe.fragments

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import com.example.recipe.R

class Recipe3 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_recipe3, container, false)
        videoPlayer(view)
        backBtn(view)
        return view
    }

    fun videoPlayer(view : View){
        var videoView : VideoView? = null
        var playButton : ImageView? = null
        var mediaController : MediaController? = null

        videoView = view.findViewById(R.id.Recipe_Video) as VideoView?
        playButton = view.findViewById(R.id.recipe_playbtn)


        // Only play the video once the button is clicked
        playButton.setOnClickListener{
            playButton.visibility = View.INVISIBLE


            Log.d("TAG", "vid1")

            if (mediaController == null){
                Log.d("TAG", "vid2")

                mediaController = MediaController(activity)
                mediaController!!.setAnchorView(videoView)
                videoView!!.setMediaController(mediaController)
                Log.d("TAG", "vid3")

                val videoURL = Uri.parse("android.resource://${activity?.packageName}/${R.raw.lasagna}")
                videoView.setLayoutParams(setDimension(videoView))

                videoView.setVideoURI(videoURL)
                videoView.requestFocus()
                videoView.start()



            }
        }




    }

    private fun setDimension(videoView: VideoView) : ViewGroup.LayoutParams {
        // Adjust the size of the video
        // so it fits on the screen
        val videoProportion = getVideoProportion()
        val screenWidth = resources.displayMetrics.widthPixels
        val screenHeight = resources.displayMetrics.heightPixels
        val screenProportion = screenHeight.toFloat() / screenWidth.toFloat()
        val lp: ViewGroup.LayoutParams = videoView.getLayoutParams()
        if (videoProportion < screenProportion) {
            lp.height = screenHeight
            lp.width = (screenHeight.toFloat() / videoProportion).toInt()
        } else {
            lp.width = screenWidth
            lp.height = (screenWidth.toFloat() * videoProportion).toInt()
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
    fun backBtn(view: View) {
        // Find back button
        val backButton: ImageView = view.findViewById(R.id.recipe1_back_btn)
        // going back to previous page
        backButton.setOnClickListener {
            Log.d("TAG", "button pressed")


            parentFragmentManager.beginTransaction().apply {
                // Finding last fragment in the backstack

                    Log.d("TAG", "Yay It's not null")
                    parentFragmentManager.popBackStack()

                    replace(R.id.frame, Home())

                    commit()


            }



        }
    }



}