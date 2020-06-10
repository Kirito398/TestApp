package com.example.testapp.domain.interactors

import com.example.testapp.domain.interfaces.MainRepositoryInterface

class MainInteractor(private val repository: MainRepositoryInterface) {
    private var currentCompanyID = 0

    companion object {
        var INSTANCE: MainInteractor? = null

        fun getInstance(repository: MainRepositoryInterface): MainInteractor {
            if (INSTANCE == null)
                INSTANCE = MainInteractor(repository)
            return INSTANCE!!
        }
    }

    suspend fun getCompaniesList() = repository.getCompaniesList()

    fun setCurrentCompanyID(id: Int) {
        currentCompanyID = id
    }

    suspend fun getCurrentCompanyCard() = repository.getCompanyCard(currentCompanyID)
}