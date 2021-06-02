package com.example.sizepicker.fragments.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.sizepicker.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
//        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        val context = preferenceManager.context
        val screen = preferenceManager.createPreferenceScreen(context)



    }


}