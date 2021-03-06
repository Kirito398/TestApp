package com.example.testapp.domain.interfaces

import com.example.testapp.domain.models.Company
import com.example.testapp.domain.models.CompanyCard
import com.example.testapp.domain.models.Result

interface MainRepositoryInterface {
    suspend fun getCompaniesList(): Result<List<Company>>
    suspend fun getCompanyCard(id: Int): Result<CompanyCard>
}