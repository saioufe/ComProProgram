package com.example.comproprogram

import ComproPointsAdaptor
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import android.os.Bundle
import com.example.comproprogram.R
import androidx.viewpager2.widget.ViewPager2
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import android.content.Intent
import android.graphics.Point
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comproprogram.PressedActivity
import com.example.comproprogram.adapters.PressedPageAdapter
import com.example.comproprogram.adapters.SliderPageAdapter
import com.example.comproprogram.data.ComProPoint
import com.example.comproprogram.data.Slider
import com.example.comproprogram.fragments.ComproFragment

import java.util.ArrayList
import java.util.concurrent.atomic.AtomicReference

class MainActivity : AppCompatActivity() {

    private var dotscount = 0
    private lateinit var dots: Array<ImageView?>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.main_toolbar)
        toolbar.title = ""
        toolbar.setBackgroundColor(resources.getColor(R.color.white, resources.newTheme()))
        setSupportActionBar(toolbar)



        val shapes: MutableList<View> = ArrayList()
        val button1 = findViewById<Button>(R.id.first_button)
        val button2 = findViewById<Button>(R.id.second_button)
        val button3 = findViewById<Button>(R.id.third_button)
        val button4 = findViewById<Button>(R.id.fourth_button)
        val shape1 = findViewById<View>(R.id.first_shape)
        shapes.add(shape1)
        val shape2 = findViewById<View>(R.id.second_shape)
        shapes.add(shape2)
        val shape3 = findViewById<View>(R.id.third_shape)
        shapes.add(shape3)
        val shape4 = findViewById<View>(R.id.fourth_shape)
        shapes.add(shape4)
        val visiableShape = AtomicReference(shape1)
        shape1.visibility = View.VISIBLE

        var comproFragment:ComproFragment = ComproFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.mainContainer, comproFragment).commit()


        button1.setOnClickListener { view: View ->
            shape1.visibility = View.VISIBLE
            visiableShape.set(view)
            turnOfTheOthers(shapes, shape1)
            var comproFragment:ComproFragment = ComproFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, comproFragment).commit()
        }
        button2.setOnClickListener { view: View ->
            shape2.visibility = View.VISIBLE
            visiableShape.set(view)
            turnOfTheOthers(shapes, shape2)

            var comproFragment:ComproFragment = ComproFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, comproFragment).commit()
        }
        button3.setOnClickListener { view: View ->
            shape3.visibility = View.VISIBLE
            visiableShape.set(view)
            turnOfTheOthers(shapes, shape3)
            var comproFragment:ComproFragment = ComproFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, comproFragment).commit()
        }
        button4.setOnClickListener { view: View ->
            shape4.visibility = View.VISIBLE
            visiableShape.set(view)
            turnOfTheOthers(shapes, shape4)
            var comproFragment:ComproFragment = ComproFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, comproFragment).commit()
        }
    }

    private fun turnOfTheOthers(shapes: List<View>, visiableShape: View) {
        for (i in shapes.indices) {
            if (visiableShape !== shapes[i]) {
                shapes[i].visibility = View.INVISIBLE
            }
        }
    }


}