package com.leandro1995.protodatastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.leandro1995.protodatastore.datastore.config.UserDataStore

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {

            UserDataStore.nameUser(string = findViewById<EditText>(R.id.editTextTextPersonName).text.toString())

            Toast.makeText(this, "Se guardo", Toast.LENGTH_SHORT).show()
        }

        if (UserDataStore.nameUser().isEmpty()) {

            findViewById<TextView>(R.id.textView2).text = "No hay nombre"
        } else {

            findViewById<TextView>(R.id.textView2).text = "Su nombre: ${UserDataStore.nameUser()}"
        }
    }
}