package com.example.testapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.domain.models.Company

class CompanyListAdapter(private val companiesList: MutableList<Company>) : RecyclerView.Adapter<CompanyListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_company, parent, false)
        return CompanyListViewHolder(view)
    }

    override fun getItemCount(): Int = companiesList.size

    override fun onBindViewHolder(holder: CompanyListViewHolder, position: Int) {
        holder.bind(companiesList[position])
    }

    fun updateList(newList: List<Company>) {
        companiesList.clear()
        companiesList.addAll(newList)
        notifyDataSetChanged()
    }
}