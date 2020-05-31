package com.workshopdemo1

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var onGenderSelectedListener: AdapterView.OnItemSelectedListener
    var gender=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpResetButton()
        setupSubmitButton()
        setupGenderDropdown()
    }

    private fun setupGenderDropdown() {
        onGenderSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                if(view!=null){
                    gender = (view as TextView).text.toString()
                    Toast.makeText(this@MainActivity, "$gender is selected", Toast.LENGTH_SHORT)
                        .show()
                }


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //
                Toast.makeText(this@MainActivity, "Nothing selected", Toast.LENGTH_SHORT).show()
            }
        }

        sp_gender.onItemSelectedListener = onGenderSelectedListener
    }

    private fun setUpResetButton() {
        btn_reset.setOnClickListener {
            // perform this
            et_name.setText("")
            et_email.setText("")
            et_phone.setText("")
        }
    }

    private fun setupSubmitButton() {
        btn_submit.setOnClickListener {
            // fetch data from fields
            var name = et_name.text.toString()
            var email = et_email.text.toString()
            var phone = et_phone.text.toString()


            // validate all values
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(phone)) {
                Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(gender == "Select"){
                Toast.makeText(this, "Please select a valid gender", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }



            // validate if authorized
            if (cb_authorize.isChecked) {
                // proceed, the user authorized it
                // INTENT +DATA+ ACTION

                // send the data
                var intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                intent.putExtra("phone", phone)
                intent.putExtra("gender", gender)
                startActivity(intent)

            } else
                Toast.makeText(this, "Please Authorize", Toast.LENGTH_SHORT).show()
        }
    }
}
