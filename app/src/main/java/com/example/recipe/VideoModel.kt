package com.example.recipe

import android.net.Uri

data class VideoModel(
    var userid:String,
    var videoDesc:String,
    var videoUrl: Uri, var profileUrl:Int, var songUrl:Int)