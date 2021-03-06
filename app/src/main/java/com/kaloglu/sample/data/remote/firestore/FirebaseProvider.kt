package com.kaloglu.sample.data.remote.firestore

import android.app.Application
import com.kaloglu.sample.data.remote.NetworkProvider
import com.kaloglu.sample.firebase.SampleServiceFirebase

class FirebaseProvider(private val application: Application) : NetworkProvider() {

    @Suppress("UNCHECKED_CAST")
    override fun <S> create(serviceClass: Class<S>): S {
        return when (serviceClass.simpleName) {
            SampleServiceFirebase::class.java.simpleName -> getSampleService()
            else -> throw IllegalArgumentException("undefined Service Class[${serviceClass.name}]")
        } as S
    }

    private fun getSampleService() =
            SampleServiceFirebase(/*sampleInjectParamater*/)

}
