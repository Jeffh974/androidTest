package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ListEntryBinding

class DataAdapter : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    class DataViewHolder(val bindings: ListEntryBinding) : RecyclerView.ViewHolder(bindings.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val bindings = ListEntryBinding.inflate(inflater, parent, false)
        return DataViewHolder(bindings)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val str: String = data[position].title
        holder.bindings.itemText.text = str

        holder.bindings.root.setOnClickListener {
            val intent = Intent(holder.bindings.root.context, SecondActivity::class.java)
            intent.putExtra("position", position)
            holder.bindings.root.context.startActivity(intent)
        }
    }
}

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = DataAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.button.setOnClickListener {
            val i = Intent(this, SecondActivity::class.java)
            startActivity(i)
        }
    }

}

