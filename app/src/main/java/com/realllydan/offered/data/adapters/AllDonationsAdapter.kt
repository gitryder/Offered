package com.realllydan.offered.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.realllydan.offered.R
import com.realllydan.offered.data.model.Donation

class AllDonationsAdapter(allDonationsList: ArrayList<Donation>) :
    RecyclerView.Adapter<AllDonationsAdapter.ViewHolder>() {

    val allDonationsList: ArrayList<Donation> = allDonationsList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_single_donation, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvDonorName.text = allDonationsList[position].donorName
        holder.tvDonationAmount.text = allDonationsList[position].donationAmount.toString()
    }

    override fun getItemCount() = allDonationsList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDonorName: TextView = itemView.findViewById(R.id.tvDonorName)
        val tvDonationAmount: TextView = itemView.findViewById(R.id.tvDonationAmount)
    }
}