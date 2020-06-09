package com.example.testapp.presentation.presenters

import com.example.testapp.domain.interactors.MainInteractor
import com.example.testapp.domain.models.Company
import com.example.testapp.domain.models.Result
import com.example.testapp.presentation.interfaces.CompanyListInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CompanyListPresenter (private val interactor: MainInteractor, private val view: CompanyListInterface.View) : CompanyListInterface.Presenter {
    override fun init() {
        view.initVars()
        view.setListeners()

        updateCompanyList()
    }

    override fun updateCompanyList() {
        view.setLoadingProgressBarVisibility(true)

        CoroutineScope(Dispatchers.IO).launch {
            val result = interactor.getCompaniesList()

            withContext(Dispatchers.Main) {
                if (result is Result.Success<List<Company>>) view.updateCompanyList(result.data)
                else view.updateCompanyListError((result as Result.Error).exception.toString())
                view.setLoadingProgressBarVisibility(false)
            }
        }
    }
}