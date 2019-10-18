package com.realllydan.offered.ui

import com.realllydan.offered.data.model.Donation

class MakeDonationPresenter constructor(view: MakeDonationView) {

    private val allDonationsList = ArrayList<Donation>()
    private var view: MakeDonationView = view

    fun addDonation(donation: Donation) {

        if (donation.isEmpty()) {
            view.displayNoDonationDetailsAddedMessage()
            return
        }

        allDonationsList.add(donation)
        view.displayTotalDonationAmount(getCalculatedTotalDonationAmount())
    }

    fun getCalculatedTotalDonationAmount(): Int {
        var totalDonationAmount = 0
        for (donation in allDonationsList) totalDonationAmount += donation.donationAmount
        return totalDonationAmount
    }


}