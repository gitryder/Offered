package com.realllydan.offered

import com.realllydan.offered.ui.MakeDonationView

class MockView : MakeDonationView {

    companion object {
        var hasDisplayedTotalDonationAmount: Boolean = false
    }

    override fun displayTotalDonationAmount(donationAmount: Int) {
        hasDisplayedTotalDonationAmount = true
    }

}