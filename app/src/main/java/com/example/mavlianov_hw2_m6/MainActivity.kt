package com.example.mavlianov_hw2_m6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mavlianov_hw2_m6.ui.theme.Mavlianov_Hw2_m6Theme
import com.example.mavlianov_hw2_m6.ui.theme.book.AppNavigator
import com.example.mavlianov_hw2_m6.ui.theme.book.AppScreen
import com.example.mavlianov_hw2_m6.ui.theme.book.BookRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mavlianov_Hw2_m6Theme {

                val bookRepository = BookRepository()


                AppNavigator(bookRepository = bookRepository, currentScreen = AppScreen.BookList)
            }
        }
    }
}
