
package com.sena.actividad_2.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BarraNavegacion(
    seleccion: String = "Inicio",
    alSeleccionar: (String) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 12.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OpcionNavegacion("⌂", "Inicio", seleccion, alSeleccionar)
        OpcionNavegacion("⌕", "Explorar", seleccion, alSeleccionar)
        OpcionNavegacion("♥", "Favoritos", seleccion, alSeleccionar)
    }
}

@Composable
private fun OpcionNavegacion(
    icono: String,
    nombre: String,
    seleccion: String,
    alSeleccionar: (String) -> Unit
) {
    val activa = seleccion == nombre
    val color = if (activa) Color(0xFF5146D8) else Color.Gray

    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        androidx.compose.foundation.clickable
        Text(
            text = icono,
            color = color,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        Text(
            text = nombre,
            color = color,
            fontSize = 12.sp,
            fontWeight = if (activa) FontWeight.Bold else FontWeight.Normal,
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}
