package com.example.testapp.domain.models

import com.squareup.moshi.Json

class CompanyCard (val id: Int,
                   val name: String,
                   val img: String,
                   val description: String,
                   val lat: Double,
                   val lon: Double,
                   val www: String,
                   val phone: String)