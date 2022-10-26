package com.example.comproprogram.adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.comproprogram.R
import com.example.comproprogram.data.TopMainSlide

class TopPageAdapter(var context: Context, var sliders: MutableList<TopMainSlide>) :
    RecyclerView.Adapter<TopPageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val imageView =
            inflater.inflate(R.layout.pressed_image_view, parent, false)

        // Return a new holder instance
        return ViewHolder(imageView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val slide = sliders[position]

        // Set item views based on your views and data model
        val imageView = holder.mainImage
        val drawable = context.resources.getDrawable(slide.bg)
        imageView.setImageDrawable(drawable)

    }

    override fun getItemCount(): Int {
        return sliders.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mainImage: ImageView

        init {
            mainImage = itemView.findViewById<View>(R.id.pressedImageView) as ImageView

        }
    }
}