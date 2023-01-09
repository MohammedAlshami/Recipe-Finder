package com.example.recipe.fragments

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.recipe.R


class Recipe1() : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_recipe1, container, false)
        videoPlayer(view)
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

                val videoURL = Uri.parse("android.resource://${activity?.packageName}/${R.raw.recipe_2}")
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




}