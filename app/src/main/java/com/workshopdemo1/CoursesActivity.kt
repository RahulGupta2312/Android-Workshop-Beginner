package com.workshopdemo1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_courses.*

class CoursesActivity : AppCompatActivity() {

    lateinit var coursesAdapter: CoursesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        setupCoursesList()
    }

    private fun setupCoursesList() {

        val list = ArrayList<CourseModel>()
        list.add(CourseModel(1, "Android Development", 1000.00, onSale = true))
        list.add(CourseModel(2, "iOS Development", 2000.00, onSale = true))
        list.add(CourseModel(2, "iOS Development", 2000.00))
        list.add(CourseModel(3, "PHP Development", 1500.00))
        list.add(CourseModel(3, "PHP Development", 1500.00))
        list.add(CourseModel(4, ".Net Development", 4500.00))
        list.add(CourseModel(4, ".Net Development", 4500.00, onSale = true))
        list.add(CourseModel(4, ".Net Development", 4500.00))
        list.add(CourseModel(4, ".Net Development", 4500.00))
        list.add(CourseModel(4, ".Net Development", 4500.00, " Developer web applications using Microsoft .NET Framework 4.5"))
        list.add(CourseModel(3, "PHP Development", 1500.00))

        coursesAdapter = CoursesAdapter(list)
        list_courses.adapter = coursesAdapter

        list_courses.setOnItemClickListener { adapterView, view, i, l ->

            AlertDialog.Builder(this).setTitle("Click Title")
                .setMessage("$i has been clicked by user")
                .setPositiveButton("Okay") { d, _->
                    d.dismiss()
                }.create().show()

        }
    }


    fun makeUpiTransfer(amount:Double, senderUpi:String, receiverUpi:String){
        // make


        // return transaction data
    }
}