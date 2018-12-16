package com.kaloglu.sample.presentation.interfaces

import com.kaloglu.sample.data.remote.model.SampleModel
import com.kaloglu.sample.presentation.interfaces.base.mapper.Mapper
import com.kaloglu.sample.viewobjects.CachedSample
import javax.inject.Inject

/**
 * Created by kaloglu on 9.12.2018.
 */
open class SampleMapper @Inject constructor() : Mapper<SampleModel, CachedSample> {
    override fun mapTo(inModel: SampleModel) =
            inModel.run { CachedSample("sampleParameter") }
}
