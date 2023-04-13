package com.gaurneev.samachaar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import retrofit2.Response

class spalsh_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh_screen)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed(Runnable{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },3000)
    }
}