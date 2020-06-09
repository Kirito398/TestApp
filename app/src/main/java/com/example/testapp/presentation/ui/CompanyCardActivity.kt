package com.example.testapp.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.testapp.BuildConfig
import com.example.testapp.R
import com.example.testapp.data.api.ApiFactory
import com.example.testapp.data.repositories.MainRepository
import com.example.testapp.domain.interactors.MainInteractor
import com.example.testapp.domain.models.CompanyCard
import com.example.testapp.presentation.interfaces.CompanyCardInterface
import com.example.testapp.presentation.presenters.CompanyCardPresenter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_company_card.*

class CompanyCardActivity : AppCompatActivity(), CompanyCardInterface.View {
    private lateinit var presenter: CompanyCardInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_card)

        presenter = CompanyCardPresenter(this, MainInteractor.getInstance(MainRepository(ApiFactory.getRestClient(applicationContext))))
        presenter.init()
    }

    override fun init() {
        //TODO("Not yet implemented")
    }

    override fun setListeners() {
        //TODO("Not yet implemented")
    }

    override fun updateCard(companyCard: CompanyCard) {
        companyCard.run {
            tvCompanyName.text = name
            tvDescription.text = description
            tvLat.text = lat.toString()
            tvLon.text = lon.toString()
            tvWww.text = www
            tvPhone.text = phone

            Glide.with(applicationContext).load(BuildConfig.URL + img).error(R.drawable.ic_broken_image).into(ivCompanyImage)
        }

        setLoadingProgressBarVisibility(false)
        setErrorTextVisibility(false)
        setCompanyCardVisibility(true)
    }

    override fun onLoadingCardError(message: String) {
        Snackbar.make(clCompanyCardLayout, message, Snackbar.LENGTH_LONG).show()

        setLoadingProgressBarVisibility(false)
        setErrorTextVisibility(true)
        setCompanyCardVisibility(false)
    }

    override fun setLoadingProgressBarVisibility(visible: Boolean) {
        if (visible)
            pbLoading.visibility = View.VISIBLE
        else
            pbLoading.visibility = View.GONE
    }

    override fun setErrorTextVisibility(visible: Boolean) {
        if (visible)
            tvLoadingError.visibility = View.VISIBLE
        else
            tvLoadingError.visibility = View.GONE
    }

    override fun setCompanyCardVisibility(visible: Boolean) {
        if (visible)
            svCompanyCard.visibility = View.VISIBLE
        else
            svCompanyCard.visibility = View.GONE
    }
}