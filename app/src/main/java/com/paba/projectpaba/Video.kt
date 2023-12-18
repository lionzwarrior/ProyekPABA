package com.paba.projectpaba

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Video (
    val title: String,
    val image: String,
    val description: String,
    val id: String
) : Parcelable