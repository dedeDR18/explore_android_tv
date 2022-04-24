package com.example.mytrainingtv.model

import java.io.Serializable

data class VideoItem(
    val video: Video,
    val playList: List<Video>
) : Serializable