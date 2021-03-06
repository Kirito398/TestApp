package com.example.testapp.presentation.interfaces

import com.example.testapp.domain.models.Company

interface CompanyListInterface {
    interface View {
        fun initVars()
        fun setListeners()
        fun updateCompanyList(list: List<Company>)
        fun updateCompanyListError(message: String)
        fun setLoadingProgressBarVisibility(visible: Boolean)
        fun openCompanyCardActivity()
    }

    interface Presenter {
        fun init()
        fun updateCompanyList()
        fun onCompanyItemClicked(id: Int)
    }
}