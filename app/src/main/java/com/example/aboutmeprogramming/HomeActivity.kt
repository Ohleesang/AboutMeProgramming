package com.example.aboutmeprogramming

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btn_exit = findViewById<Button>(R.id.btn_exit)

        randImageView()
        //버튼 기능
        btn_exit.setOnClickListener {
            finish()
        }

        //id의 경우는 인텐드에서 값을 받는다.
        val strData = intent.getStringExtra("id")
        setTextTextView(R.id.textView_id,strData.toString())
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
    //ImageView 랜덤으로 지정하기
    fun randImageView(){
        val randInt = Random.nextInt(5) //랜덤으로 0~4까지 값주기
        val imageView = findViewById<ImageView>(R.id.imageView)
        when(randInt){
            0 -> imageView.setImageResource(R.drawable.duck_3)
            1 -> imageView.setImageResource(R.drawable.duck_4)
            2 -> imageView.setImageResource(R.drawable.duck_5)
            3 -> imageView.setImageResource(R.drawable.duck_6)
            4 -> imageView.setImageResource(R.drawable.duck_7)
        }
    }
}