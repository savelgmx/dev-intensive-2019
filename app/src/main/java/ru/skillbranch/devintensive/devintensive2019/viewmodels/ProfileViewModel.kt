package ru.skillbranch.devintensive.devintensive2019.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.skillbranch.devintensive.devintensive2019.models.Profile
import ru.skillbranch.devintensive.devintensive2019.repositories.PreferencesRepository

class ProfileViewModel : ViewModel() {

    private val repository : PreferencesRepository = PreferencesRepository
    private val profileData=MutableLiveData<Profile>()


    init {
        Log.d("M_ProfileViewModel","init view model")
      profileData.value = repository.getProfile()

    }

    override fun onCleared() {
        super.onCleared()
        Log.d("M_ProfileViewModel","cleared view model")
    }
    fun getProfileData():LiveData<Profile> = profileData

    fun saveProfileData(profile: Profile){

        repository.saveProfile(profile)
        profileData.value=profile

    }


}

