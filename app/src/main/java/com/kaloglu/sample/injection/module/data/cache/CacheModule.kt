package com.kaloglu.sample.injection.module.data.cache

import android.app.Application
import android.arch.persistence.room.Room
import com.kaloglu.sample.BuildConfig
import com.kaloglu.sample.data.cache.db.SampleDb
import com.kaloglu.sample.data.cache.sample.SampleDao
import com.kaloglu.sample.injection.scopes.PerApplication
import dagger.Module
import dagger.Provides

@Module
abstract class CacheModule {

    @Module
    companion object {

        @JvmStatic
        @PerApplication
        @Provides
        fun provideDb(app: Application): SampleDb {
            return Room
                    .databaseBuilder(app, SampleDb::class.java, BuildConfig.LOCAL_DB)
                    .fallbackToDestructiveMigration()
                    .build()
        }

        @JvmStatic
        @PerApplication
        @Provides
        fun provideUserDao(db: SampleDb): SampleDao {
            return db.sampleDao()
        }
    }
}
