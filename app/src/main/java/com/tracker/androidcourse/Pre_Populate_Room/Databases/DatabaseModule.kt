package com.tracker.androidcourse.Pre_Populate_Room.Databases


import android.content.Context
import androidx.room.Room
import com.tracker.androidcourse.Pre_Populate_Room.Data.PersonAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
public final class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase (
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
       context,
        PersonAppDatabase :: class.java,
        "app_database"
    ).createFromAsset("Database/appflow.db").build()

    @Provides
    fun  provideDao(database: PersonAppDatabase) = database.PersonDaoQuery()
}

