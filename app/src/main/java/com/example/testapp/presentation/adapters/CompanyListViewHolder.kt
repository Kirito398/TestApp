package com.example.testapp.presentation.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapp.BuildConfig
import com.example.testapp.R
import com.example.testapp.domain.models.Company
import kotlinx.android.synthetic.main.item_company.view.*

class CompanyListViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private var tvName: TextView = view.findViewById(R.id.tvCompanyName)
    private var ivIcon: ImageView = view.findViewById(R.id.ivCompanyIcon)

    fun bind (company: Company) {
        tvName.text = company.name
        Glide.with(view).load(BuildConfig.URL + company.img).into(ivIcon)
    }
}