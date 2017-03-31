package devfigas.com.kotlinsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import devfigas.com.kotlinsample.model.Movie
import devfigas.com.kotlinsample.model.MoviesCollection
import devfigas.com.kotlinsample.rest.EndPoints
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    var mMoviesAdapter : MoviesAdapter = MoviesAdapter();

    //start with null, and on change, send update to adapter
    var mMovies : MoviesCollection?  by Delegates.observable(null as MoviesCollection?){
        prop, old, new -> mMoviesAdapter.refresh(new as MoviesCollection)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rvList : RecyclerView? = findViewById(R.id.recycler_main) as RecyclerView
        rvList!!.layoutManager = LinearLayoutManager(this)
        rvList!!.adapter = mMoviesAdapter
        requestGetMovies()
    }

    /*
    * get content from API and refresh model
    */
    fun requestGetMovies(){
        val mEndPoints : EndPoints = Retrofit.Builder()
                .baseUrl("http://www.mocky.io/").addConverterFactory(GsonConverterFactory.create())
                .build().create(EndPoints::class.java)

        mEndPoints.getMovies().enqueue(object : Callback<MoviesCollection>{
            override fun onResponse(call: Call<MoviesCollection>, response: Response<MoviesCollection>) {
                mMovies = response.body()//refresh observed model
            }

            override fun onFailure(call: Call<MoviesCollection>, t: Throwable) {

            }
        })
    }

}
