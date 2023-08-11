package com.example.data.remote.api

import com.example.data.remote.models.CardDto
import com.example.data.remote.models.GenericErrorResponse
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET

fun interface CardApi {

    @GET("cards")
    suspend fun getAllCards(): NetworkResponse<Map<String, List<CardDto>>, GenericErrorResponse>
}
