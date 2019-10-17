package com.realllydan.offered

import com.realllydan.offered.data.model.Donation
import com.realllydan.offered.ui.MakeDonationPresenter
import com.realllydan.offered.ui.MakeDonationView
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MakeDonationPresenterTest {

    companion object {
        private const val DONOR_NAME = "Generic Donor Name"
        private const val DONATION_AMOUNT = 100
    }

    private lateinit var makeDonationView: MakeDonationView
    private lateinit var makeDonationPresenter: MakeDonationPresenter

    @Before
    fun beforeTest() {
        makeDonationView = MockView()
        makeDonationPresenter = MakeDonationPresenter(makeDonationView)
    }

    @Test
    fun shouldDisplayTotalDonationAmount() {
        val donation = Donation(DONOR_NAME, DONATION_AMOUNT)
        makeDonationPresenter.addDonation(donation)
        Assert.assertTrue(MockView.hasDisplayedTotalDonationAmount)
    }

}