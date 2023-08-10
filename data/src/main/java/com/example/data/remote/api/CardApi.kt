package com.example.data.remote.api

import com.example.data.remote.models.GenericErrorResponse
import com.haroldadmin.cnradapter.NetworkResponse
import com.example.data.remote.models.AllCardsDto
import retrofit2.http.GET

fun interface CardApi {

    @GET("cards")
    suspend fun getAllCards(): NetworkResponse<AllCardsDto, GenericErrorResponse>
}
