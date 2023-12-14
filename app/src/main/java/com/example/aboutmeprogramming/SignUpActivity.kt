package com.example.aboutmeprogramming

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btn_signUp = findViewById<Button>(R.id.btn_signUp)

        val name = findViewById<EditText>(R.id.editText_name)
        val id = findViewById<EditText>(R.id.editText_id)
        val pw = findViewById<EditText>(R.id.editText_pw)

        //회원가입 버튼을 눌렸을때
        btn_signUp.setOnClickListener {

            var inputName: String?
            var inputId: String?
            var inputPw: String?

            inputName = name.text.toString()
            inputId = id.text.toString()
            inputPw = pw.text.toString()

            val isEmpty = (inputName == "" || inputId == "" || inputPw == "")

            if (isEmpty) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            //종료!
            val result = Intent()
            result.putExtra("id",inputId)
            result.putExtra("pw",inputPw)
            setResult(Activity.RESULT_OK,result)

            Toast.makeText(this, "회원가입 완료!", Toast.LENGTH_SHORT).show()

            finish()
        }
    }
}