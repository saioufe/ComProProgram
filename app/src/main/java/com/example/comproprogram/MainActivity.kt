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
import java.util.ArrayList
import java.util.concurrent.atomic.AtomicReference

class MainActivity : AppCompatActivity() {
    var sliderDotspanel: LinearLayout? = null
    private var dotscount = 0
    private lateinit var dots: Array<ImageView?>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sliderDotspanel = findViewById<View>(R.id.SliderDots) as LinearLayout

        val points: MutableList<ComProPoint> = ArrayList()
        points.add(ComProPoint("Study on Campus" , R.drawable.comrpo1, "Begin with 8-13 months of study on our U.S. campus. Learn leading edge technologies.  Study with expert faculty, top academics, and proven personal growth courses." ))
        points.add(ComProPoint("Full-Time Paid Practicum" , R.drawable.compo2, "Internationals work for up to two years with a full-time paid practicum as a software developer in any company in the USA.  Average starting rate: \$80,000 – \$95,000 per year." ))
        points.add(ComProPoint("Further Education" , R.drawable.compo3, "Finish your remaining courses via distance education during evenings and weekends while working at your practicum position. 98% full-time paid practicum placement success." ))
        points.add(ComProPoint("Graduate with a Master’s Degree" , R.drawable.compo4, "Graduate and receive a Master’s Degree in Computer Science from your career-focused Master’s degree program. Congratulations!" ))


        val pointRecycler = findViewById<View>(R.id.compro_point_recycler) as RecyclerView

        // Create adapter passing in the sample user data
        val adapter = ComproPointsAdaptor(points)
        // Attach the adapter to the recyclerview to populate items
        pointRecycler.adapter = adapter
        // Set layout manager to position the items
        pointRecycler.layoutManager = LinearLayoutManager(this)
        pointRecycler.setNestedScrollingEnabled(false);

        // creating object of ViewPager
        val mViewPager: ViewPager2


        // sliders array
        val sliders: MutableList<Slider> = ArrayList()
        sliders.add(Slider(R.drawable.app_image1, "Baghdad Tower", "Larges tower in baghdad"))
        sliders.add(
            Slider(
                R.drawable.app_image2,
                "Central Bank of Baghdad",
                "Illustration image for the bank"
            )
        )
        sliders.add(
            Slider(
                R.drawable.app_image3,
                "Zoha Hadded Design",
                "The first design for Zoha"
            )
        )
        val imagesSliders: MutableList<Int> = ArrayList()
        imagesSliders.add(R.drawable.app_image1)
        imagesSliders.add(R.drawable.app_image2)
        imagesSliders.add(R.drawable.app_image3)


        // Creating Object of ViewPagerAdapter
        val sliderPageAdapter: SliderPageAdapter
        var pressedPageAdapter: PressedPageAdapter
        val toolbar = findViewById<Toolbar>(R.id.main_toolbar)
        toolbar.title = ""
        toolbar.setBackgroundColor(resources.getColor(R.color.white, resources.newTheme()))
        setSupportActionBar(toolbar)

        // Initializing the ViewPager Object
        mViewPager = findViewById<View>(R.id.pager_slider) as ViewPager2


        // Initializing the ViewPagerAdapter
        sliderPageAdapter = SliderPageAdapter(this@MainActivity, sliders)


        // Adding the Adapter to the ViewPager
        mViewPager.adapter = sliderPageAdapter
        dotscount = sliders.size
        dots = arrayOfNulls(dotscount)
        for (i in 0 until dotscount) {
            dots[i] = ImageView(this)
            dots[i]!!.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.non_active_slider_dot
                )
            )
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(4, 5, 4, 5)
            sliderDotspanel!!.addView(dots[i], params)
        }
        dots[0]!!.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext,
                R.drawable.active_slider_dot
            )
        )
        mViewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                for (i in 0 until dotscount) {
                    dots[i]!!
                        .setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext,
                                R.drawable.non_active_slider_dot
                            )
                        )
                }
                dots[position]!!
                    .setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.active_slider_dot
                        )
                    )
            }
        })
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
        button1.setOnClickListener { view: View ->
            shape1.visibility = View.VISIBLE
            visiableShape.set(view)
            turnOfTheOthers(shapes, shape1)
            val intent = Intent(this, PressedActivity::class.java)
            val message = "East Iraq"
            intent.putExtra("Title", message)
            startActivity(intent)
        }
        button2.setOnClickListener { view: View ->
            shape2.visibility = View.VISIBLE
            visiableShape.set(view)
            turnOfTheOthers(shapes, shape2)
            val intent = Intent(this, PressedActivity::class.java)
            val message = "West Iraq"
            intent.putExtra("Title", message)
            startActivity(intent)
        }
        button3.setOnClickListener { view: View ->
            shape3.visibility = View.VISIBLE
            visiableShape.set(view)
            turnOfTheOthers(shapes, shape3)
            val intent = Intent(this, PressedActivity::class.java)
            val message = "North Iraq"
            intent.putExtra("Title", message)
            startActivity(intent)
        }
        button4.setOnClickListener { view: View ->
            shape4.visibility = View.VISIBLE
            visiableShape.set(view)
            turnOfTheOthers(shapes, shape4)
            val intent = Intent(this, PressedActivity::class.java)
            val message = "South Iraq"
            intent.putExtra("Title", message)
            startActivity(intent)
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