/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kaloglu.sample.data.cache.sample

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kaloglu.sample.viewobjects.CachedSample
import java.util.*

/**
 * Interface for database access for CachedSample related operations.
 */
@Dao
interface SampleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cachedSample: CachedSample)

    @Query("SELECT * FROM user WHERE sampleParameter = :sampleParameter LIMIT 1")
    fun findByLogin(sampleParameter: String): LiveData<CachedSample>

    @Query("SELECT sampleParameter FROM user WHERE sampleParameter = :sampleParameter AND lastRefresh > :lastRefreshMax LIMIT 1")
    fun hasUser(sampleParameter: String, lastRefreshMax: Date): Boolean

}
