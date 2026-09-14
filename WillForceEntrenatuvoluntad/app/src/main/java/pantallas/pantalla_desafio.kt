package pantallas

import DataClass.Desafio
import android.media.SoundPool
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.example.willforce_entrenatuvoluntad.R
import kotlinx.coroutines.delay
import java.time.Duration
import java.time.Instant
import kotlin.time.Duration.Companion.milliseconds


//Lista con los desafíos a mostrar en cada tarjeta
@RequiresApi(Build.VERSION_CODES.O)

val listaDeDesafios = listOf(
    Desafio(
        id = 11,
        nombre = "Ayuno intermitente de 16 horas",
        descripcion = """
            Realiza un ayuno de 16 horas sin ingerir alimentos (solo agua o infusiones sin azúcar). 
            Este desafío entrena la incomodidad controlada al experimentar hambre voluntaria y demuestra el principio de hormesis: 
            el estrés metabólico moderado activa mecanismos de reparación celular y mejora la sensibilidad a la insulina. 
            Observa cómo el hambre aparece y desaparece en oleadas, y cómo tu mente aprende que no es una emergencia.
        """.trimIndent(),
        fechaInicio = null,
        fechaObjetivo = null
    ),

    Desafio(
        id = 12,
        nombre = "7 días de escritura estoica matutina",
        descripcion = """
            Durante siete días, dedica 15 minutos cada mañana a escribir tus pensamientos desde una perspectiva de "vista desde arriba". 
            Describe tus preocupaciones del día siguiente como si las observaras desde la estratosfera, reduciendo su importancia. 
            Este ejercicio fortalece la capacidad de relativizar problemas y separar lo urgente de lo verdaderamente importante.
        """.trimIndent(),
        fechaInicio = null,
        fechaObjetivo = null
    ),

    Desafio(
        id = 13,
        nombre = "5 días de meditación de la impermanencia",
        descripcion = """
            Practica durante 5 días la meditación que consiste en observar cómo las sensaciones placenteras y desagradables surgen y desaparecen. 
            Este desafío combate la adaptación hedónica al entrenar la atención plena sobre la naturaleza transitoria de toda experiencia. 
            Al notar que el placer y el dolor son pasajeros, reduces la tendencia a aferrarte a lo agradable y a rechazar lo desagradable.
        """.trimIndent(),
        fechaInicio = null,
        fechaObjetivo = null
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
        fechaInicio = null,
        fechaObjetivo = null
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
        fechaInicio = null,
        fechaObjetivo = null
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
        fechaInicio = null,
        fechaObjetivo = null
    ),

    Desafio(
        id = 17,
        nombre = "7 días de acción inmediata",
        descripcion = """
            Durante una semana, cuando identifiques una tarea que puedas hacer en menos de 2 minutos, hazla inmediatamente sin postergarla. 
            Este desafío entrena la fuerza de voluntad al eliminar el hábito de la procrastinación y 
            desarrollar la disciplina de actuar sin darle tiempo a la mente para generar resistencia.
        """.trimIndent(),
        fechaInicio = null,
        fechaObjetivo = null
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
        fechaInicio = null,
        fechaObjetivo = null
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
        fechaInicio = null,
        fechaObjetivo = null
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
        fechaInicio = null,
        fechaObjetivo = null
    )
)

@RequiresApi(Build.VERSION_CODES.S)
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

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AbrirCalendario(
    FechaSeleccionada: (Instant) -> Unit,
    CerrarCalendario: () -> Unit
) {
    val datePickerState = rememberDatePickerState()
    DatePickerDialog(
        onDismissRequest = CerrarCalendario,

//        Qué ocurre al pulsar el botón confirmar
        confirmButton = {
            TextButton(
                onClick = {
                    val fechaMillis = datePickerState.selectedDateMillis

                    if (fechaMillis != null) {
                        val fecha = Instant.ofEpochMilli(fechaMillis)
                        FechaSeleccionada(fecha)
                    }

                    CerrarCalendario()
                }
            ) {
                Text("Comenzar desafío")
            }
        },

//        Qué ocurre al pulsar el botón cerrar
        dismissButton = {
            TextButton(
                onClick = CerrarCalendario
            ) {
                Text("Cancelar")
            }
        }
    ) {
        DatePicker(
            state = datePickerState
        )
    }
}


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun CuentaAtras(
    fechaInicio: Instant,
    fechaObjetivo: Instant
) {
    var tiempoRestante by remember {
        mutableStateOf(
            Duration.between(
                Instant.now(),
                fechaObjetivo
            )
        )
    }

    var mostrarBoton by remember {
        mutableStateOf(
            false
        )
    }

    LaunchedEffect(fechaObjetivo) {
        while (true) {
            tiempoRestante = Duration.between(
                Instant.now(),
                fechaObjetivo
            )
            delay(2000.milliseconds)
        }
    }

//    ESTILIZACIÓN DE LA CUENTA ATRÁS
    if (tiempoRestante.isNegative || tiempoRestante.isZero) {

        val context = LocalContext.current
        val soundPool = remember {
            SoundPool.Builder()
                .setMaxStreams(1)
                .build()
        }
        val sonidoSuccess = remember {
            soundPool.load(context, R.raw.exito ,1)
        }

        LaunchedEffect(Unit) {
            soundPool.play(sonidoSuccess, 1f, 1f, 0, 0, 1f)
        }

        Text(
            text = "¡Desafío completado! \uD83C\uDF89",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1B5E20),
            textAlign = TextAlign.Center,

        )


    } else {
        Text(
            text = "${tiempoRestante.toDays()} días " +
                    "${tiempoRestante.toHoursPart()} horas " +
                    "${tiempoRestante.toMinutesPart()} minutos " +
                    "${tiempoRestante.toSecondsPart()} segundos",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            modifier = Modifier.padding(top = 8.dp),
        )
    }
}

