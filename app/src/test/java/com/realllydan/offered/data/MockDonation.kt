package com.realllydan.offered.data

import com.realllydan.offered.data.model.Donation

private const val EMPTY_DONOR_NAME = ""
private const val EMPTY_DONATION_AMOUNT = 0

private const val DONOR_ONE_NAME = "Ross Berry"
private const val DONATION_ONE_AMOUNT = 100

val EMPTY_DONATION = getEmptyMockDonationDetails()
val NON_EMPTY_DONATION = getMockDonationDetails()
val DONATIONS_ARRAY_LIST = getDonationsArrayList()

private fun getMockDonationDetails() = Donation().apply {
    donorName = DONOR_ONE_NAME
    donationAmount = DONATION_ONE_AMOUNT
}

private fun getEmptyMockDonationDetails() = Donation().apply {
    donorName = EMPTY_DONOR_NAME
    donationAmount = EMPTY_DONATION_AMOUNT
}

private fun getDonationsArrayList() = ArrayList<Donation>().apply {
    add(Donation(DONOR_ONE_NAME, DONATION_ONE_AMOUNT))
}
