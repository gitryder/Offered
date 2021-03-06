package com.realllydan.offered.ui.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.realllydan.offered.R
import com.realllydan.offered.data.adapters.AllDonationsAdapter
import com.realllydan.offered.data.model.Donation
import com.realllydan.offered.ui.make.MakeDonationPresenter

class ViewDonationsActivity : AppCompatActivity(), AllDonationsView {

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

    private var viewDonationsPresenter = ViewDonationsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_donations)

        initToolbar(getString(R.string.toolbar_title_view_donations_activity))
        setupRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_view_donations, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when {
            item.itemId == android.R.id.home -> onBackPressed()
            item.itemId == R.id.action_share_donations ->
                viewDonationsPresenter.shareAllDonations(allDonationsList)
        }
        return true
    }

    private fun initToolbar(title: String) {
        setSupportActionBar(findViewById(R.id.mToolbar))
        supportActionBar?.apply {
            this.title = title
            this.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rvAllDonations)
        val donationsAdapter = AllDonationsAdapter(allDonationsList)
        recyclerView.adapter = donationsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun beginShareDonationsIntent(shareIntent: Intent) {
        startActivity(Intent.createChooser(shareIntent, "Share Using"))
    }
}
