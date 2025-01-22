package com.tracker.androidcourse.Pre_Populate_Room.Databases

import androidx.lifecycle.ViewModel
import com.tracker.androidcourse.Pre_Populate_Room.Data.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject



@HiltViewModel
class PersonViewModel  @Inject constructor(
    personRepository : PersonRepository
) : ViewModel (){
    var readAll = personRepository.readAll
}