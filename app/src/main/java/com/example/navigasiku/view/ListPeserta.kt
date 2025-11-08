package com.example.navigasiku.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigasiku.R

@Composable
fun ListPeserta(
    modifier: Modifier = Modifier,
    onBackListBtn: () -> Unit,
    onNextListBtn: () -> Unit
    /////
) {

    val cardBackgroundColor = Color(0xFFCDDC39) // Warna abu-abu muda di Card
    val primaryButtonColor = Color(0xFFE10543) // Warna Biru Tua tombol

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.list_daftar_peserta),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // ----------------------------------------------------
            // CARD PERTAMA (Duta Brahmana - Data 1)
            // ----------------------------------------------------
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = cardBackgroundColor) // WARNA BARU
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // ROW 1: Nama Lengkap vs Jenis Kelamin
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween // KUNCI KESEJAJARAN
                    ) {
                        // KOLOM 1 (Nama Lengkap)
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = stringResource(id = R.string.nama_lengkap), fontSize = 14.sp, color = Color.Red, fontWeight = FontWeight.SemiBold)
                            Text(text = stringResource(id = R.string.nama1), fontSize = 16.sp, color = Color.Blue) // Menampilkan Nama
                        }
                        // KOLOM 2 (Jenis Kelamin)
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = stringResource(id = R.string.jenis_kelamin), fontSize = 14.sp, color = Color.Red, fontWeight = FontWeight.SemiBold)
                            Text(text = stringResource(id = R.string.jk_laki), fontSize = 16.sp, color = Color.Blue
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp)) // Pemisah antar baris

                    // ROW 2: Status Kawin vs Alamat
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween // KUNCI KESEJAJARAN
                    ) {
                        // KOLOM 1 (Status Kawin)
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = stringResource(id = R.string.status_kawin), fontSize = 14.sp, color = Color.Red, fontWeight = FontWeight.SemiBold)
                            Text(text = stringResource(id = R.string.status_lajang), fontSize = 16.sp, color = Color.Blue)
                        }
                        // KOLOM 2 (Alamat)
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = stringResource(id = R.string.alamat), fontSize = 14.sp, color = Color.Red, fontWeight = FontWeight.SemiBold)
                            Text(text = stringResource(id = R.string.alamat1), fontSize = 16.sp, color = Color.Blue)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            // ----------------------------------------------------
            // CARD KEDUA (Andara Fitra Hamura - Data 2)
            // ----------------------------------------------------
            Card(
                modifier = modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = cardBackgroundColor) // WARNA BARU
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // ROW 1: Nama Lengkap & Jenis Kelamin
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween // KUNCI KESEJAJARAN
                    ) {
                        // KOLOM 1 (Nama Lengkap)
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = stringResource(id = R.string.nama_lengkap), fontSize = 14.sp, color = Color.Blue, fontWeight = FontWeight.SemiBold)
                            Text(text = stringResource(id = R.string.nama2), fontSize = 16.sp, color = Color.Red) // Menampilkan Nama
                        }
                        // KOLOM 2 (Jenis Kelamin)
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = stringResource(id = R.string.jenis_kelamin), fontSize = 14.sp, color = Color.Blue, fontWeight = FontWeight.SemiBold)
                            Text(text = stringResource(id = R.string.jk_laki), fontSize = 16.sp, color = Color.Red)
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // ROW 2: Status Kawin & Alamat
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween // KUNCI KESEJAJARAN
                    ) {
                        // KOLOM 1 (Status Kawin)
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = stringResource(id = R.string.status_kawin), fontSize = 14.sp, color = Color.Blue, fontWeight = FontWeight.SemiBold)
                            Text(text = stringResource(id = R.string.status_lajang), fontSize = 16.sp, color = Color.Red)
                        }
                        // KOLOM 2 (Alamat)
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = stringResource(id = R.string.alamat), fontSize = 14.sp, color = Color.Blue, fontWeight = FontWeight.SemiBold)
                            Text(text = stringResource(id = R.string.alamat2), fontSize = 16.sp, color = Color.Red)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // TOMBOL (Warna Tombol Diubah)
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = onBackListBtn,
                    colors = ButtonDefaults.buttonColors(containerColor = primaryButtonColor), // WARNA BARU
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f).height(48.dp)
                )