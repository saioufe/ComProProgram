package com.example.comproprogram.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.TextView
import android.os.Bundle
import android.os.Build
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.example.comproprogram.adapters.TopPageAdapter
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.comproprogram.R
import com.example.comproprogram.data.TopMainSlide
import java.util.ArrayList

class TopActivity : AppCompatActivity() {
    var sliderPressedDotspanel: LinearLayout? = null
    private var dotscount = 0
    private lateinit var dots: Array<ImageView?>

    lateinit var title: TextView
    lateinit var smallDesc: TextView
    lateinit var firstImage: ImageView
    lateinit var secondImage: ImageView
    lateinit var thirdImage: ImageView
    lateinit var fourthImage: ImageView
    lateinit var selectedTop: TopMainSlide


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        sliderPressedDotspanel = findViewById<View>(R.id.SliderDotsSecond) as LinearLayout

        title = findViewById<View>(R.id.top_title) as TextView
        smallDesc = findViewById<View>(R.id.top_desc) as TextView

        firstImage = findViewById<View>(R.id.top_first_image) as ImageView
        secondImage = findViewById<View>(R.id.top_second_image) as ImageView
        thirdImage = findViewById<View>(R.id.top_third_image) as ImageView
        fourthImage = findViewById<View>(R.id.top_fourth_image) as ImageView

        val pressedViewPager: ViewPager2


        val topMainSliders: MutableList<TopMainSlide> = ArrayList()


        topMainSliders.add(
            TopMainSlide(
                "MIU dining hall",
                "Top healthy food in Annapurna Dining Hall ",
                R.drawable.dining,
                listOf(R.drawable.food1, R.drawable.dining, R.drawable.food2, R.drawable.food3)
            )
        )
        topMainSliders.add(
            TopMainSlide(
                "University Housing",
                "Great residential experience for students while cultivating academic achievement and personal growth",
                R.drawable.housing1,
                listOf(
                    R.drawable.housing2,
                    R.drawable.housing3,
                    R.drawable.housing1,
                    R.drawable.housing4
                )
            )
        )
        topMainSliders.add(
            TopMainSlide(
                "Transcendental Meditation",
                "Reach a new and Higher States of Consciousness with TM",
                R.drawable.tm1,
                listOf(
                    R.drawable.tm2,
                    R.drawable.tm3,
                    R.drawable.tm4,
                    R.drawable.tm1
                )
            )
        )




        selectedTop = topMainSliders.get(0)


        // Creating Object of ViewPagerAdapter
        pressedViewPager = findViewById<View>(R.id.back_slider) as ViewPager2
        val topPageAdapter = TopPageAdapter(this, topMainSliders)
        pressedViewPager.adapter = topPageAdapter
        dotscount = topMainSliders.size
        dots = arrayOfNulls(dotscount)
        for (i in 0 until dotscount) {
            dots[i] = ImageView(this)
            dots[i]!!.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.non_active_pressed_slider
                )
            )
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(4, 5, 4, 5)
            sliderPressedDotspanel!!.addView(dots[i], params)
        }
        dots[0]!!.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext,
                R.drawable.active_pressed_slider
            )
        )

        pressedViewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                selectedTop = topMainSliders.get(position)
                title.setText(selectedTop.title)
                smallDesc.setText(selectedTop.desc)
                firstImage.setImageDrawable(resources.getDrawable(selectedTop.smallImages.get(0)))
                secondImage.setImageDrawable(resources.getDrawable(selectedTop.smallImages.get(1)))
                thirdImage.setImageDrawable(resources.getDrawable(selectedTop.smallImages.get(2)))
                fourthImage.setImageDrawable(resources.getDrawable(selectedTop.smallImages.get(3)))
                super.onPageSelected(position)
                for (i in 0 until dotscount) {
                    dots[i]!!
                        .setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext,
                                R.drawable.non_active_pressed_slider
                            )
                        )
                }
                dots[position]!!
                    .setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.active_pressed_slider
                        )
                    )
            }
        })
    }

    fun readMore(view: View) {
        var int: Intent = Intent(this, PressedTopActivity::class.java)
        var selectedDesign = when (selectedTop.title) {
            "MIU dining hall" -> "1"
            "University Housing" -> "2"
            else -> "3"

        }
        int.putExtra("design", selectedDesign)
        startActivity(int)
    }
}