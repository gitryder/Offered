package com.realllydan.offered.ui.view

import android.content.Intent
import com.realllydan.offered.data.model.Donation
import java.util.*
import kotlin.collections.ArrayList

class ViewDonationsPresenter constructor(view: AllDonationsView) {

    private var view: AllDonationsView = view

    fun shareAllDonations(data: ArrayList<Donation>) {
        val allDonationsString = getAllDonationsAsString(data)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "All Donations")
        shareIntent.putExtra(Intent.EXTRA_TEXT, allDonationsString)
        view.beginShareDonationsIntent(shareIntent);
    }

    private fun getAllDonationsAsString(data: ArrayList<Donation>): String {
        var output = "*All Donations* \n"
        for (donation in data) {
            output += "- " + donation.donorName + "\n" + "  ₹ " + donation.donationAmount + "\n\n"
        }
        return output
    }
}