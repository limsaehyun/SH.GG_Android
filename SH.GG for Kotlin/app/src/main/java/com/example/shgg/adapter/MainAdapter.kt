package com.example.shgg.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shgg.R
import com.example.shgg.data.MainData
import java.util.*
import kotlin.collections.ArrayList

class MainAdapter(private var dataSet: ArrayList<MainData>) :
        RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {

            textView = view.findViewById(R.id.textView)
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.textView.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size

}
