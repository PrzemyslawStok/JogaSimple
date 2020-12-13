package com.zpi.jogasimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainImageView.setOnClickListener{
            Toast.makeText(this,"Kliknięto w kwiat lotosu...",Toast.LENGTH_SHORT).show()
        }
    }
}