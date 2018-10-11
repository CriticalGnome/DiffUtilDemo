package com.criticalgnome.diffutildemo.ui.util

import androidx.recyclerview.widget.DiffUtil
import com.criticalgnome.diffutildemo.model.Author

class AuthorDiffUtilCallback(private val oldList: List<Author>, private val newList: List<Author>): DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition].id == newList[newItemPosition].id
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition] == newList[newItemPosition]
}