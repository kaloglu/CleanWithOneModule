package com.kaloglu.sample.data.remote

import android.app.Application
import com.kaloglu.sample.BuildConfig
import com.kaloglu.sample.data.remote.firestore.FirebaseProvider
import com.kaloglu.sample.data.remote.retrofit.RetrofitProvider
import javax.inject.Inject

class ProviderFactory @Inject constructor() {
    internal fun getProvider(application: Application, providerName: String) =
            when (providerName) {
                "retrofit" -> RetrofitProvider(BuildConfig.DEBUG)
                else -> FirebaseProvider(application)
            }
}
