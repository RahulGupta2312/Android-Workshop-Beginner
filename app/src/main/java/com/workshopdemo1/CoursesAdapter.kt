package com.workshopdemo1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.item_course.view.*

class CoursesAdapter(private val courses : ArrayList<CourseModel>) : BaseAdapter(){

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        // inflate layout
        var v = LayoutInflater.from(p2?.context).inflate(R.layout.item_course,p2,false)

        val course = courses[position]
        // set data here
        v.textView3.text=course.name
        v.textView4.text=course.description
        v.textView5.text=course.cost.toString()+ "$"

        if(position%2==0){
            v.setBackgroundColor(ContextCompat.getColor(p2!!.context,R.color.course_background_color))
        }
        if(course.onSale){
            v.textView6.visibility=View.VISIBLE
        }
        else{
            v.textView6.visibility=View.GONE
        }
        if(position%5==0){
            v.imageView.setImageResource(R.drawable.dummy_user)
        }

        // return the view with data
        return v
    }

    override fun getItem(postion: Int): Any {
        return courses[postion]
    }

    override fun getItemId(position: Int): Long {
        return courses[position].id.toLong()
    }

    override fun getCount(): Int {
        return courses.size
    }


}