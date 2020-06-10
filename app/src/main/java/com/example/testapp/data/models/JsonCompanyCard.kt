package com.example.testapp.data.models

import com.squareup.moshi.Json

data class JsonCompanyCard (@field:Json(name = "id") val id: String,
                       @field:Json(name = "name") val name: String,
                       @field:Json(name = "img") val img: String,
                       @field:Json(name = "description") val description: String,
                       @field:Json(name = "lat") val lat: Double,
                       @field:Json(name = "lon") val lon: Double,
                       @field:Json(name = "www") val www: String,
                       @field:Json(name = "phone") val phone: String)