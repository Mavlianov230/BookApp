package com.example.mavlianov_hw2_m6.ui.theme.book

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BookListScreen(bookRepository: BookRepository) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("") }
    val allBooks = bookRepository.getBooks()
    val filteredBooks = bookRepository.filterBooksByCategory(selectedCategory)
    val searchedBooks = bookRepository.searchBooks(searchQuery)

    val displayedBooks = searchedBooks.takeIf { it.isNotEmpty() } ?: filteredBooks

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Поиск") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))

        BookCategoryFilter(
            selectedCategory = selectedCategory,
            onCategorySelected = { selectedCategory = it }
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(displayedBooks) { book ->
                BookItem(book = book)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun BookCategoryFilter(selectedCategory: String, onCategorySelected: (String) -> Unit) {
    val categories = listOf("Все", "Фантастика", "Ужасы", "Комедия")

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(categories) { category ->
            Button(
                onClick = { onCategorySelected(category) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedCategory == category) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            ) {
                Text(category)
            }
        }
    }
}
@Composable
@Preview
fun BookListScreenPreview() {
    BookListScreen(bookRepository = BookRepository())
}
