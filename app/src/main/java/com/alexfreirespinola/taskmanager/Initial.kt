package com.alexfreirespinola.taskmanager

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_initial.*

class Initial : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial)
        buttonLogin.setOnClickListener(this)
        buttonRegister.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            buttonLogin.id -> {
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
                finish()
            }
            buttonRegister.id -> {
                val intent = Intent(this, Register::class.java)
                startActivity(intent)
            }
        }
    }

}
