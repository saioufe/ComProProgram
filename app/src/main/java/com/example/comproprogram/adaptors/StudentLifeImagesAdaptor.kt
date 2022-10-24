package com.example.comproprogram.adaptors


import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.example.comproprogram.R


//import com.squareup.picasso.Picasso

class StudentLifeImagesAdaptor(var context: Context, var images: List<String>) :
    RecyclerView.Adapter<StudentLifeImagesAdaptor.ViewHolder>() {

//    init {
//        Picasso.get().isLoggingEnabled = true
//    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val v =
            inflater.inflate(R.layout.student_life_image, parent, false)

        // Return a new holder instance
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = images[position]

        val imageView = holder.mainImage

        Glide
            .with(imageView)
            .load(image)
            .centerCrop()
            .placeholder(R.drawable.logo)
            .into(imageView);
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mainImage: ImageView

        init {
            mainImage = itemView.findViewById<View>(R.id.student_image) as ImageView
        }
    }


}