package com.tracker.androidcourse.Pre_Populate_Room.Databases

import android.content.Context
import androidx.room.Room
import androidx.test.espresso.core.internal.deps.dagger.Module
import androidx.test.espresso.core.internal.deps.dagger.Provides
import com.tracker.androidcourse.Pre_Populate_Room.Data.PersonDatabase
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object  DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase (
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
       context,
        PersonDatabase :: class.java,
        "app_database"
    ).createFromAsset("Database/appflow.db").build()
    @Singleton
    @Provides
    fun  provideDao(database: PersonDatabase) = database.personDao()
}

