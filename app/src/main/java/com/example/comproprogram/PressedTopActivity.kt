package com.example.comproprogram

import ComproPointsAdaptor
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comproprogram.data.ComProPoint
import com.google.android.material.appbar.CollapsingToolbarLayout
import java.util.ArrayList


class PressedTopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var intent = getIntent()
        var design =  intent.getStringExtra("design")

        if(design == "1"){
            setContentView(R.layout.activity_pressed_top)
        }else if(design == "2") {
            setContentView(R.layout.housing_pressed)
        }else {
            setContentView(R.layout.housing_pressed)
        }


    }
}