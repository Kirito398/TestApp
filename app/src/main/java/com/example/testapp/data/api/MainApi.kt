package com.example.testapp.data.api

import com.example.testapp.data.models.JsonCompany
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.POST

interface MainApi {
    @GET("test.php")
    fun getCompaniesListAsync(): Deferred<List<JsonCompany>>
}