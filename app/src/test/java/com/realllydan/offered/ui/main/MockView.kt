package com.realllydan.offered.ui.main

import com.realllydan.offered.data.model.Donation
import com.realllydan.offered.ui.make.MakeDonationView

class MockView : MakeDonationView {

    companion object {
        var hasDisplayedTotalDonationAmount = false
        var hasDisplayedNoDonationDetailsAddedMessage = false

        var totalCalculatedDonationAmount : Int = 0
    }

    override fun displayTotalDonationAmount(donationAmount: Int) {
        hasDisplayedTotalDonationAmount = true
        totalCalculatedDonationAmount = donationAmount
    }

    override fun displayNoDonationDetailsAddedError() {
        hasDisplayedNoDonationDetailsAddedMessage = true
    }

    override fun displayMessageCannotNavigateSinceEmptyList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateToViewAllDonorsActivity(allDonations: ArrayList<Donation>) {

    }
}