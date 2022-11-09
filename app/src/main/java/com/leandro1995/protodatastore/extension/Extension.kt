package com.leandro1995.protodatastore.extension

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.leandro1995.protodatastore.UserPreferences
import com.leandro1995.protodatastore.config.Setting
import com.leandro1995.protodatastore.datastore.UserSerializable

val Context.userPreferencesStore: DataStore<UserPreferences> by dataStore(
    fileName = Setting.DATA_STORE_PROTO,
    serializer = UserSerializable()
)