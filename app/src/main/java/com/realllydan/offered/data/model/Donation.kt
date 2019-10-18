package com.realllydan.offered.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * A Kotlin data class to model the donation given by a user
 *
 * @param donorName The name of the one who makes the donation
 *
 * @param donationAmount The amount given by the donor
 *
 * */

@Parcelize
data class Donation (
    var donorName: String = "",
    var donationAmount: Int = 0
) : Parcelable