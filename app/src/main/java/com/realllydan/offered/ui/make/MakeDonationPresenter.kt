package com.realllydan.offered.ui.make

import android.os.Bundle
import com.realllydan.offered.StateSaveable
import com.realllydan.offered.data.model.Donation

private const val KEY_SAVED_DONATION_LIST = "saved_donations_list"

class MakeDonationPresenter constructor(view: MakeDonationView) : StateSaveable {

    private var allDonationsList = ArrayList<Donation>()
    private var view: MakeDonationView = view

    override fun savePresenterState(outState: Bundle) {
        outState.putSerializable(KEY_SAVED_DONATION_LIST, allDonationsList)
    }

    override fun restorePresenterState(savedInstanceState: Bundle) {
        allDonationsList = savedInstanceState.getSerializable(KEY_SAVED_DONATION_LIST) as ArrayList<Donation>
        view.displayTotalDonationAmount(getCalculatedTotalDonationAmount())
    }

    fun addDonation(donation: Donation) {

        if (donation.isEmpty()) {
            view.displayNoDonationDetailsAddedError()
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