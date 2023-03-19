package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.collections.ArrayList
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(
    var animals: ArrayList<Animal>,
    var context: Context
) :RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var textViewAnimalName : TextView = itemView.findViewById(R.id.nameOfAnmal)
        var textViewAnimalShortDescription : TextView = itemView.findViewById(R.id.shortDesciption)
        var imageView : ImageView = itemView.findViewById(R.id.imageAnimal)
        var button : Button = itemView.findViewById(R.id.buttonDetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.animal_card,parent,false)

        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animals.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {

        holder.textViewAnimalName.text = animals.get(position).name
        holder.textViewAnimalShortDescription.text = animals.get(position).shortDescription
        holder.imageView.setImageResource(animals.get(position).picture)

        holder.button.setOnClickListener{

            var passingName = animals.get(position).name
            var passingDescription = animals.get(position).description

            var intent = Intent(context,SecondActivity::class.java)

            intent.putExtra("passingName", passingName)
            intent.putExtra("passingDescription", passingDescription)

            context.startActivity(intent)

        }
    }
}