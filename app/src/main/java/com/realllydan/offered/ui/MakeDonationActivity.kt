package com.realllydan.offered.ui

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

        wireUpAddDonationButtonToAddNewDonation()
        decorateLinkTextViewWithUnderline()
    }

    override fun displayTotalDonationAmount(donationAmount: Int) {
        textViewTotalDonationAmount.text = donationAmount.toString()
    }

    override fun displayNoDonationDetailsAddedMessage() {
        Toast.makeText(this, R.string.message_no_details_typed, Toast.LENGTH_SHORT).show()
    }

    private fun clearAllInputFields() {
        editTextDonorName.setText(EMPTY_TEXT_INPUT_PLACEHOLDER)
        editTextDonationAmount.setText(EMPTY_TEXT_INPUT_PLACEHOLDER)
    }

    private fun wireUpAddDonationButtonToAddNewDonation() {
        buttonAddDonation.setOnClickListener {

            if (textInputFieldsAreNotEmpty()) {
                makeDonationPresenter.addDonation(getDonationDetailsFromTextInputs())
                clearAllInputFields()
            }
        }
    }

    private fun textInputFieldsAreNotEmpty() = (
            !editTextDonorName.text.isNullOrEmpty()
            && !editTextDonationAmount.text.isNullOrEmpty()
    )

    private fun getDonationDetailsFromTextInputs() = Donation().apply {
        donorName = editTextDonorName.text.toString()
        donationAmount = editTextDonationAmount.text.toString().toInt()
    }

    private fun decorateLinkTextViewWithUnderline() {
        textViewLinkToAllDonors.paintFlags = Paint.UNDERLINE_TEXT_FLAG
    }
}
