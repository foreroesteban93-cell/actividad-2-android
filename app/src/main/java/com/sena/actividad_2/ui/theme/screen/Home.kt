
package com.sena.actividad_2.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.actividad_2.R
import com.sena.actividad_2.ui.composable.BarraNavegacion

@Composable
fun Home(modifier: Modifier = Modifier) {
    var seleccion by remember { mutableStateOf("Inicio") }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFFF7F8FC)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF5146D8))
                    .padding(horizontal = 20.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Descubre",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Nuevos destinos, nuevas historias",
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 13.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE9DFFF)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("👤", fontSize = 25.sp)
                }
            }

            Box(modifier = Modifier.weight(1f)) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(12.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .clip(RoundedCornerShape(18.dp))
                        ) {
                            Image(
                                painter = painterResource(R.drawable.paisaje),
                                contentDescription = "Paisaje de montaña",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )

                            Column(
                                modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .fillMaxWidth()
                                    .background(Color(0x99000000))
                                    .padding(14.dp)
                            ) {
                                Text(
                                    "Explora",
                                    color = Color.White,
                                    fontSize = 23.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    "Lugares increíbles\ncerca de ti",
                                    color = Color.White,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }

                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Categoria("⛰️", "Montaña", Color(0xFFE9DFFF))
                            Categoria("🌲", "Bosque", Color(0xFFDDF5E1))
                            Categoria("🌴", "Playa", Color(0xFFDDF1FF))
                            Categoria("🏛️", "Ciudad", Color(0xFFFFE8D0))
                            Categoria("♥", "Favoritos", Color(0xFFFFDFEA))
                        }
                    }

                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "Destinos populares",
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                "Ver todos",
                                color = Color(0xFF5146D8),
                                fontSize = 13.sp
                            )
                        }
                    }

                    item {
                        Destino(
                            R.drawable.laguna_azul,
                            "Laguna Azul",
                            "Naturaleza",
                            "4.8",
                            "Un paraíso natural rodeado\nde montañas."
                        )
                    }

                    item {
                        Destino(
                            R.drawable.playa_sol,
                            "Playa del Sol",
                            "Playa",
                            "4.6",
                            "Aguas cristalinas y arena blanca."
                        )
                    }

                    item {
                        Destino(
                            R.drawable.centro_historico,
                            "Centro Histórico",
                            "Cultura",
                            "4.7",
                            "Historia y arquitectura\nen un solo lugar."
                        )
                    }
                }
            }

            BarraNavegacion(
                seleccion = seleccion,
                alSeleccionar = { seleccion = it }
            )
        }
    }
}

@Composable
fun Categoria(emoji: String, nombre: String, color: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(62.dp)
    ) {
        Box(
            modifier = Modifier
                .size(46.dp)
                .clip(CircleShape)
                .background(color),
            contentAlignment = Alignment.Center
        ) {
            Text(text = emoji, fontSize = 22.sp)
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = nombre, fontSize = 10.sp, maxLines = 1)
    }
}

@Composable
fun Destino(
    imagen: Int,
    nombre: String,
    categoria: String,
    puntuacion: String,
    descripcion: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(imagen),
            contentDescription = nombre,
            modifier = Modifier
                .size(width = 105.dp, height = 100.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                nombre,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xFF25234A)
            )
            Text(
                categoria,
                fontSize = 12.sp,
                color = Color(0xFF5146D8)
            )
            Text(
                "⭐ $puntuacion",
                fontSize = 12.sp,
                color = Color.DarkGray
            )
            Text(
                descripcion,
                fontSize = 11.sp,
                color = Color.Gray,
                lineHeight = 15.sp
            )
        }

        Text(
            "›",
            fontSize = 28.sp,
            color = Color(0xFF5146D8)
        )
    }
}
