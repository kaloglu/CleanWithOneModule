package com.kaloglu.sample.api.service

import androidx.lifecycle.LiveData
import com.kaloglu.sample.api.ApiResponse
import com.kaloglu.sample.data.remote.model.SampleModel
import retrofit2.http.GET
import retrofit2.http.Query

interface SampleServiceRetrofit {
    val mutableResult: Any

    @GET("/getSample")
    fun getSample(@Query("paramName") paramName: String): LiveData<ApiResponse<SampleModel>>

    @Suppress("UNCHECKED_CAST")
    fun <T> asLiveData(): T {
        return mutableResult as T
    }
}
