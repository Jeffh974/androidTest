package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.myapplication.databinding.SecondActivityBinding

class SecondActivity : Activity() {
    private lateinit var binding: SecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = this.intent.getIntExtra("position", -1)
        check(position >= 0) { "Activity blabla" }
        binding.textView.text = data[position].content

        binding.button2.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}