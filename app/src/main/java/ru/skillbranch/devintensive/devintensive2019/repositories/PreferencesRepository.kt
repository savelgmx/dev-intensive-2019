package ru.skillbranch.devintensive.devintensive2019.repositories

import android.content.SharedPreferences
import android.preference.PreferenceManager
import ru.skillbranch.devintensive.devintensive2019.models.Profile

object PreferencesRepository {

    private val prefs:SharedPreferences by lazy{
        val ctx =null
        PreferenceManager.getDefaultSharedPreferences(ctx)
    }

    fun getProfile(): Profile? {
        //TODO('not yet implemented')
        return null

    }

    fun saveProfile(profile: Profile) {
        //TODO (not yet implamenyed)
    }
}