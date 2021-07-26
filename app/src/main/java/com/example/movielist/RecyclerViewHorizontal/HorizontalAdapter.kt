package com.example.movielist.RecyclerViewHorizontal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movielist.R
import com.example.movielist.model.ResponseModel

class HorizontalAdapter(private val responseModelList: List<ResponseModel>) :
    RecyclerView.Adapter<HorizontalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return HorizontalViewHolder(view)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        val model = responseModelList[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return responseModelList.size
    }
}