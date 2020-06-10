package com.example.testapp.presentation.interfaces

import com.example.testapp.domain.models.CompanyCard

interface CompanyCardInterface {
    interface View {
        fun init()
        fun setListeners()
        fun updateCard(companyCard: CompanyCard)
        fun onLoadingCardError(message: String)
        fun setLoadingProgressBarVisibility(visible: Boolean)
        fun setErrorTextVisibility(visible: Boolean)
        fun setCompanyCardVisibility(visible: Boolean)
    }

    interface Presenter {
        fun init()
        fun updateCompanyCard()
    }
}