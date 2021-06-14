package com.example.BerkOdev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_daba.*

class DaBaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daba)
        if(intent.getStringExtra("Text") == null){
            Toast.makeText(getApplicationContext(),"No Data", Toast.LENGTH_LONG).show();
        }else{
            textWiew.text = intent.getStringExtra("Text")
        }
        hakkıButton.setOnClickListener { view ->
            val intent = Intent(this,HakActivity::class.java)
            startActivity(intent)
        }
    }
}