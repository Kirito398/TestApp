package com.example.testapp.domain.interactors

import com.example.testapp.domain.interfaces.MainRepositoryInterface

class MainInteractor(private val repository: MainRepositoryInterface) {
    suspend fun getCompaniesList() = repository.getCompaniesList()
}