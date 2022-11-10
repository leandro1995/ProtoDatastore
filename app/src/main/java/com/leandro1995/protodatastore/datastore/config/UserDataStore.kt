package com.leandro1995.protodatastore.datastore.config

import android.content.Context
import androidx.datastore.core.DataStore
import com.leandro1995.protodatastore.UserPreferences
import com.leandro1995.protodatastore.extension.userPreferencesStore
import kotlinx.coroutines.runBlocking

object UserDataStore {

    // 1- Crear variable de dataStore proto
    private lateinit var dataStore: DataStore<UserPreferences>

    // 2- Crear instancia unica para dataStore proto
    fun instance(context: Context) {

        dataStore = context.userPreferencesStore
    }

    // 3- Variables para sobre escribir
    fun nameUser(string: String) {

        runBlocking {

            dataStore.updateData { preferences ->

                preferences.toBuilder().setNameUser(string).build()
            }
        }
    }

    // 4- Obtener el valor de la variable
    fun nameUser() = runBlocking { dataStore.data.collect { it.nameUser } }
}