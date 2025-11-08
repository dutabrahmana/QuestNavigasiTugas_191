package com.example.navigasiku.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigasiku.R


private val BACKGROUND_DRAWABLE_ID = R.drawable.img_1

@Composable
fun Halaman1(
    modifier: Modifier = Modifier,
    onMasukClick: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center // Memastikan konten utama (Column) ada di tengah
    ) {
        // --- LAPISAN 1: BACKGROUND GAMBAR ---
        Image(
            painter = painterResource(id = BACKGROUND_DRAWABLE_ID),
            contentDescription = "Background",
            contentScale = ContentScale.Crop, // Memastikan gambar mengisi seluruh Box
            modifier = Modifier.matchParentSize() // Mengisi ukuran Box utama
        )

        // Opsional: Overlay gelap agar teks mudah dibaca
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Black.copy(alpha = 0.2f))
        )

        // --- LAPISAN 2: KONTEN UTAMA ---
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Gambar logo di atas
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Logo App",
                modifier = Modifier
                    .size(250.dp)
                    .padding(bottom = 16.dp)
            )

            // Card berisi info user
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f))
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    // Pastikan konten di dalam Card juga rata tengah
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Halo Sobat Palembang!",
                        fontSize = 24.sp, // Ukuran font diperbesar
                        fontWeight = FontWeight.ExtraBold, // Bobot font dipertebal
                        fontFamily = FontFamily.Serif, // Ganti Font Family
                        color = Color(0xFFB97A1E)
                    )

                    Spacer(modifier = Modifier.height(8.dp)) // Spacer tambahan

                    Text(
                        text = "SRIWIJAYA FC",
                        fontSize = 20.sp,
                        color = Color.Black, // Warna lebih gelap
                        textAlign = TextAlign.Center, // Tambahkan rata tengah
                        modifier = Modifier.padding(horizontal = 4.dp) // Tambahkan padding horizontal agar tidak terlalu lebar
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "SELAMAT BERGABUNG Laskar Wong Kito",
                        fontSize = 16.sp,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center,
                        color = Color(0xFFFF9800)
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Tombol masuk
            Button(
                onClick = onMasukClick,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF020202))
            ) {
                Text(
                    text = stringResource(id = R.string.masuk),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
    }
}