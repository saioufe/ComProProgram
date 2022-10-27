package com.example.comproprogram.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.comproprogram.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder


class PracticumsFragment(con:Context) : Fragment() {
    var chart: BarChart? = null
    var materialDesignAnimatedDialog: NiftyDialogBuilder? = null
    var cox = con

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_practicums, container, false)

        materialDesignAnimatedDialog = NiftyDialogBuilder.getInstance(cox);

        chart = v.findViewById(R.id.chart)

        chart!!.setDrawBarShadow(false)
        chart!!.setDrawValueAboveBar(true)
        chart!!.description.isEnabled = false

        // scaling can now only be done on x- and y-axis separately
        chart!!.setPinchZoom(false)
        chart!!.setDrawGridBackground(false)
        val l: Legend = chart!!.legend
        l.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT
        l.orientation = Legend.LegendOrientation.HORIZONTAL
        l.setDrawInside(false)
        l.form = Legend.LegendForm.SQUARE
        l.formSize = 9f
        l.textSize = 11f
        l.xEntrySpace = 4f


        setData();

        return v
    }

    private fun setData() {

        val values: ArrayList<BarEntry> = ArrayList()


        chart!!.setDragEnabled(false)

        chart!!.xAxis.isEnabled = false
        chart!!.axisLeft.isEnabled = false
        chart!!.axisRight.isEnabled = false

        chart!!.setMaxVisibleValueCount(10)

        values.add(BarEntry(1f, 900f, resources.getDrawable(R.drawable.salary), "\$94,000\n" +
                "Average Starting Rates for Paid Curricular Practical Training"))
        values.add(BarEntry(2f, 890f , resources.getDrawable(R.drawable.company),  "1000+\n" +
                "Companies Recognize the Skills of Our Students"))
        values.add(BarEntry(3f, 1000f, resources.getDrawable(R.drawable.training), "98%\n" +
                "Paid Curricular Practical Training Placement Success Rate"))


        val set1 = BarDataSet(values, "The year 2022")
        set1.setDrawIcons(true)
        val dataSets: ArrayList<IBarDataSet> = ArrayList()
        dataSets.add(set1)
        val data = BarData(dataSets)
        data.setValueTextSize(0f)
        data.barWidth = 0.9f
        chart!!.data = data

        chart!!.animateY(500, Easing.EasingOption.EaseOutBack)

        chart!!.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {

            override fun onValueSelected(e: Entry?, h: Highlight?) {
               showDialog(e?.getData().toString())
               Log.i("saioufe", "this is selected : " + e?.getData().toString())
            }

            override fun onNothingSelected() {}
        })

    }

    fun showDialog( desc:String ) {
        materialDesignAnimatedDialog!!
            .withMessage(desc)
            .withDialogColor("#48b3ff")
            .withDuration(700)
            .withEffect(Effectstype.Sidefill)
            .show()
    }


}