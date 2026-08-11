package pantallas

import Desafio
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.text.font.FontWeight
import java.time.Instant
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaDesafios(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Desafíos") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                }
            )
        },
        modifier = modifier
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(listaDeDesafios) { desafio ->
                TarjetaDesafio(desafio = desafio)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
val listaDeDesafios = listOf(
    Desafio(
        id = 1,
        nombre = "24 horas sin redes sociales",
        descripcion = "Pasa 24 horas sin utilizar redes sociales. Cuando aparezca el impulso de abrirlas, observa el impulso sin actuar sobre él.",
        fechaInicio = Instant.parse("2026-08-10T00:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-11T00:00:00Z")
    ),

    Desafio(
        id = 2,
        nombre = "Una semana sin comida basura",
        descripcion = "Durante siete días evita la comida basura y los alimentos que consumes principalmente por impulso o deseo momentáneo.",
        fechaInicio = Instant.parse("2026-08-10T00:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-17T00:00:00Z")
    ),

    Desafio(
        id = 3,
        nombre = "Duchas frías durante 7 días",
        descripcion = "Durante siete días termina cada ducha con agua fría durante al menos 60 segundos. El objetivo es aprender a tolerar voluntariamente una incomodidad.",
        fechaInicio = Instant.parse("2026-08-10T00:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-17T00:00:00Z")
    ),

    Desafio(
        id = 4,
        nombre = "Una semana sin entretenimiento digital",
        descripcion = "Durante siete días evita vídeos, series, videojuegos y otras formas de entretenimiento digital durante tu tiempo libre.",
        fechaInicio = Instant.parse("2026-08-10T00:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-17T00:00:00Z")
    ),

    Desafio(
        id = 5,
        nombre = "Levantarse sin posponer la alarma",
        descripcion = "Durante siete días, cuando suene la alarma, levántate inmediatamente sin utilizar el botón de posponer.",
        fechaInicio = Instant.parse("2026-08-10T00:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-17T00:00:00Z")
    ),

    Desafio(
        id = 6,
        nombre = "Caminar sin distracciones",
        descripcion = "Durante siete días realiza una caminata diaria sin música, podcasts, vídeos ni otras formas de entretenimiento.",
        fechaInicio = Instant.parse("2026-08-10T00:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-17T00:00:00Z")
    ),

    Desafio(
        id = 7,
        nombre = "Una semana sin quejas",
        descripcion = "Durante siete días evita quejarte voluntariamente. Cuando aparezca una queja, intenta transformarla en una acción o acepta la situación.",
        fechaInicio = Instant.parse("2026-08-10T00:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-17T00:00:00Z")
    ),

    Desafio(
        id = 8,
        nombre = "Retrasar los impulsos",
        descripcion = "Durante siete días, cada vez que sientas un impulso innecesario de mirar el móvil, comer o distraerte, espera diez minutos antes de decidir.",
        fechaInicio = Instant.parse("2026-08-10T00:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-17T00:00:00Z")
    ),

    Desafio(
        id = 9,
        nombre = "Hacer primero lo incómodo",
        descripcion = "Durante siete días comienza cada jornada realizando durante al menos 20 minutos una tarea que normalmente tenderías a posponer.",
        fechaInicio = Instant.parse("2026-08-10T00:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-17T00:00:00Z")
    ),

    Desafio(
        id = 10,
        nombre = "Un día de austeridad",
        descripcion = "Durante 24 horas evita deliberadamente algunos lujos y comodidades que das por sentados para comprobar que puedes estar bien con menos.",
        fechaInicio = Instant.parse("2026-08-10T00:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-11T00:00:00Z")
    )
);

@Composable
fun TarjetaDesafio(desafio: Desafio, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFE8F5E9))
            .clickable{
                expanded = !expanded
            }
            .padding(16.dp)
    ) {
        Text(
            text = desafio.nombre,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1B5E20)
        )
        if(expanded){
            Text(
                text = desafio.descripcion,
                fontSize = 14.sp,
                color = Color(0xFF33691E),
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}