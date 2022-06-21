package com.example.customseekbar

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.customseekbar.models.NumberData
import com.zhouyou.view.seekbar.SignSeekBar
import kotlinx.android.synthetic.main.list_item.view.*
import java.util.ArrayList

class RecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<NumberData> = ArrayList()
    override fun getItemViewType(position: Int): Int = position

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return NumberViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NumberViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(numList: List<NumberData>) {
        items = numList
        Log.d("list0", items.toString())
    }

    class NumberViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val numDisplay: TextView = itemView.text
        private val seekShow = itemView.seek_bar

        fun bind(numData: NumberData) {
            numDisplay.text = (numData.number.toString())
            seekShow.setProgress(numData.seekBar!!.toFloat())


        seekShow.setOnProgressChangedListener(object : SignSeekBar.OnProgressChangedListener {
            override fun onProgressChanged(signSeekBar: SignSeekBar,progress: Int,progressFloat: Float, fromUser: Boolean) {
                val newNumber = seekShow.progress
                numDisplay.text = newNumber.toString()
                numData.number = newNumber
                val value = seekShow?.progress
                if(value != null){
                    numData.seekBar = value
                }
            }

            override fun getProgressOnActionUp(signSeekBar: SignSeekBar,progress: Int,progressFloat: Float) {

            }

            override fun getProgressOnFinally(signSeekBar: SignSeekBar,progress: Int,progressFloat: Float,fromUser: Boolean) {
            }
        })
        }
    }


}