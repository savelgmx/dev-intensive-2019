package ru.skillbranch.devintensive.devintensive2019.viewmodels

import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.skillbranch.devintensive.devintensive2019.models.Profile
import ru.skillbranch.devintensive.devintensive2019.repositories.PreferencesRepository

class ProfileViewModel : ViewModel() {

    private val repository: PreferencesRepository = PreferencesRepository
    private val profileData = MutableLiveData<Profile>()
    private val appTheme = MutableLiveData<Int>()


    init {
        Log.d("M_ProfileViewModel", "init view model")
        profileData.value = repository.getProfile()

    }

    override fun onCleared() {
        super.onCleared()
        Log.d("M_ProfileViewModel", "cleared view model")
    }

    fun getProfileData(): LiveData<Profile> = profileData

    fun saveProfileData(profile: Profile) {

        repository.saveProfile(profile)
        profileData.value = profile

    }

    fun switchTheme() {
        if (appTheme.value == AppCompatDelegate.MODE_NIGHT_YES) {
            appTheme.value == AppCompatDelegate.MODE_NIGHT_NO
        } else {
            appTheme.value == AppCompatDelegate.MODE_NIGHT_YES
        }
        repository.saveAppTheme(appTheme.value!!)
    }

    fun getTheme(): LiveData<Int> = appTheme
}
