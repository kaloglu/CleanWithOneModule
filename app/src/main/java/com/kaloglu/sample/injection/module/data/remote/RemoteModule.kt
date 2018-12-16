package com.kaloglu.sample.injection.module.data.remote

import android.app.Application
import com.kaloglu.sample.BuildConfig
import com.kaloglu.sample.api.service.SampleServiceRetrofit
import com.kaloglu.sample.data.remote.NetworkProvider
import com.kaloglu.sample.data.remote.ProviderFactory
import com.kaloglu.sample.firebase.SampleServiceFirebase
import com.kaloglu.sample.injection.scopes.PerApplication
import dagger.Module
import dagger.Provides


@Module
abstract class RemoteModule {

    @Module
    companion object {

        @JvmStatic
        @PerApplication
        @Provides
        fun retoriftSampleService(provider: NetworkProvider) =
                provider.create(SampleServiceRetrofit::class.java)

        @JvmStatic
        @PerApplication
        @Provides
        fun firebaseSampleService(provider: NetworkProvider) =
                provider.create(SampleServiceFirebase::class.java)

        @JvmStatic
        @PerApplication
        @Provides
        fun networkProvider(
                application: Application,
                serviceProvider: ProviderFactory
        ) = serviceProvider.getProvider(application, BuildConfig.NETWORK_PROTOCOL)

    }

}
