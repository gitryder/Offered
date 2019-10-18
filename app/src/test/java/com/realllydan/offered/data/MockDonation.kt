package com.realllydan.offered.data

import com.realllydan.offered.data.model.Donation

private const val EMPTY_DONOR_NAME = ""
private const val EMPTY_DONATION_AMOUNT = 0

private val DONOR_NAME = "Generic Donor Name"
private val DONATION_AMOUNT = 100

fun getMockDonationDetails() = Donation().apply {
    donorName = DONOR_NAME
    donationAmount = DONATION_AMOUNT
}

fun getEmptyMockDonationDetails() = Donation().apply {
    donorName = EMPTY_DONOR_NAME
    donationAmount = EMPTY_DONATION_AMOUNT
}

fun getDonationsArrayList(): ArrayList<Donation> {
    var allDonationsList = ArrayList<Donation>()
    allDonationsList.add(Donation(DONOR_NAME, DONATION_AMOUNT))
    allDonationsList.add(Donation(DONOR_NAME, DONATION_AMOUNT))
    allDonationsList.add (Donation(DONOR_NAME, DONATION_AMOUNT))
    return allDonationsList
}

fun getEmptyDonationsList(): ArrayList<Donation> {
    return ArrayList<Donation>()
}