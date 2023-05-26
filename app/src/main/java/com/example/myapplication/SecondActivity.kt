package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import com.example.myapplication.databinding.SecondActivityBinding

class Counter(var c: Int = 0)

class SecondActivity : Activity() {
    private lateinit var binding: SecondActivityBinding
    private var counter = Counter()

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

        binding.button2.setOnClickListener {
            counter.c + 1
            binding.counter.text = counter.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", counter.c)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        counter = savedInstanceState.getInt("counter")
        binding.counter.text = counter.toString()
    }
}