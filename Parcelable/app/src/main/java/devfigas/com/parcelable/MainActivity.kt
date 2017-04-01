package devfigas.com.parcelable

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var etName : EditText
    lateinit var cbSubscribed : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.main_name) as EditText
        cbSubscribed = findViewById(R.id.main_checkbox) as CheckBox
        findViewById(R.id.main_parcel).setOnClickListener {goToDetails()}
    }

    fun viewToModel() : User = User(etName.text.toString(),cbSubscribed.isChecked)

    fun goToDetails() {
       val intent = Intent(this,DetailActivity::class.java)
       intent.putExtra("user",viewToModel())
        startActivity(intent)
    }
}
