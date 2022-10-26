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

//        holder.title.setText(slide.title)
//        holder.smallDesc.setText(slide.desc)
//        holder.firstImage.setImageDrawable(context.resources.getDrawable(slide.smallImages.get(0)))
//        holder.secondImage.setImageDrawable(context.resources.getDrawable(slide.smallImages.get(1)))
//        holder.thirdImage.setImageDrawable(context.resources.getDrawable(slide.smallImages.get(2)))
//        holder.fourthImage.setImageDrawable(context.resources.getDrawable(slide.smallImages.get(3)))

    }

    override fun getItemCount(): Int {
        return sliders.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mainImage: ImageView
//        var title: TextView
//        var smallDesc : TextView
//        var firstImage: ImageView
//        var secondImage: ImageView
//        var thirdImage: ImageView
//        var fourthImage: ImageView


        init {
            mainImage = itemView.findViewById<View>(R.id.pressedImageView) as ImageView

//            title = itemView.findViewById<View>(R.id.top_title) as TextView
//            smallDesc = itemView.findViewById<View>(R.id.top_desc) as TextView
//
//            firstImage = itemView.findViewById<View>(R.id.top_first_image) as ImageView
//            secondImage = itemView.findViewById<View>(R.id.top_second_image) as ImageView
//            thirdImage = itemView.findViewById<View>(R.id.top_third_image) as ImageView
//            fourthImage = itemView.findViewById<View>(R.id.top_fourth_image) as ImageView
        }
    }
}