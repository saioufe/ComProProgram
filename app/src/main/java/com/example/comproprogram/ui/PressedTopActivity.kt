package com.example.comproprogram.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.comproprogram.R


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
            setContentView(R.layout.tm_pressed)
        }


    }
}