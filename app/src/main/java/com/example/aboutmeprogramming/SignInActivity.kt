package com.example.aboutmeprogramming

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {


    private val id by lazy{ findViewById<EditText>(R.id.editText_id)}
    private val pw by lazy{ findViewById<EditText>(R.id.editText_pw)}

    //콜백 : 어떤 기능이 수행됬을때, 이 특정 시점에 수행하고 싶을때
    //결과값을 돌려받기 위한 런처 설정
    private val activityResultLanuncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if(result.resultCode == Activity.RESULT_OK){
//                val id = findViewById<EditText>(R.id.editText_id)
//                val pw = findViewById<EditText>(R.id.editText_pw)

                val resultId =result.data?.getStringExtra("id")
                val resultPw =result.data?.getStringExtra("pw")
                id.setText(resultId)
                pw.setText(resultPw)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_signUp = findViewById<Button>(R.id.btn_signUp)
//        val id = findViewById<EditText>(R.id.editText_id)
//        val pw = findViewById<EditText>(R.id.editText_pw)

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
//            startActivity(intent)
            activityResultLanuncher.launch(intent)
            Toast.makeText(this,"회원가입 액티비티!",Toast.LENGTH_SHORT).show()
        }

    }
}