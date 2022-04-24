package com.example.mytrainingtv.model

import java.io.Serializable

data class Video(
    val id: String = "",
    val title: String? = null,
    val description: String? = null,
    val backgroundImageUrl: String? = null,
    val cardImageUrl: String? = null,
    val channel: String? = null
) : Serializable