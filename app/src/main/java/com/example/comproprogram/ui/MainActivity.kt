package com.example.comproprogram.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.comproprogram.R
import com.example.comproprogram.databinding.ActivityMainBinding
import com.example.comproprogram.fragments.ComproFragment
import com.example.comproprogram.fragments.FinancesFragment
import com.example.comproprogram.fragments.PracticumsFragment
import com.example.comproprogram.fragments.StudentLifeFragment
import java.util.concurrent.atomic.AtomicReference


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var homeBinding: ActivityMainBinding

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val toolbar = homeBinding.mainToolbar //findViewById<Toolbar>(R.id.main_toolbar)

        toolbar.title = ""
        toolbar.setBackgroundColor(resources.getColor(R.color.white, resources.newTheme()))
        setSupportActionBar(toolbar)


        val button1 = homeBinding.firstButton // findViewById<Button>(R.id.first_button)
        val button2 = homeBinding.secondButton // findViewById<Button>(R.id.second_button)
        val button3 = homeBinding.thirdButton // findViewById<Button>(R.id.third_button)
        val button4 = homeBinding.fourthButton// findViewById<Button>(R.id.fourth_button)


        val shapes: MutableList<View> = ArrayList()
        val shape1 = homeBinding.firstShape// findViewById<View>(R.id.first_shape)
        shapes.add(shape1)
        val shape2 = homeBinding.secondShape // findViewById<View>(R.id.second_shape)
        shapes.add(shape2)
        val shape3 = homeBinding.thirdShape // findViewById<View>(R.id.third_shape)
        shapes.add(shape3)
        val shape4 = homeBinding.fourthShape // findViewById<View>(R.id.fourth_shape)
        shapes.add(shape4)
        val visiableShape = AtomicReference(shape1)
        shape1.visibility = View.VISIBLE

        var comproFragment = ComproFragment()
        var studentFragment = StudentLifeFragment(this)
        var financesFragment = FinancesFragment()
        var practicumsFragment = PracticumsFragment(this)

        supportFragmentManager.beginTransaction()
            .add(R.id.mainContainer, comproFragment).commit()


        button1.setOnClickListener { view: View ->
            shape1.visibility = View.VISIBLE
            visiableShape.set(homeBinding.firstShape)
            turnOfTheOthers(shapes, shape1)

            supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, comproFragment).commit()
        }
        button2.setOnClickListener { view: View ->
            shape2.visibility = View.VISIBLE
            visiableShape.set(homeBinding.secondShape)
            turnOfTheOthers(shapes, shape2)


            supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, studentFragment).commit()
        }
        button3.setOnClickListener { view: View ->
            shape3.visibility = View.VISIBLE
            visiableShape.set(homeBinding.thirdShape)
            turnOfTheOthers(shapes, shape3)

            supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, financesFragment).commit()
        }
        button4.setOnClickListener { view: View ->
            shape4.visibility = View.VISIBLE
            visiableShape.set(homeBinding.fourthShape)
            turnOfTheOthers(shapes, shape4)

            supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, practicumsFragment).commit()
        }
    }

    private fun turnOfTheOthers(shapes: List<View>, visiableShape: View) {
        for (i in shapes.indices) {
            if (visiableShape !== shapes[i]) {
                shapes[i].visibility = View.INVISIBLE
            }
        }
    }

    fun topButtonPressed(view: View) {
        var intent = Intent(this, TopActivity::class.java)
        startActivity(intent)
    }


}