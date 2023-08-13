package com.example.data.remote.interceptors

import com.example.data.BuildConfig
import com.example.data.URL
import com.example.data.remote.interceptors.RequestInterceptor.Companion.API_HOST
import com.example.data.remote.interceptors.RequestInterceptor.Companion.HEADER_HOST
import com.example.data.remote.interceptors.RequestInterceptor.Companion.HEADER_KEY
import com.example.data.remote.interceptors.RequestInterceptor.Companion.LOCALE_STRING
import com.example.data.remote.interceptors.RequestInterceptor.Companion.LOCALE_VALUE
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import okhttp3.Interceptor
import okhttp3.Request
import org.junit.Test

class RequestInterceptorCacheTest {

    @Test
    fun `RequestInterceptor modifies request with headers and locale query`() {
        val chain: Interceptor.Chain = mockk(relaxed = true)
        val request: Request = Request.Builder().url(URL).build()
        val response: okhttp3.Response = mockk(relaxed = true)

        every { chain.request() } returns request
        every { chain.proceed(any()) } returns response

        val requestInterceptor = RequestInterceptor()
        requestInterceptor.intercept(chain)

        verify {
            chain.proceed(withArg { modifiedRequest ->
                assertEquals(BuildConfig.API_KEY, modifiedRequest.header(HEADER_KEY))
                assertEquals(API_HOST, modifiedRequest.header(HEADER_HOST))
                assertEquals(LOCALE_VALUE, modifiedRequest.url.queryParameter(LOCALE_STRING))
            })
        }
    }
}
