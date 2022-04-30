package com.example.labwork4_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class old_UserAdapter(private val list: MutableList<MainActivity.User>,
                      private val inflater: LayoutInflater
                  ) : BaseAdapter() {

    private data  class ViewHolder (
        val  name:  TextView,
        val age: TextView,
        val email: TextView
    )

    override fun getCount(): Int = list.size

    override fun getItem(p0: Int): Any = 0

    override fun getItemId(p0: Int): Long = 0

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = p1 ?: inflater.inflate(R.layout.list_item, p2, false).also {

            val name = it.findViewById<TextView>(R.id.name)
            val age = it.findViewById<TextView>(R.id.age)
            val email = it.findViewById<TextView>(R.id.email)

            val holder = ViewHolder (name, age, email)
            it.tag = holder

        }

        val holder = view.tag as ViewHolder
        holder.name.text = list[p0].name
        holder.age.text = list[p0].age.toString()
        holder.email.text = list[p0].email

        return view
    }

}