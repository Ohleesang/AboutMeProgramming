package com.example.aboutmeprogramming

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btn_exit = findViewById<Button>(R.id.btn_exit)

        //인텐드에서 값을 받는다.
        val strData = intent.getStringExtra("id")
        val idTextView = findViewById<TextView>(R.id.textView_id)

        //받은 값을 입력
        idTextView.setText(idTextView.text.toString() + " ${strData}")

        //버튼 기능
        btn_exit.setOnClickListener {
            finish()
        }

        //이름 나이 MBTI 입력하기
        setTextTextView(R.id.textView_name, "이상오")
        setTextTextView(R.id.textView_age, "30")
        setTextTextView(R.id.textView_mbti, "INFP")

    }

    //TextView 의 문자열 값을 추가 하기
    fun setTextTextView(resource: Int, str: String) {
        val textView = findViewById<TextView>(resource)
        textView.setText(textView.text.toString() + " ${str}")
    }
}