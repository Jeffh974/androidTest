package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val i = Intent(this, SecondActivity::class.java)
            startActivity(i)
        }
    }

}

