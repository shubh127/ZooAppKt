package com.shubham.zooappkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_info.*

class AnimalInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)

        getDateFromIntent()
    }

    private fun getDateFromIntent() {
        val bundle: Bundle = intent.extras
        val name = bundle.getString("name")
        val description = bundle.getString("description")
        val imageId = bundle.getInt("imageId")

        setDataInViews(name, description, imageId)
    }

    private fun setDataInViews(name: String?, description: String?, imageId: Int) {
        ivAnimaImage.setImageResource(imageId)
        tvName.text = name
        tvDes.text = description
    }
}
