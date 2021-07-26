package com.example.movielist.RecyclerViewHorizontal

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielist.model.ResponseModel
import kotlinx.android.synthetic.main.item_layout.view.*

class HorizontalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(responseModel: ResponseModel) {
        itemView.apply {
            (Glide.with(this)
                .load(responseModel[1].show.image.original)
                .into(ivMain)
                    )
        }
    }
}