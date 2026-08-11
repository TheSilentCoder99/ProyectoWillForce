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

//Lista con los desafíos a mostrar en cada tarjeta
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
    ),
    Desafio(
        id = 11,
        nombre = "Ayuno intermitente de 16 horas",
        descripcion = """
            Realiza un ayuno de 16 horas sin ingerir alimentos (solo agua o infusiones sin azúcar). 
            Este desafío entrena la incomodidad controlada al experimentar hambre voluntaria y demuestra el principio de hormesis: 
            el estrés metabólico moderado activa mecanismos de reparación celular y mejora la sensibilidad a la insulina. 
            Observa cómo el hambre aparece y desaparece en oleadas, y cómo tu mente aprende que no es una emergencia.
        """.trimIndent(),
        fechaInicio = Instant.parse("2026-08-10T20:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-11T12:00:00Z")
    ),

    Desafio(
        id = 12,
        nombre = "7 días de escritura estoica matutina",
        descripcion = """
            Durante siete días, dedica 15 minutos cada mañana a escribir tus pensamientos desde una perspectiva de "vista desde arriba". 
            Describe tus preocupaciones del día siguiente como si las observaras desde la estratosfera, reduciendo su importancia. 
            Este ejercicio fortalece la capacidad de relativizar problemas y separar lo urgente de lo verdaderamente importante.
        """.trimIndent(),
        fechaInicio = Instant.parse("2026-08-10T06:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-17T06:00:00Z")
    ),

    Desafio(
        id = 13,
        nombre = "5 días de meditación de la impermanencia",
        descripcion = """
            Practica durante 5 días la meditación que consiste en observar cómo las sensaciones placenteras y desagradables surgen y desaparecen. 
            Este desafío combate la adaptación hedónica al entrenar la atención plena sobre la naturaleza transitoria de toda experiencia. 
            Al notar que el placer y el dolor son pasajeros, reduces la tendencia a aferrarte a lo agradable y a rechazar lo desagradable.
        """.trimIndent(),
        fechaInicio = Instant.parse("2026-08-10T07:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-15T07:00:00Z")
    ),

    Desafio(
        id = 14,
        nombre = "Dieta de gratitud de 7 días",
        descripcion = """
            Durante una semana, cada día escribe 5 cosas por las que estás agradecido, pero con una condición: 
            no puedes repetir las mismas cosas que los días anteriores. 
            Este ejercicio lucha contra la adaptación hedónica al forzarte a encontrar novedad en tu vida cotidiana, 
            entrenando tu cerebro para no dar por sentado lo que tienes.
        """.trimIndent(),
        fechaInicio = Instant.parse("2026-08-10T22:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-17T22:00:00Z")
    ),

    Desafio(
        id = 15,
        nombre = "Una semana de silencio matutino",
        descripcion = """
            Durante siete días, los primeros 30 minutos después de despertarte deben transcurrir en silencio absoluto: 
            sin música, sin podcasts, sin hablar con nadie, sin notificaciones. 
            Este desafío de incomodidad controlada te enfrenta al vacío y a tus propios pensamientos, 
            fortaleciendo tu capacidad de estar contigo mismo sin estímulos externos.
        """.trimIndent(),
        fechaInicio = Instant.parse("2026-08-10T06:30:00Z"),
        fechaObjetivo = Instant.parse("2026-08-17T06:30:00Z")
    ),

    Desafio(
        id = 16,
        nombre = "24 horas sin confort térmico",
        descripcion = """
            Durante 24 horas evita utilizar sistemas de calefacción o aire acondicionado. 
            Vístete adecuadamente pero acepta las temperaturas naturales de tu entorno. 
            Este desafío practica la incomodidad controlada y demuestra el principio de hormesis: 
            la exposición moderada a temperaturas extremas activa mecanismos de termorregulación y fortalece el sistema cardiovascular.
        """.trimIndent(),
        fechaInicio = Instant.parse("2026-08-10T08:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-11T08:00:00Z")
    ),

    Desafio(
        id = 17,
        nombre = "7 días de acción inmediata",
        descripcion = """
            Durante una semana, cuando identifiques una tarea que puedas hacer en menos de 2 minutos, hazla inmediatamente sin postergarla. 
            Este desafío entrena la fuerza de voluntad al eliminar el hábito de la procrastinación y 
            desarrollar la disciplina de actuar sin darle tiempo a la mente para generar resistencia.
        """.trimIndent(),
        fechaInicio = Instant.parse("2026-08-10T00:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-17T00:00:00Z")
    ),

    Desafio(
        id = 18,
        nombre = "5 días sin azúcar añadido",
        descripcion = """
            Durante cinco días elimina todo el azúcar añadido de tu dieta (bebidas azucaradas, dulces, postres, alimentos procesados). 
            Este desafío aplica el principio de hormesis al resetear tu sensibilidad al dulce, 
            y entrena la fuerza de voluntad al resistir los antojos que aparecerán los primeros días. 
            Observa cómo el sabor de los alimentos naturales se vuelve más intenso.
        """.trimIndent(),
        fechaInicio = Instant.parse("2026-08-10T00:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-15T00:00:00Z")
    ),

    Desafio(
        id = 19,
        nombre = "Una semana de desconexión vespertina",
        descripcion = """
            Durante siete días, desconecta todos los dispositivos electrónicos (móvil, ordenador, televisión) 
            durante las dos horas previas a acostarte. 
            Este desafío de incomodidad controlada te obliga a enfrentar el aburrimiento y la inquietud, 
            y te permite experimentar cómo la ausencia de estímulos digitales mejora la calidad del sueño y la claridad mental.
        """.trimIndent(),
        fechaInicio = Instant.parse("2026-08-10T21:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-17T21:00:00Z")
    ),

    Desafio(
        id = 20,
        nombre = "Práctica de posposición de recompensas",
        descripcion = """
            Durante una semana, cada vez que desees comprar algo no esencial o consumir un capricho, 
            espera al menos 48 horas antes de hacerlo. 
            Este desafío fortalece la fuerza de voluntad al crear un espacio entre el deseo y la acción, 
            y combate la adaptación hedónica al demostrar que la mayoría de los deseos impulsivos desaparecen por sí solos, 
            liberándote del ciclo de gratificación inmediata y posterior vacío.
        """.trimIndent(),
        fechaInicio = Instant.parse("2026-08-10T00:00:00Z"),
        fechaObjetivo = Instant.parse("2026-08-17T00:00:00Z")
    )
);
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
//                .background(Image())
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