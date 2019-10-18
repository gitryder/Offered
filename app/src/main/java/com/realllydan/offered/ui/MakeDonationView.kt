package com.realllydan.offered.ui

interface MakeDonationView {

    /**
     * After the presenter has calculated the total amount
     * it would call this method
     *
     * */

    fun displayTotalDonationAmount(donationAmount: Int)

    fun displayNoDonationDetailsAddedMessage()
}