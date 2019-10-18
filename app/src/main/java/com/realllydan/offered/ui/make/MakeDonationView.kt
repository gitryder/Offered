package com.realllydan.offered.ui.make

import com.realllydan.offered.data.model.Donation

interface MakeDonationView {

    /**
     * After the presenter has calculated the total amount
     * it would call this method
     *
     * */

    fun displayTotalDonationAmount(donationAmount: Int)

    fun displayMessageNoDonationDetailsAdded()

    fun displayMessageCannotNavigateSinceEmptyList()

    fun navigateToViewAllDonorsActivity(allDonations: ArrayList<Donation>)


}