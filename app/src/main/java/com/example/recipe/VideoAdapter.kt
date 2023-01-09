package com.example.recipe

import android.media.Image
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.fragments.*
import kotlinx.android.synthetic.main.tiktok_video.view.*
import java.util.*


class VideoAdapter(arrVideo:ArrayList<VideoModel>) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    var arrVideoModel:ArrayList<VideoModel> = arrVideo

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        var inf = LayoutInflater.from(parent.context).inflate(R.layout.tiktok_video, parent, false)
        val view =  VideoViewHolder(inf)
        var recipebtn : ImageView = inf.findViewById(R.id.tiktok_lasagna)

        val manager = (inf.context as FragmentActivity).supportFragmentManager

        commitChange(recipebtn, Recipe3(), "recip3", manager)

        return view
    }

    override fun getItemCount(): Int {
        return arrVideoModel.size
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.setVideoData(arrVideoModel[position])
    }

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun setVideoData(videoModel: VideoModel){

            itemView.userid.text= videoModel.userid
//            itemView.song_image.setBackgroundResource(videoModel.songUrl)
//            itemView.user_profile_image.setBackgroundResource(videoModel.profileUrl)
            itemView.tvDesc.text = videoModel.videoDesc
            itemView.videoView.setVideoURI(videoModel.videoUrl)

            itemView.videoView.setOnPreparedListener(object :MediaPlayer.OnPreparedListener{
                override fun onPrepared(mp: MediaPlayer) {
                    itemView.progressBar.visibility = View.GONE
                    mp.start()
                    val videoRatio = mp.videoWidth.toFloat() / mp.videoHeight.toFloat()
                    val screenRatio = itemView.videoView.width.toFloat() / itemView.videoView.height.toFloat()

                    var scale = videoRatio / screenRatio
                    scale = 1.5f
                    Log.d("Video Test", scale.toString())
                    if (scale > 1f){
                        itemView.videoView.scaleX = 1f
                    }else{
                        itemView.videoView.scaleY = .1f
                    }
                }

            })

            itemView.videoView.setOnCompletionListener { object : MediaPlayer.OnCompletionListener{
                override fun onCompletion(mp: MediaPlayer) {
                    mp.start()
                }
            } }

        }

    }

    fun commitChange(
        linearLayout: ImageView,
        new_fragment: Fragment,
        fragment_name: String,
        parentFragmentManager:  FragmentManager
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