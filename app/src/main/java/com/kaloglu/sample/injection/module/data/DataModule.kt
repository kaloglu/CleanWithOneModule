package com.kaloglu.sample.injection.module.data

import com.kaloglu.sample.data.LocalStorage
import com.kaloglu.sample.data.cache.sample.SampleDao
import com.kaloglu.sample.data.remote.model.SampleModel
import com.kaloglu.sample.data.repository.sample.SampleRepository
import com.kaloglu.sample.domain.ExecutorFactory
import com.kaloglu.sample.domain.NetworkBoundResource
import com.kaloglu.sample.firebase.SampleServiceFirebase
import com.kaloglu.sample.injection.scopes.PerApplication
import com.kaloglu.sample.presentation.interfaces.SampleMapper
import com.kaloglu.sample.viewobjects.CachedSample
import dagger.Module
import dagger.Provides


@Module
abstract class DataModule {
    @Module
    companion object {

        @JvmStatic
        @Provides
        @PerApplication
        fun provideSampleRepository(
                localStorage: LocalStorage,
                sampleServiceFirebase: SampleServiceFirebase,
                sampleMapper: SampleMapper,
                sampleDao: SampleDao,
                executor: ExecutorFactory
        ): NetworkBoundResource<CachedSample, SampleModel, Any> =
                SampleRepository(localStorage, sampleServiceFirebase, sampleMapper, sampleDao, executor)

        @JvmStatic
        @Provides
        @PerApplication
        fun provideExecutorFactory() = ExecutorFactory()
    }


}
