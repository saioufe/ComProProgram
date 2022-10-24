package com.example.comproprogram.fragments

import ComproPointsAdaptor
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.comproprogram.R
import com.example.comproprogram.adapters.PressedPageAdapter
import com.example.comproprogram.adapters.SliderPageAdapter
import com.example.comproprogram.data.ComProPoint
import com.example.comproprogram.data.Slider
import java.util.ArrayList


class ComproFragment : Fragment() {

    var sliderDotspanel: LinearLayout? = null

    private lateinit var dots: Array<ImageView?>
    val points: MutableList<ComProPoint> = ArrayList()
    val sliders: MutableList<Slider> = ArrayList()
    val imagesSliders: MutableList<Int> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        points.add(ComProPoint("Study on Campus" , R.drawable.comrpo1, "Begin with 8-13 months of study on our U.S. campus. Learn leading edge technologies.  Study with expert faculty, top academics, and proven personal growth courses." ))
        points.add(ComProPoint("Full-Time Paid Practicum" , R.drawable.compo2, "Internationals work for up to two years with a full-time paid practicum as a software developer in any company in the USA.  Average starting rate: \$80,000 – \$95,000 per year." ))
        points.add(ComProPoint("Further Education" , R.drawable.compo3, "Finish your remaining courses via distance education during evenings and weekends while working at your practicum position. 98% full-time paid practicum placement success." ))
        points.add(ComProPoint("Graduate with a Master’s Degree" , R.drawable.compo4, "Graduate and receive a Master’s Degree in Computer Science from your career-focused Master’s degree program. Congratulations!" ))

        sliders.add(Slider(R.drawable.acre, "Beautiful 391 Acre Campus", "Fairfield, Iowa"))
        sliders.add(
            Slider(
                R.drawable.tm,
                "Develop Your Inner Genius",
                "Our Secret Competitive Edge"
            )
        )
        sliders.add(
            Slider(
                R.drawable.international,
                "Over 4,000 Students",
                "From 100 Countries"
            )
        )

        imagesSliders.add(R.drawable.acre)
        imagesSliders.add(R.drawable.tm)
        imagesSliders.add(R.drawable.international)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_compro, container, false)


        val pointRecycler = v.findViewById<View>(R.id.compro_point_recycler) as RecyclerView


        val mViewPager: ViewPager2

        // Create adapter passing in the sample user data
        val adapter = ComproPointsAdaptor(points)
        // Attach the adapter to the recyclerview to populate items
        pointRecycler.adapter = adapter
        // Set layout manager to position the items
        pointRecycler.layoutManager = LinearLayoutManager(container?.context)
        pointRecycler.setNestedScrollingEnabled(false);

        sliderDotspanel = v.findViewById<View>(R.id.SliderDots) as LinearLayout


        val sliderPageAdapter: SliderPageAdapter
        var pressedPageAdapter: PressedPageAdapter


        // Initializing the ViewPager Object
        mViewPager = v.findViewById<View>(R.id.pager_slider) as ViewPager2


        // Initializing the ViewPagerAdapter
        sliderPageAdapter = SliderPageAdapter(container!!.context, sliders)

        mViewPager.adapter = sliderPageAdapter
        dots = arrayOfNulls(3)

        for (i in 0 until 3) {
            dots[i] = ImageView(container!!.context)
            dots[i]!!.setImageDrawable(
                getContext()?.let {
                    ContextCompat.getDrawable(
                        it,
                        R.drawable.non_active_slider_dot
                    )
                }
            )
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(4, 5, 4, 5)
            sliderDotspanel!!.addView(dots[i], params)
        }
        dots[0]!!.setImageDrawable(
            getContext()?.let {
                ContextCompat.getDrawable(
                    it,
                    R.drawable.active_slider_dot
                )
            }
        )
        mViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                for (i in 0 until 3) {
                    dots[i]!!
                        .setImageDrawable(
                            getContext()?.let {
                                ContextCompat.getDrawable(
                                    it,
                                    R.drawable.non_active_slider_dot
                                )
                            }
                        )
                }
                dots[position]!!
                    .setImageDrawable(
                        getContext()?.let {
                            ContextCompat.getDrawable(
                                it,
                                R.drawable.active_slider_dot
                            )
                        }
                    )
            }
        })

        return v
    }


}