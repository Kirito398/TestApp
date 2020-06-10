package com.example.testapp.data.repositories

import com.example.testapp.data.api.MainApi
import com.example.testapp.data.exceptions.NoConnectivityException
import com.example.testapp.domain.interfaces.MainRepositoryInterface
import com.example.testapp.domain.models.Company
import com.example.testapp.domain.models.CompanyCard
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
        } catch (e: NoConnectivityException) {
            Result.Error(e)
        } catch (e: Throwable) {
            Result.Error(e)
        }
    }

    override suspend fun getCompanyCard(id: Int): Result<CompanyCard> {
        return try {
            val result = mainApi.getCompanyCardAsync(id).await()
            Result.Success(
                CompanyCard(
                    result[0].id.toInt(),
                    result[0].name,
                    result[0].img,
                    result[0].description,
                    result[0].lat,
                    result[0].lon,
                    result[0].www,
                    result[0].phone))
        } catch (e: HttpException) {
            Result.Error(e)
        } catch (e: NoConnectivityException) {
            Result.Error(e)
        } catch (e: Throwable) {
            Result.Error(e)
        }
    }
}