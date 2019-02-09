package com.kaloglu.sample.data.repository.sample

import com.kaloglu.sample.data.LocalStorage
import com.kaloglu.sample.data.cache.sample.SampleDao
import com.kaloglu.sample.data.remote.model.SampleModel
import com.kaloglu.sample.domain.ExecutorFactory
import com.kaloglu.sample.domain.NetworkBoundResource
import com.kaloglu.sample.firebase.SampleServiceFirebase
import com.kaloglu.sample.injection.scopes.PerApplication
import com.kaloglu.sample.presentation.interfaces.SampleMapper
import com.kaloglu.sample.viewobjects.CachedSample
import javax.inject.Inject

@PerApplication
class SampleRepository @Inject constructor(
        private val localStorage: LocalStorage,
        private val sampleServiceFirebase: SampleServiceFirebase,
        private val sampleMapper: SampleMapper,
        private val sampleDao: SampleDao,
        override val executorFactory: ExecutorFactory
) : NetworkBoundResource<CachedSample, SampleModel, Any>(executorFactory) {

    override lateinit var requestParam: Any

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun saveCallResult(sampleModel: SampleModel) {
        val cachedSample = sampleMapper.mapTo(sampleModel)
        localStorage.setSample(cachedSample)
        sampleDao.insert(cachedSample)
    }

    override fun shouldFetch(data: CachedSample?) = data?.dataExpired(getMaxRefreshTime(FRESH_TIMEOUT_IN_MINUTES)) ?: true

    override fun loadFromDb() = sampleDao.findByLogin(localStorage.getSample())

    override fun createCall() = sampleServiceFirebase.getSampleModel()

    companion object {
        private const val FRESH_TIMEOUT_IN_MINUTES = 100
    }
}
