package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class SecondActivity : Activity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.second_activity)
    }
}