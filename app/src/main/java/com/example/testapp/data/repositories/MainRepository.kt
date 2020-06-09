package com.example.testapp.data.repositories

import com.example.testapp.data.api.MainApi
import com.example.testapp.domain.interfaces.MainRepositoryInterface
import com.example.testapp.domain.models.Company
import com.example.testapp.domain.models.Result
import retrofit2.HttpException

class MainRepository(private val mainApi: MainApi) : MainRepositoryInterface {
    override suspend fun getCompaniesList(): Result<List<Company>> {
        return try {
            val result = mainApi.getCompaniesListAsync().await()
            val list = mutableListOf<Company>()

            for (company in result)
                list.add(Company(company.id, company.name, company.img))

            Result.Success(list)
        } catch (e: HttpException) {
            Result.Error(e)
        } catch (e: Throwable) {
            Result.Error(e)
        }
    }
}