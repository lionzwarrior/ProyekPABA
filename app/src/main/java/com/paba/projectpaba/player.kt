package com.paba.projectpaba

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class player(
    var foto : Int,
    var nama : String,
    var detail : String
) : Parcelable

