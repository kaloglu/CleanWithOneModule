package com.kaloglu.sample.firebase

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kaloglu.sample.api.ApiResponse
import com.kaloglu.sample.api.ApiSuccessResponse
import com.kaloglu.sample.data.remote.model.SampleModel

typealias M = SampleModel

class SampleServiceFirebase /*( private val sampleInjection: SampleInjection )*/ {
    private val mutableResult: MutableLiveData<ApiResponse<M>> = MutableLiveData()

    @Suppress("UNCHECKED_CAST")
    fun <T> asLiveData(): T {
        return mutableResult as T
    }

    fun getSampleModel(): LiveData<ApiResponse<M>> {
        setValue(ApiSuccessResponse(SampleModel(), ""))
        return mutableResult
    }

    @MainThread
    private fun setValue(newValue: ApiResponse<M>) {
        if (mutableResult.value != newValue) {
            mutableResult.value = newValue
        }
    }
}
