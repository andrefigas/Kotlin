package devfigas.com.kotlinsample.model

import com.google.gson.annotations.SerializedName


data class Movie (@SerializedName("title")var mName : String,@SerializedName("category") var mCategory : String) {

}