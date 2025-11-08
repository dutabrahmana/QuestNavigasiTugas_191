package com.example.navigasiku.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigasiku.R


// !!! GANTI INI DENGAN ID GAMBAR LATAR BELAKANG ANDA !!!
private val BACKGROUND_IMAGE_ID = R.drawable.img_2 // ASUMSI ID GAMBAR


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formulirpendaftarann(
    modifier: Modifier = Modifier,
    onBackListBtn: () -> Unit,
) {
    // --- STATE MANAGEMENT ---
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    // Variabel untuk menyimpan data hasil submit (untuk AlertDialog)
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var statusPerkawinan by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    // Daftar pilihan (Menggunakan stringResource)
    val gender = listOf(stringResource(id = R.string.jk_laki), stringResource(id = R.string.jk_perempuan))
    val status = listOf(stringResource(id = R.string.status_kawin_janda), stringResource(id = R.string.status_lajang), stringResource(id = R.string.status_kawin_duda))


    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // LAPISAN 1: BACKGROUND GAMBAR
            Image(
                painter = painterResource(id = BACKGROUND_IMAGE_ID),
                contentDescription = "Background Formulir",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )

            // Opsional: Overlay agar konten lebih mudah dibaca
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            )

            // LAPISAN 2: KONTEN FORMULIR (COLUMN UTAMA)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 2.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Judul Formulir
                Text(
                    text = stringResource(id = R.string.halaman_formulir),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White, // Teks putih agar kontras dengan background gelap
                    modifier = Modifier.padding(bottom = 16.dp, top = 16.dp)
                )

                // CARD WADAH FORMULIR
                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f) // Mengambil sisa ruang di atas tombol
                        .padding(horizontal = 16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .verticalScroll(rememberScrollState()), // Scroll untuk form panjang
                        horizontalAlignment = Alignment.Start
                    ) {
                        // 1. NAMA LENGKAP
                        Text(
                            text = stringResource(id = R.string.nama_lengkap),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        OutlinedTextField(
                            value = textNama,
                            onValueChange = { textNama = it },
                            singleLine = true,
                            placeholder = { Text("Isian Nama Lengkap") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        // 2. JENIS KELAMIN
                        Text(
                            text = stringResource(id = R.string.jenis_kelamin),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            gender.forEach { item ->
                                Row(
                                    modifier = Modifier.selectable(
                                        selected = textJK == item,
                                        onClick = { textJK = item }
                                    ),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = textJK == item,
                                        onClick = { textJK = item }
                                    )
                                    Text(item)
                                }
                            }
                        }

                        // 3. STATUS PERKAWINAN
                        Text(
                            text = stringResource(id = R.string.status_kawin),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                        )
                        Row {
                            status.forEach { item ->
                                Row(
                                    modifier = Modifier.selectable(
                                        selected = textStatus == item,
                                        onClick = { textStatus = item }
                                    ),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = textStatus == item,
                                        onClick = { textStatus = item }
                                    )
                                    Text(item)
                                }
                            }
                        }

                        // 4. ALAMAT
                        Text(
                            text = stringResource(id = R.string.alamat),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                        )
                        OutlinedTextField(
                            value = textAlamat,
                            onValueChange = { textAlamat = it },
                            singleLine = true,
                            placeholder = { Text("Alamat") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(30.dp)) // Padding bawah form

                        // Tombol (Dipindahkan ke luar Column yang bisa discroll)
                    }
                }

                // TOMBOL (DITEMPATKAN DI LUAR CARD AGAR SELALU TERLIHAT)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp, bottom = 16.dp)
                ) {
                    Button(
                        onClick = onBackListBtn,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF44336) // Abu-abu gelap untuk Kembali
                        ),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.weight(1f).height(48.dp)
                    ) {
                        Text(text = stringResource(id = R.string._back), color = Color.White, fontWeight = FontWeight.Medium)
                    }

                    Button(
                        onClick = {
                            // Simpan data dan tampilkan dialog
                            nama = textNama
                            alamat = textAlamat
                            jenisKelamin = textJK
                            statusPerkawinan = textStatus
                            showDialog = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF007BFF) // Biru terang untuk Submit
                        ),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.weight(1f).height(48.dp)
                    ) {
                        Text(text = stringResource(id = R.string.submit), color = Color.White, fontWeight = FontWeight.Medium)
                    }
                }
            }
        }

        // --- ALERT DIALOG ---
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = {
                    Text(
                        text = stringResource(id = R.string.data),
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif
                    )
                },
                text = {
                    Column {
                        // Tampilan Detail Data di Dialog
                        Row {
                            Text(
                                text = stringResource(id = R.string.nama_lengkap),
                                modifier = Modifier.width(120.dp),
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(text = ": $textNama")
                        }
                        Row {
                            Text(
                                text = stringResource(id = R.string.jenis_kelamin),
                                modifier = Modifier.width(120.dp),
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(text = ": $textJK")
