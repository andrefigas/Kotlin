package devfigas.com.kotlinsample

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import devfigas.com.kotlinsample.model.Movie

class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvTitle: TextView
    private val tvCategory: TextView

    init {
        tvTitle = itemView.findViewById(R.id.item_title) as TextView
        tvCategory = itemView.findViewById(R.id.item_category) as TextView
    }

    fun bind(movie : Movie) {
        tvTitle.text = movie.mName
        tvCategory.text = movie.mCategory
    }
}