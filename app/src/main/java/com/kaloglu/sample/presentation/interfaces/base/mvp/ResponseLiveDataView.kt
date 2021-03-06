package com.kaloglu.sample.presentation.interfaces.base.mvp

interface ResponseLiveDataView<in T> : BaseView {
    fun onLoading()
    fun onSuccess(data: T)
    fun onError(errorMessage: String?, data: T?)
}
