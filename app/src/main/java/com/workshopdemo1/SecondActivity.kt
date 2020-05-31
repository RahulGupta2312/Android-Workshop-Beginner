package com.workshopdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        fetchAndShowData()
    }

    private fun fetchAndShowData() {
        txt_name.text = "Name: ${intent.getStringExtra("name")}"
        txt_email.text = intent.getStringExtra("email")
        txt_phone.text = intent.getStringExtra("phone")
        txt_gender.text = intent.getStringExtra("gender")
    }
}
