package com.realllydan.offered.ui.main

import com.realllydan.offered.data.*
import com.realllydan.offered.ui.make.MakeDonationPresenter
import com.realllydan.offered.ui.make.MakeDonationView
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MakeDonationPresenterTest {

    @Mock
    private lateinit var makeDonationView: MakeDonationView
    @Mock
    private lateinit var makeDonationPresenter: MakeDonationPresenter

    @Before
    fun beforeTest() {
        makeDonationView = Mockito.mock(MakeDonationView::class.java)
        makeDonationPresenter =
            MakeDonationPresenter(makeDonationView)
    }

    @Test
    fun shouldDisplayNoDetailsAdded() {
        makeDonationPresenter.addDonation(getEmptyMockDonationDetails())
        verify(makeDonationView).displayMessageNoDonationDetailsAdded()
    }

    @Test
    fun shouldDisplayTotalDonationAmount() {
        makeDonationPresenter.addDonation(getMockDonationDetails())

        verify(makeDonationView).displayTotalDonationAmount(
            getMockDonationDetails().donationAmount
        )
    }

    @Test
    fun shouldNavigateToAllDonationsActivity() {
        makeDonationPresenter.navigateToViewAllDonations()

        verify(makeDonationView).navigateToViewAllDonorsActivity(getDonationsArrayList())
    }

    @Test
    fun shouldDisplayCannotNavigateSinceEmptyListMessage() {
        makeDonationPresenter.navigateToViewAllDonations()

        verify(makeDonationView).displayMessageCannotNavigateSinceEmptyList()
    }

}