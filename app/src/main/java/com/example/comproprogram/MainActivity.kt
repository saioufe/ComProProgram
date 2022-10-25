package com.example.comproprogram

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.comproprogram.fragments.ComproFragment
import com.example.comproprogram.fragments.FinancesFragment
import com.example.comproprogram.fragments.PracticumsFragment
import com.example.comproprogram.fragments.StudentLifeFragment
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder
import java.util.concurrent.atomic.AtomicReference


class MainActivity : AppCompatActivity() {


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

        var comproFragment = ComproFragment()
        var studentFragment = StudentLifeFragment(this)
        var financesFragment = FinancesFragment()
        var practicumsFragment = PracticumsFragment(this)

        supportFragmentManager.beginTransaction()
            .add(R.id.mainContainer, comproFragment).commit()


        button1.setOnClickListener { view: View ->
            shape1.visibility = View.VISIBLE
            visiableShape.set(view)
            turnOfTheOthers(shapes, shape1)

            supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, comproFragment).commit()
        }
        button2.setOnClickListener { view: View ->
            shape2.visibility = View.VISIBLE
            visiableShape.set(view)
            turnOfTheOthers(shapes, shape2)


            supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, studentFragment).commit()
        }
        button3.setOnClickListener { view: View ->
            shape3.visibility = View.VISIBLE
            visiableShape.set(view)
            turnOfTheOthers(shapes, shape3)

            supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, financesFragment).commit()
        }
        button4.setOnClickListener { view: View ->
            shape4.visibility = View.VISIBLE
            visiableShape.set(view)
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
        var intent = Intent(this , TopActivity::class.java)
        startActivity(intent)
    }


}