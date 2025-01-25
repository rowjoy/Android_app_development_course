package com.tracker.androidcourse.Pre_Populate_Room.Data

import jakarta.inject.Inject

class PersonRepository  @Inject constructor(
    private  val personDao: PersonDaoQuery
) {
    val readAll = personDao.readAll()
}