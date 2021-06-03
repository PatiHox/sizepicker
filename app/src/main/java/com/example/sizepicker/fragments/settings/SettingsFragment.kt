package com.example.sizepicker.fragments.settings

import android.os.Bundle
import android.text.InputType
import android.view.Menu
import android.widget.EditText
import androidx.preference.*
import com.example.sizepicker.R
import com.example.sizepicker.utils.DataUtils

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.clear()
    }


    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
//        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        val context = preferenceManager.context
        val screen = preferenceManager.createPreferenceScreen(context)


        val applicationPreferenceCategory = PreferenceCategory(context)
        applicationPreferenceCategory.title = getString(R.string.application)
        screen.addPreference(applicationPreferenceCategory)



        val showSaveMessagePreference = CheckBoxPreference(context)
        showSaveMessagePreference.key = "show_save_message"
        showSaveMessagePreference.title = getString(R.string.show_save_data_question)

        applicationPreferenceCategory.addPreference(showSaveMessagePreference)

        val userSizesPreferenceCategory = PreferenceCategory(context)
        userSizesPreferenceCategory.title = getString(R.string.user_size_settings)
        screen.addPreference(userSizesPreferenceCategory)

        val bodyPartsNames = DataUtils.getAllBodyPartsNames(context)



        for (bodyPartName in bodyPartsNames) {
            val preference = EditTextPreference(context)
            preference.key = bodyPartName
            preference.title = bodyPartName
            preference.setOnBindEditTextListener { etInput ->
                etInput.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
            }
            userSizesPreferenceCategory.addPreference(preference)
        }

        preferenceScreen = screen
    }

}