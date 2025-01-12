package com.example.mavlianov_hw2_m6.ui.theme.book

import androidx.compose.runtime.Composable

@Composable
fun AppNavigator(bookRepository: BookRepository, currentScreen: AppScreen) {
    when (currentScreen) {
        is AppScreen.BookList -> {
            BookListScreen(bookRepository = bookRepository)
        }
        is AppScreen.BookDetail -> {
            val book = bookRepository.getBooks()[currentScreen.bookId]
            BookDetailScreen(book = book)
        }
    }
}


