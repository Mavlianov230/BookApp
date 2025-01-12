
package com.example.mavlianov_hw2_m6.ui.theme.book

class BookRepository {
    private val books = listOf(
        Book("Книга:1", "Автор:1", "Описание книги:1", "Фантастика"),
        Book("Книга:2", "Автор:2", "Описание книги:2", "Драма"),
        Book("Книга:3", "Автор:3", "Описание книги:3", "Комедия"),
    )

    fun getBooks() = books

    fun filterBooksByCategory(category: String): List<Book> {
        return if (category.isEmpty()) {
            books
        } else {
            books.filter { it.category == category }
        }
    }

    fun searchBooks(query: String): List<Book> {
        return books.filter {
            it.title.contains(query, ignoreCase = true) || it.author.contains(query, ignoreCase = true)
        }
    }
}
