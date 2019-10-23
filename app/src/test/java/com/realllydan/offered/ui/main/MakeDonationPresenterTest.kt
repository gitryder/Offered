package com.realllydan.offered.ui.main

import com.realllydan.offered.data.DONATIONS_ARRAY_LIST
import com.realllydan.offered.data.EMPTY_DONATION
import com.realllydan.offered.data.NON_EMPTY_DONATION
import com.realllydan.offered.ui.make.MakeDonationPresenter
import com.realllydan.offered.ui.make.MakeDonationView
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MakeDonationPresenterTest {

    @Mock
    private lateinit var makeDonationView: MakeDonationView
    @Mock
    private lateinit var makeDonationPresenter: MakeDonationPresenter

    @Before
    fun beforeTests() {
        makeDonationPresenter = MakeDonationPresenter(makeDonationView)
    }

    @Test
    fun shouldDisplayNoDetailsAddedError() {
        makeDonationPresenter.addDonation(EMPTY_DONATION)

        verify(makeDonationView).displayNoDonationDetailsAddedError()
    }

    @Test
    fun shouldDisplayTotalDonationAmount() {
        makeDonationPresenter.addDonation(NON_EMPTY_DONATION)

        verify(makeDonationView).displayTotalDonationAmount(NON_EMPTY_DONATION.donationAmount)
    }

    @Test
    fun shouldNavigateToAllDonationsActivity() {
        makeDonationPresenter.addDonation(NON_EMPTY_DONATION)

        makeDonationPresenter.navigateToViewAllDonations()

        verify(makeDonationView).navigateToViewAllDonorsActivity(DONATIONS_ARRAY_LIST)
    }

    @Test
    fun shouldDisplayCannotNavigateSinceEmptyListMessage() {
        makeDonationPresenter.addDonation(EMPTY_DONATION)

        makeDonationPresenter.navigateToViewAllDonations()

        verify(makeDonationView).displayMessageCannotNavigateSinceEmptyList()
    }

}