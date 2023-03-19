package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    var animals = ArrayList<Animal>()

    lateinit var adapter: AnimalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rV)

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        var cat = Animal("Pixel", "Cat", "Cat\nfuture ptogrammer", R.drawable.cat2, R.drawable.cat)
        var dog = Animal("Daisy", "Dog", "Cocker Spaniel\n Waiting to be\nadopted ", R.drawable.dog2, R.drawable.dog)
        var parrot = Animal ("Albert", "Parrot", "Ara\nLoves singing and telling jokes", R.drawable.parrot2,R.drawable.parrot)

        animals.add(cat)
        animals.add(dog)
        animals.add(parrot)

        adapter = AnimalAdapter(animals, this@MainActivity)

        recyclerView.adapter = adapter

    }
}