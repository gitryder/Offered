package com.realllydan.offered.ui.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.realllydan.offered.R
import com.realllydan.offered.data.adapters.AllDonationsAdapter
import com.realllydan.offered.data.model.Donation
import java.lang.IllegalStateException

class ViewDonationsActivity : AppCompatActivity() {

    companion object {
        private const val ALL_DONATIONS_KEY = "all_donations"

        fun getStartIntent(context: Context, allDonations: ArrayList<Donation>): Intent {
            val viewDonationsIntent = Intent(context, ViewDonationsActivity::class.java)
            viewDonationsIntent.putParcelableArrayListExtra(ALL_DONATIONS_KEY, allDonations)
            return viewDonationsIntent
         }
    }

    private val allDonationsList: ArrayList<Donation> by lazy {
        intent?.getParcelableArrayListExtra<Donation>(ALL_DONATIONS_KEY)
            ?: throw IllegalStateException("Must call through getStartIntent()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_donations)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rvAllDonations)
        val donationsAdapter = AllDonationsAdapter(allDonationsList)
        recyclerView.adapter = donationsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
