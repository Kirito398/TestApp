package com.example.testapp.presentation.presenters

import com.example.testapp.domain.interactors.MainInteractor
import com.example.testapp.domain.models.CompanyCard
import com.example.testapp.domain.models.Result
import com.example.testapp.presentation.interfaces.CompanyCardInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CompanyCardPresenter(private val view: CompanyCardInterface.View, private val interactor: MainInteractor) : CompanyCardInterface.Presenter {
    override fun init() {
        view.init()
        view.setListeners()

        updateCompanyCard()
    }

    override fun updateCompanyCard() {
        view.setLoadingProgressBarVisibility(true)

        CoroutineScope(Dispatchers.IO).launch {
            val result = interactor.getCurrentCompanyCard()

            withContext(Dispatchers.Main) {
                if (result is Result.Success<CompanyCard>) view.updateCard(result.data)
                else view.onLoadingCardError((result as Result.Error).exception.toString())
            }
        }
    }
}