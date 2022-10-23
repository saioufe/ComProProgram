

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.comproprogram.R
import android.widget.TextView
import com.example.comproprogram.data.ComProPoint

class ComproPointsAdaptor(private val points: List<ComProPoint>) :
    RecyclerView.Adapter<ComproPointsAdaptor.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val pointView =
            inflater.inflate(R.layout.compro_point_item, parent, false)

        // Return a new holder instance
        return ViewHolder(pointView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val point = points[position]

        // Set item views based on your views and data model
        val textView = holder.titleTextView
        textView.text = point.title
        val textView2 = holder.descTextView
        textView2.text = point.description
        val imageView = holder.pointImageView
        imageView.setImageResource(point.image)
        // Glide.with(imageView).load(product.getImage()).into(imageView);
    }

    override fun getItemCount(): Int {
        return points.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTextView: TextView
        var descTextView: TextView
        var pointImageView: ImageView

        init {
            titleTextView = itemView.findViewById<View>(R.id.point_title) as TextView
            descTextView = itemView.findViewById<View>(R.id.point_desc) as TextView
            pointImageView = itemView.findViewById<View>(R.id.point_image) as ImageView
        }
    }
}