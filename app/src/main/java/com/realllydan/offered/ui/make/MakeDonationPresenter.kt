package com.realllydan.offered.ui.make

import com.realllydan.offered.data.model.Donation

class MakeDonationPresenter constructor(view: MakeDonationView) {

    private val allDonationsList = ArrayList<Donation>()
    private var view: MakeDonationView = view

    fun addDonation(donation: Donation) {

        if (donation.isEmpty()) {
            view.displayMessageNoDonationDetailsAdded()
            return
        }

        allDonationsList.add(donation)
        view.displayTotalDonationAmount(getCalculatedTotalDonationAmount())
    }

    fun navigateToViewAllDonations() {
        when (allDonationsList.isEmpty()) {
            true -> view.displayMessageCannotNavigateSinceEmptyList()
            else -> view.navigateToViewAllDonorsActivity(allDonationsList)
        }
    }

    private fun getCalculatedTotalDonationAmount(): Int {
        var totalDonationAmount = 0

        allDonationsList.forEach {
            totalDonationAmount += it.donationAmount
        }
        return totalDonationAmount
    }



}