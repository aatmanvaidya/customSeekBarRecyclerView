package com.example.customseekbar


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customseekbar.models.NumberData
import com.zhouyou.view.seekbar.SignSeekBar
import com.zhouyou.view.seekbar.SignSeekBar.OnProgressChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import java.security.AccessController.getContext
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var numAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()
    }

    private fun createDataSet(): ArrayList<NumberData> {
        val list = ArrayList<NumberData>()
        for (i in 1..100) {
            list.add(NumberData(i,i,i))
        }
        Log.d("list_for_loop_data", list.toString())
        return list
    }

    private fun addDataSet() {
        val data = createDataSet()
        Log.d("data_watch", data.toString())
        numAdapter.submitList(data)
    }

    private fun initRecyclerView() {
        recycler_view.apply {
            recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
            numAdapter = RecyclerAdapter()
            recycler_view.adapter = numAdapter
        }
    }
}