package com.tracker.androidcourse.Pre_Populate_Room.Databases


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tracker.androidcourse.Pre_Populate_Room.Data.PersonModel
import com.tracker.androidcourse.Pre_Populate_Room.Data.PersonRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject



@HiltViewModel
class PersonViewModel  @Inject constructor(
  private  val personRepo : PersonRepository
) : ViewModel(){
    var readAll : StateFlow<List<PersonModel>> = personRepo.readAll.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
}