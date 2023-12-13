package com.example.aboutmeprogramming

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //인텐드에서 값을 받는다.
        val strData = intent.getStringExtra("id")
        val textView = findViewById<TextView>(R.id.textView_id_homeActivity)
        textView.setText(strData)
    }
}