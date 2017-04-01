package devfigas.com.parcelable

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var user : User = intent.getParcelableExtra("user")
        bindData(user)
    }
    fun bindData(user : User){
        checkNotNull(user)
        val tvDescription = findViewById(R.id.detail_description) as TextView
        if(user.subscribed){
            tvDescription.text = String.format(getString(R.string.salutation_positive),user.name)
        }else{
            tvDescription.text = String.format(getString(R.string.salutation_negative),user.name)
        }
    }
}