@Composable
fun MostrarDialogo(
    onConfirmar: () -> Unit,
    onCancelar: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onCancelar,
        title = { Text("Confirmar") },
        text = { Text("¿Deseas detener este desafío?") },
        confirmButton = {
            TextButton(onClick = onConfirmar) {
                Text("Aceptar")
            }
        },
        dismissButton = {
            TextButton(onClick = onCancelar) {
                Text("Cancelar")
            }
        }
    )
}


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun TarjetaDesafio(desafio: Desafio, modifier: Modifier = Modifier) {

//    VARIABLES DE ESTADO MUTABLES. SU ESTADO ES RECORDADO POR EL PROGRAMA ENTRE CADA VARIACIÓN DE COMPOSE
    var expanded by remember { mutableStateOf(false) }
    var mostrarCalendario by remember { mutableStateOf(false) }
    var fechaInicio by remember { mutableStateOf<Instant?>(null) }
    var fechaObjetivo by remember { mutableStateOf<Instant?>(null) }
    var mostrarDialogo by remember { mutableStateOf(false) }   // ← nueva

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFE8F5E9))
            .clickable { expanded = !expanded }
            .padding(16.dp)
    ) {
        Text(
            text = desafio.nombre,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1B5E20)
        )

        if (expanded) {
            Text(
                text = desafio.descripcion,
                fontSize = 14.sp,
                color = Color(0xFF33691E),
                modifier = Modifier.padding(top = 8.dp)
            )

//            SI LA FECHA DE INICIO ES NULA, SE DA LA OPCIÓN DE INICIAR EL DESAFÍO
            if (fechaInicio == null) {
                // --- Estado: no iniciado ---
                Button(
//                    AL PULSAR EL BOTÓN, SE MUESTRA EL CALENDARIO DESDE EL CUAL SE TOMA LA FECHA CON LA QUE SE CONSTRUYE LA CUENTA ATRÁS DEL DESAFÍO
                    onClick = { mostrarCalendario = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1B5E20),
                        contentColor = Color.White
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Comenzar desafío"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Comenzar desafío", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }

//                SI SE MUESTRA EL CALENDARIO, SE LLAMA A LA FUNCIÓN ABRIR CALENDARIO. ESTA FUNCIÓN RECIBE COMO PARÁMETRO LA MISMA FECHA QUE SE ELIGE DESDE EL CALENDARIO.
                if (mostrarCalendario) {
                    AbrirCalendario(
                        FechaSeleccionada = { fecha ->
                            fechaInicio = Instant.now()
                            fechaObjetivo = fecha
                        },
                        CerrarCalendario = { mostrarCalendario = false }
                    )
                }

            } else {
                // --- Estado: desafío iniciado ---
//                SE TOMA LA FECHA INICIO (SIEMPRE LA FECHA ACTUAL) Y EL VALOR DE FECHA OBJETIVO (LA FECHA ELEGIDA Y GUARDADA DESDE EL CALENDARIO). ESTOS DATOS SE TRATAN COMO SI NO PUDIERAN SER NULOS.
                val context = LocalContext.current

                val soundPool = remember {
                    SoundPool.Builder()
                        .setMaxStreams(1)
                        .build()
                }

                val sonidoFallo = remember {
                    soundPool.load(context, R.raw.error ,1)
                }

                CuentaAtras(
                    fechaInicio = fechaInicio!!,
                    fechaObjetivo = fechaObjetivo!!
                )
//                SI SE PULSA EL BOTÓN DE INICIAR DESAFÍO, SE ABRE LA FUNCIÓN DEL DIÁLOGO DE CONFIRMACIÓN
                Button(
                    onClick = {
                        mostrarDialogo = true
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Detener desafío"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Detener desafío", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }

//                SI EL RESULTADO DE LA CONFIRMACIÓN ES POSITIVO (DETENER EL DESAFÍO) SE ANULA LA CUENTA ATRÁS Y SE CIERRA EL DIÁLOGO
                if (mostrarDialogo) {
                    MostrarDialogo(
                        onConfirmar = {
                            fechaInicio = null
                            fechaObjetivo = null
                            mostrarDialogo = false

                            soundPool.play(sonidoFallo, 1f, 1f, 0, 0, 1f)

                        },
                        onCancelar = {
                            mostrarDialogo = false
                        })
            }
        }
    }
}
}