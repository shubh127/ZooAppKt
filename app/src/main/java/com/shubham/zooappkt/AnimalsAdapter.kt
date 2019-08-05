package com.shubham.zooappkt

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.animal_ticket.view.*

class AnimalsAdapter() : BaseAdapter() {
    var context: Context? = null
    var animalsList: MutableList<Animals>? = null
    var listner: Navigator? = null

    constructor(context: Context, animalsList: MutableList<Animals>, listner: Navigator) : this() {
        this.context = context
        this.animalsList = animalsList
        this.listner = listner
    }

    override fun getView(index: Int, p1: View?, p2: ViewGroup?): View {
        val animal = animalsList?.get(index)
        val inflator = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        return if (animal?.isKiller as Boolean) {
            val myView = inflator.inflate(R.layout.animal_killer_ticket, null)
            myView.tv_animal_name.text = animal.name
            myView.tv_animal_description.text = animal.description
            myView.iv_animal_image.setImageResource(animal.imageId as Int)
            myView.setOnClickListener {
                val intent = Intent(context, AnimalInfo::class.java)
                intent.putExtra("name", animal.name)
                intent.putExtra("description", animal.description)
                intent.putExtra("imageId", animal.imageId as Int)
                context?.startActivity(intent)
            }
            myView.iv_animal_image.setOnClickListener { listner?.delete(index) }
            myView
        } else {
            val myView = inflator.inflate(R.layout.animal_ticket, null)
            myView.tv_animal_name.text = animal.name
            myView.tv_animal_description.text = animal.description
            myView.iv_animal_image.setImageResource(animal.imageId as Int)
            myView.setOnClickListener {
                val intent = Intent(context, AnimalInfo::class.java)
                intent.putExtra("name", animal.name)
                intent.putExtra("description", animal.description)
                intent.putExtra("imageId", animal.imageId as Int)
                context?.startActivity(intent)
            }
            myView.iv_animal_image.setOnClickListener { listner?.delete(index) }
            myView
        }
    }

    override fun getItem(index: Int): Any {
        return animalsList?.get(index) as Animals
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return animalsList?.size as Int
    }
}