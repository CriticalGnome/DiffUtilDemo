package com.criticalgnome.diffutildemo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.criticalgnome.diffutildemo.R
import com.criticalgnome.diffutildemo.model.Author
import com.criticalgnome.diffutildemo.ui.adapter.MainAdapter
import com.criticalgnome.diffutildemo.ui.util.AuthorDiffUtilCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val author1 = Author(1L, "Александр", "Пушкин", 1799)
        val author2 = Author(2L, "Михаил", "Лермонтов", 1814)
        val author3 = Author(3L, "Александр", "Блок", 1880)
        val author4 = Author(4L, "Николай", "Некрасов", 1821)
        val author5 = Author(5L, "Фёдор", "Тютчев", 1803)
        val author6 = Author(6L, "Сергей", "Есенин", 1895)
        val author7 = Author(7L, "Владимир", "Маяковский", 1893)

        val mainAdapter = MainAdapter(listOf(author1, author2, author3, author4, author5, author6, author7))
        mainRecycler.adapter = mainAdapter

        buttonUpdate.setOnClickListener {
            val newItems = listOf(
                    author1,
                    author2.copy(firstName = author2.firstName.toUpperCase(), lastName = author2.lastName.toUpperCase()),
                    Author(8L, "Самуил", "Маршак", 1887),
                    author3,
                    author4,
                    author5,
                    author7
            )
            val authorDiffUtilCallback = AuthorDiffUtilCallback(mainAdapter.items, newItems)
            val authorDiffResult = DiffUtil.calculateDiff(authorDiffUtilCallback)
            mainAdapter.items = newItems
            authorDiffResult.dispatchUpdatesTo(mainAdapter)
        }
    }
}
