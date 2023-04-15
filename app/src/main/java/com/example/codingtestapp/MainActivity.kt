package com.example.codingtestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codingtestapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.OnItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerViewAdapter
    private val arrmodel: Array<String> =
        arrayOf<String>("P0040", "P0041", "P0042")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.modelRecyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter = RecyclerViewAdapter(this, arrmodel,this)
        binding.modelRecyclerview.adapter = adapter




//        Given an array of integers, calculate the pivot index of this array.
//        The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
//        If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
//        Return the leftmost pivot index. If no such index exists, return -1.


    }

    override fun updateBackground(position: Int) {
        adapter.changeUI(position)
    }
}