package com.luminay.hearthstoneinfo.data.remote.api

import com.haroldadmin.cnradapter.NetworkResponse
import com.luminay.hearthstoneinfo.core.models.GenericErrorResponse
import com.luminay.hearthstoneinfo.data.remote.models.AllCardsDto
import retrofit2.http.GET

fun interface CardApi {

    @GET("cards")
    suspend fun getAllCards(): NetworkResponse<AllCardsDto, GenericErrorResponse>
}
