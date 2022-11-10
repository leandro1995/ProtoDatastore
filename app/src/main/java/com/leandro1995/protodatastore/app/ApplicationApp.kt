package com.leandro1995.protodatastore.app

import android.app.Application
import com.leandro1995.protodatastore.datastore.config.UserDataStore

class ApplicationApp : Application() {

    override fun onCreate() {
        super.onCreate()

        UserDataStore.instance(context = this)
    }
}