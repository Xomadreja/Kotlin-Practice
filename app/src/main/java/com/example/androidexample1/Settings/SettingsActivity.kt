package com.example.androidexample1.Settings


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

import com.example.androidexample1.databinding.ActivitySettingsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsActivity : AppCompatActivity() {
    companion object {
        const val VOLUME_LVL = "volume_lvl"
        const val KEY_DARKMODE = "key_darkmode"
        const val KEY_BLUETOOTH = "key_bluetooth"
        const val KEY_VIBRATION = "key_vibration"
    }

    private lateinit var binding: ActivitySettingsBinding
    private var firstTime: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CoroutineScope(Dispatchers.IO).launch {
            getSettings().filter { firstTime }.collect { settingsModel ->
                if (settingsModel != null) {
                    binding.scDarkMode.isChecked = settingsModel.darkMode
                    binding.scBluetooth.isChecked = settingsModel.bluetooth
                    binding.scVibration.isChecked = settingsModel.vibration
                    binding.rsVolume.setValues(settingsModel.volume.toFloat())
                    firstTime = !firstTime
                }
            }
        }
        initUI()
    }

    private fun initUI() {
        binding.rsVolume.addOnChangeListener { slider, value, fromUser ->
            CoroutineScope(Dispatchers.IO).launch {
                saveVolume(value.toInt())
            }
        }
        binding.scDarkMode.setOnCheckedChangeListener { compoundButton, value ->
            if(value){
                enableDarkMode()
            }
            else{
                disableDarkMode()
            }
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_DARKMODE, value)
            }
        }
        binding.scBluetooth.setOnCheckedChangeListener { compoundButton, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_BLUETOOTH, value)
            }
        }
        binding.scVibration.setOnCheckedChangeListener { compoundButton, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_VIBRATION, value)
            }
        }
    }

    private suspend fun saveVolume(volumeValue: Int) {
        dataStore.edit { preference ->
            preference[intPreferencesKey(VOLUME_LVL)] = volumeValue
        }
    }

    private suspend fun saveOptions(key: String, value: Boolean) {
        dataStore.edit { preference ->
            preference[booleanPreferencesKey(key)] = value
        }
    }

    private fun getSettings(): Flow<SettingsDataModel> {
        return dataStore.data.map { preferences ->
            SettingsDataModel(
                volume = preferences[intPreferencesKey(VOLUME_LVL)] ?: 50,
                darkMode = preferences[booleanPreferencesKey(KEY_DARKMODE)] ?: false,
                bluetooth = preferences[booleanPreferencesKey(KEY_BLUETOOTH)] ?: false,
                vibration = preferences[booleanPreferencesKey(KEY_VIBRATION)] ?: true
            )

        }
    }

    private fun enableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        delegate.applyDayNight()
    }

    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        delegate.applyDayNight()
    }
}