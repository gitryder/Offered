package com.realllydan.offered.ui.make

import android.app.Activity
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.realllydan.offered.R
import com.realllydan.offered.data.model.Donation
import com.realllydan.offered.ui.view.ViewDonationsActivity
import kotlinx.android.synthetic.main.activity_make_donation.*

class MakeDonationActivity : AppCompatActivity(), MakeDonationView {

    private fun <T : View> Activity.bind(@IdRes res: Int): Lazy<T> {
        return lazy { findViewById<T>(res) }
    }

    companion object {
        private const val EMPTY_TEXT_INPUT_PLACEHOLDER = ""
    }

    private val textViewTotalDonationAmount by bind<TextView>(R.id.tvTotalDonatedAmount)
    private val textViewLinkToAllDonors by bind<TextView>(R.id.tvLinkToAllDonors)
    private val editTextDonorName by bind<TextInputEditText>(R.id.etDonorName)
    private val editTextDonationAmount by bind<TextInputEditText>(R.id.etDonationAmount)
    private val buttonAddDonation by bind<ImageView>(R.id.ivAddToTotalAmount)

    private val makeDonationPresenter = MakeDonationPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_donation)

        setupButtonToAddNewDonation()
        setupTextViewLinkToAllDonations()
    }

    override fun displayTotalDonationAmount(donationAmount: Int) {
        textViewTotalDonationAmount.text = donationAmount.toString()
    }

    override fun displayMessageNoDonationDetailsAdded() {
        Toast.makeText(this, R.string.message_no_details_typed, Toast.LENGTH_SHORT).show()
    }

    override fun displayMessageCannotNavigateSinceEmptyList() {
        Toast.makeText(this, R.string.message_no_donations_exist, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToViewAllDonorsActivity(allDonations: ArrayList<Donation>) {
        startActivity(ViewDonationsActivity.getStartIntent(this, allDonations))
    }

    private fun clearAllInputFields() {
        editTextDonorName.setText(EMPTY_TEXT_INPUT_PLACEHOLDER)
        editTextDonationAmount.setText(EMPTY_TEXT_INPUT_PLACEHOLDER)
    }

    private fun setupButtonToAddNewDonation() {
        buttonAddDonation.setOnClickListener {
            makeDonationPresenter.addDonation(getDonationDetailsFromTextInputs())
            clearAllInputFields()
        }
    }

    private fun setupTextViewLinkToAllDonations() {
        decorateLinkTextViewWithUnderline()

        tvLinkToAllDonors.setOnClickListener {
            makeDonationPresenter.navigateToViewAllDonations()
        }
    }

    private fun getDonationDetailsFromTextInputs(): Donation {
        val donorName = editTextDonorName.text.toString()
        val donationAmount = editTextDonationAmount.text.toString()

        return when (donationAmount.isEmpty()) {
            true -> Donation(donorName, Donation.DEFAULT_DONATION_AMOUNT)
            else -> Donation(donorName, donationAmount.toInt())
        }
    }

    private fun decorateLinkTextViewWithUnderline() {
        textViewLinkToAllDonors.paintFlags = Paint.UNDERLINE_TEXT_FLAG
    }
}
