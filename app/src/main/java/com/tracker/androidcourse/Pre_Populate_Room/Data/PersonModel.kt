package com.tracker.androidcourse.Pre_Populate_Room.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appuser")
data class PersonModel(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val phoneNumber : String,
    val dateOfBirth : String
)






