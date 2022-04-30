package com.example.labwork4_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class UsersAdapter (
    private val inflater : LayoutInflater
    ) : ListAdapter<MainActivity.User, UsersAdapter.ViewHolder> (MyCallback()) {

        class ViewHolder (view: View ) : RecyclerView.ViewHolder(view) {
            private val name = view.findViewById<TextView>(R.id.name)
            private val age = view.findViewById<TextView>(R.id.age)
            private val email = view.findViewById<TextView>(R.id.email)

            fun bind (user: MainActivity.User) {
                name.text = user.name
                age.text = user.age.toString()
                email.text = user.email
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapter.ViewHolder {
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersAdapter.ViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    class MyCallback : DiffUtil.ItemCallback<MainActivity.User> () {
        override fun areItemsTheSame(
            oldItem: MainActivity.User,
            newItem: MainActivity.User
        ): Boolean = oldItem == newItem


        override fun areContentsTheSame(
            oldItem: MainActivity.User,
            newItem: MainActivity.User
        ): Boolean {
            return oldItem.name == newItem.name && oldItem.age == newItem.age && oldItem.email == newItem.email
        }
    }

}