package com.realllydan.offered.ui.main

import com.realllydan.offered.ui.MakeDonationView

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

    override fun displayNoDonationDetailsAddedMessage() {
        hasDisplayedNoDonationDetailsAddedMessage = true
    }

}