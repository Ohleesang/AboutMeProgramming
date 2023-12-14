package com.example.aboutmeprogramming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_signUp = findViewById<Button>(R.id.btn_signUp)
        val id = findViewById<EditText>(R.id.editText_id)
        val pw = findViewById<EditText>(R.id.editText_pw)


        //로그인 버튼 눌렸을때
        btn_login.setOnClickListener {
            var intent = Intent(this, HomeActivity::class.java)
            var inputId: String?
            var inputPw: String?
            inputId = id.text.toString()
            inputPw = pw.text.toString()
            if (inputId == "" || inputPw == "") {
                // 만약, 두값이 입력되지 않는다면 return
                Toast.makeText(this,"아이디/비밀번호를 확인해주세요",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            intent.putExtra("id", inputId)
            startActivity(intent) // HomeActivity 실행!
            Toast.makeText(this,"로그인 성공!",Toast.LENGTH_SHORT).show()
        }


        //회원가입 버튼 눌렸을때
        btn_signUp.setOnClickListener {
            var intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"회원가입 액티비티!",Toast.LENGTH_SHORT).show()
        }
    }
}