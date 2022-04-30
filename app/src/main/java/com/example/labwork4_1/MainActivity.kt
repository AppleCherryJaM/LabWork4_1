package com.example.labwork4_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labwork4_1.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val list: MutableList<User> = mutableListOf()
    private val userList : List<User> = arrayListOf (
        User("Petya", "+380976543221", "petya@domain.com", "123", 18),
        User("Vova", "+3806763243121", "vova@domain.com", "123", 19),
        User("Alex", "+380441023321", "alex@domain.com", "123", 20),
        User("Tom", "+184567212", "tom@domain.com", "123", 21),
        User("Sam", "+1347628", "sam@domain.com", "123", 17),
        User("Ann", "+58092872392", "ann@domain.com", "123", 19)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val adapter = UsersAdapter(layoutInflater)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.submitList(null)

        binding.buttonAdd.setOnClickListener {
            val randInt = Random.nextInt(0, 5)
            list.add(userList[randInt])

            adapter.submitList(list.toList())
        }
        binding.buttonClear.setOnClickListener {
            if (list.isNotEmpty()) {
                list.removeLast()
                adapter.submitList(list.toList())
            }
        }

        binding.buttonClear.setOnClickListener {
            list.clear()
            adapter.submitList(list.toList())
        }
    }

    data class User (val name: String, val phone: String, val email: String, val password: String, val age: Int)
}