package com.criticalgnome.diffutildemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.criticalgnome.diffutildemo.R
import com.criticalgnome.diffutildemo.model.Author
import kotlinx.android.synthetic.main.main_item.view.*

class MainAdapter(var items: List<Author>): RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(holder: MainHolder, position: Int) = holder.bind(items[position])

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(author: Author) {
            with(itemView) {
                mainItemId.text = author.id.toString()
                mainItemFirstName.text = author.firstName
                mainItemLastName.text = author.lastName
                mainItemBirthdayYear.text = author.birthdayYear.toString()
            }
        }
    }
}