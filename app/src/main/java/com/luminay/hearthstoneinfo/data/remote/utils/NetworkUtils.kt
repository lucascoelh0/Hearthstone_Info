package com.luminay.hearthstoneinfo.data.remote.utils

import com.haroldadmin.cnradapter.NetworkResponse
import com.luminay.hearthstoneinfo.core.models.GenericErrorResponse
import com.luminay.hearthstoneinfo.core.models.Resource

fun <T : Any, R : Any> handleNetworkResponse(
    networkResponse: NetworkResponse<T, GenericErrorResponse>,
    transform: (T) -> R,
): Resource<R> {
    return when (networkResponse) {
        is NetworkResponse.Success -> {
            Resource.success(data = transform(networkResponse.body))
        }

        is NetworkResponse.ServerError<GenericErrorResponse> -> {
            Resource.error(
                msg = networkResponse.body?.message.orEmpty(),
                data = null,
                errorStatus = networkResponse.code
            )
        }

        is NetworkResponse.NetworkError, is NetworkResponse.UnknownError -> {
            val error = getErrorFromResponse(networkResponse)
            Resource.exception(
                data = null,
                exception = error
            )
        }
    }
}

private fun getErrorFromResponse(response: NetworkResponse<*, *>): Throwable {
    return when (response) {
        is NetworkResponse.NetworkError -> response.error
        is NetworkResponse.UnknownError -> response.error
        else -> throw IllegalArgumentException("Invalid response type")
    }
}
