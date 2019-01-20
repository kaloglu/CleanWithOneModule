package com.kaloglu.sample.injection.firestore

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.kaloglu.sample.injection.scopes.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
internal class FirestoreModule {

    @PerApplication
    @Provides
    fun providesFirestore(): FirebaseFirestore {
        FirebaseFirestore.setLoggingEnabled(true)
        return FirebaseFirestore.getInstance()
    }

    @PerApplication
    @Provides
    @Named("public")
    fun providesTournaments(): CollectionReference {
        FirebaseFirestore.setLoggingEnabled(true)
        return FirebaseFirestore.getInstance().collection("public")
    }

}
