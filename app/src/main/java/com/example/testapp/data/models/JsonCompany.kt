package com.example.testapp.data.models

import com.squareup.moshi.Json

data class JsonCompany (@field:Json(name = "id") val id: Int,
                        @field:Json(name = "name") val name: String,
                        @field:Json(name = "img") val img: String)