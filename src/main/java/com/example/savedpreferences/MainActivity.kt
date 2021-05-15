package com.example.savedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        btnSave.setOnClickListener {
            val name = editTextName.text.toString()
            val city = editTextCity.text.toString()
            val person = checkBox.isChecked

            editor.apply {
                putString("name",name)
                putString("city", city)
                putBoolean("isPerson",person)
                apply()
            }
        }

        btnLoad.setOnClickListener {
            val name = sharedPref.getString("name",null)
            val city = sharedPref.getString("city",null)
            val person = sharedPref.getBoolean("isPerson",false)

            editTextName.setText(name)
            editTextCity.setText(city)
            checkBox.isChecked = person
        }
    }
}