package com.shubham.zooappkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Navigator {

    var animalsList = mutableListOf<Animals>()
    var adapter: AnimalsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateList()

        adapter = AnimalsAdapter(this, animalsList,this)
        lv_animals_list.adapter = adapter

    }

    override fun delete(index: Int) {
        animalsList.removeAt(index)
        adapter?.notifyDataSetChanged()
    }

    private fun populateList() {
        animalsList.add(
            Animals(
                name = getString(R.string.baboon),
                description = getString(R.string.baboon_description),
                imageId = R.drawable.baboon,
                isKiller = false
            )
        )
        animalsList.add(
            Animals(
                name = getString(R.string.bulldog),
                description = getString(R.string.bulldog_description),
                imageId = R.drawable.bulldog,
                isKiller = true
            )
        )
        animalsList.add(
            Animals(
                name = getString(R.string.panda),
                description = getString(R.string.panda_description),
                imageId = R.drawable.panda,
                isKiller = false
            )
        )
        animalsList.add(
            Animals(
                name = getString(R.string.swallo_bird),
                description = getString(R.string.swallow_bird_description),
                imageId = R.drawable.swallow_bird,
                isKiller = false
            )
        )
        animalsList.add(
            Animals(
                name = getString(R.string.white_tiger),
                description = getString(R.string.white_tiger_description),
                imageId = R.drawable.white_tiger,
                isKiller = true
            )
        )
        animalsList.add(
            Animals(
                name = getString(R.string.zebra),
                description = getString(R.string.zebra_description),
                imageId = R.drawable.zebra,
                isKiller = false
            )
        )

    }

}