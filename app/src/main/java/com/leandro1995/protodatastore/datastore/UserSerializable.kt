package com.leandro1995.protodatastore.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import com.leandro1995.protodatastore.UserPreferences
import java.io.InputStream
import java.io.OutputStream

class UserSerializable : Serializer<UserPreferences> {

    override val defaultValue: UserPreferences = UserPreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserPreferences {

        try {

            return UserPreferences.parseFrom(input)

        } catch (exception: InvalidProtocolBufferException) {

            throw CorruptionException("", exception)
        }
    }

    override suspend fun writeTo(t: UserPreferences, output: OutputStream) {

        t.writeTo(output)
    }
}