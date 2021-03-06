package com.kaloglu.sample.injection.firestore

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
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
        val fireStoreDb = FirebaseFirestore.getInstance()
        fireStoreDb.firestoreSettings = FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build()
        return fireStoreDb
    }

    @PerApplication
    @Provides
    @Named("public")
    fun providesPublic(fireStoreDb: FirebaseFirestore): CollectionReference {
        return fireStoreDb.collection("public")
    }

}
