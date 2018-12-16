package com.kaloglu.duels.injection.module.data.cache

import android.app.Application
import android.arch.persistence.room.Room
import com.kaloglu.duels.BuildConfig
import com.kaloglu.duels.data.cache.db.SampleDb
import com.kaloglu.duels.data.cache.sample.SampleDao
import com.kaloglu.duels.injection.scopes.PerApplication
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
