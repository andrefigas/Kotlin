package devfigas.com.kotlinsample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import devfigas.com.kotlinsample.model.MoviesCollection

class MoviesAdapter : RecyclerView.Adapter<MoviesViewHolder>() {

    var mMoviesCollection: MoviesCollection? = null;

    override fun onBindViewHolder(holder: MoviesViewHolder?, position: Int) {
        holder!!.bind(mMoviesCollection!!.mMovies!![position])
    }

    override fun getItemCount(): Int {
        if(mMoviesCollection == null || mMoviesCollection!!.mMovies == null){
            return 0
        }else return mMoviesCollection!!.mMovies!!.size
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MoviesViewHolder {
        val context : Context = parent!!.context
        val view : View = LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false)
        return MoviesViewHolder(view)
    }
    fun refresh( moviesCollection: MoviesCollection){
        mMoviesCollection = moviesCollection
        notifyDataSetChanged()
    }

}