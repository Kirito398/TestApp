package com.example.testapp.data.api

import com.example.testapp.data.models.JsonCompany
import com.example.testapp.data.models.JsonCompanyCard
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MainApi {
    @GET("test.php")
    fun getCompaniesListAsync(): Deferred<List<JsonCompany>>

    @POST("test.php")
    fun getCompanyCardAsync(@Query("id") id: Int): Deferred<List<JsonCompanyCard>>
}