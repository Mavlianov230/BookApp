package com.example.mavlianov_hw2_m6.ui.theme.book

sealed class AppScreen {
    object BookList : AppScreen()
    data class BookDetail(val bookId: Int) : AppScreen()
}
