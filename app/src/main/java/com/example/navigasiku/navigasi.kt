package com.example.navigasiku

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasiku.view.Formulirpendaftarann
import com.example.navigasiku.view.Halaman1
import com.example.navigasiku.view.ListPeserta

// Enum untuk mendefinisikan semua route
enum class Navigasi {
    home,
    list,
    form
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.home.name,
            modifier = Modifier.padding(innerPadding)
        ) {


