package com.example.willforce_entrenatuvoluntad

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.willforce_entrenatuvoluntad.ui.theme.WillForceEntrenaTuVoluntadTheme
import pantallas.PantallaConceptosClave
import pantallas.PantallaDesafios

//lista con las frases motivadoras a mostrar en la pantalla de inicio
val frasesAleatorias = listOf(
    "El único modo de hacer un gran trabajo es amar lo que haces.",
    "No cuentes los días, haz que los días cuenten.",
    "El éxito no es definitivo, el fracaso no es fatal: lo que cuenta es el coraje para continuar.",
    "Cree que puedes y ya estás a medio camino.",
    "La mejor manera de predecir el futuro es crearlo.",
    "No esperes por el momento adecuado, crea el momento.",
    "El fracaso es la oportunidad de comenzar de nuevo con más inteligencia.",
    "La disciplina es el puente entre las metas y los logros.",
    "Cada día es una nueva oportunidad para cambiar tu vida.",
    "El único límite para nuestros logros de mañana son nuestras dudas de hoy.",
    "La excelencia no es un acto, es un hábito.",
    "El viaje de mil millas comienza con un simple paso.",
    "No te detengas cuando estés cansado, detente cuando hayas terminado.",
    "El éxito es la suma de pequeños esfuerzos repetidos día tras día.",
    "La vida no se trata de encontrarte a ti mismo, se trata de crearte a ti mismo.",
    "Si puedes soñarlo, puedes hacerlo.",
    "La perseverancia no es una carrera larga, sino muchas carreras cortas una tras otra.",
    "Tu tiempo es limitado, no lo malgastes viviendo la vida de otro.",
    "El coraje no es la ausencia de miedo, sino la decisión de que algo es más importante que el miedo.",
    "Lo que obtienes al alcanzar tus metas no es tan importante como lo que te conviertes al lograrlas.",
    "La acción es la clave fundamental de todo éxito.",
    "No importa lo lento que vayas, mientras no te detengas.",
    "El éxito no es para los que nunca fallan, sino para los que nunca se rinden.",
    "Haz lo que puedas, con lo que tengas, donde estés.",
    "La única forma de hacer algo excelente es amar lo que haces.",
    "El mañana no está prometido, actúa hoy.",
    "Cada pequeño paso te acerca a tu meta.",
    "La motivación te impulsa, el hábito te mantiene.",
    "No tengas miedo de fallar, ten miedo de no intentarlo.",
    "El mayor riesgo es no correr ningún riesgo.",
    "La vida empieza al final de tu zona de confort.",
    "Eres más fuerte de lo que crees y más capaz de lo que imaginas.",
    "El éxito es ir de fracaso en fracaso sin perder el entusiasmo.",
    "Todo lo que siempre has querido está al otro lado del miedo.",
    "La diferencia entre lo imposible y lo posible está en la determinación de una persona.",
    "No puedes tener un mañana mejor si sigues pensando en el ayer.",
    "La voluntad es lo que te hace empezar, el hábito lo que te hace continuar.",
    "La vida es 10% lo que te sucede y 90% cómo reaccionas ante ello.",
    "Tu único competidor eres tú mismo de ayer.",
    "El momento perfecto no existe, el momento es ahora.",
    "Crece hasta donde tus sueños te lleven.",
    "No te rindas, el principio siempre es lo más difícil.",
    "El éxito es la capacidad de ir de fracaso en fracaso sin desanimarse.",
    "Lo que piensas, te conviertes en ello.",
    "La verdadera motivación viene del interior.",
    "Cada día es una página en blanco, escribe una buena historia.",
    "El trabajo duro supera al talento cuando el talento no trabaja duro.",
    "No temas a la lentitud, teme a la inactividad.",
    "El éxito se construye desde adentro hacia afuera.",
    "El único fracaso es no intentarlo.",
    "Los sueños no funcionan a menos que tú trabajes.",
    "El cambio es la ley de la vida, y los que miran solo al pasado se pierden el futuro.",
    "La vida es demasiado corta para vivirla con mediocridad.",
    "El éxito no es casualidad, es elección.",
    "La pasión es la energía que impulsa el éxito.",
    "Hoy es el primer día del resto de tu vida.",
    "No puedes cambiar el viento, pero puedes ajustar las velas.",
    "El optimismo es la fe que conduce al logro.",
    "La constancia vence lo que la dicha no alcanza.",
    "El secreto del éxito es comenzar.",
    "La única persona que te impide lograr tus metas eres tú.",
    "Si no te gusta algo, cámbialo. Si no puedes cambiarlo, cambia tu actitud.",
    "La fuerza no proviene de la capacidad física, sino de la voluntad inquebrantable.",
    "Cada día es una batalla que decides ganar o perder.",
    "La grandeza no está en no caer, sino en levantarse cada vez que caes.",
    "El éxito es la realización progresiva de un sueño.",
    "La mejor forma de empezar es dejar de hablar y empezar a hacer.",
    "La felicidad no es algo hecho, viene de tus propias acciones.",
    "La vida es como andar en bicicleta, para mantener el equilibrio debes seguir adelante.",
    "El único fracaso real es el que no te enseña nada.",
    "La determinación te llevará a donde el talento no puede.",
    "El presente es el único momento que realmente tienes.",
    "Deja de tener miedo a lo que podría salir mal y empieza a emocionarte por lo que podría salir bien.",
    "No te compares con los demás, compárate con quien eras ayer.",
    "La valentía no es la ausencia de miedo, es actuar a pesar de él.",
    "Cada error es una lección disfrazada.",
    "El éxito es un viaje, no un destino.",
    "La autodisciplina es el poder que convierte los sueños en realidad.",
    "Si siempre haces lo que siempre has hecho, siempre obtendrás lo que siempre has obtenido.",
    "La clave no es priorizar lo que está en tu agenda, sino agenda lo que es prioritario.",
    "No esperes resultados diferentes si sigues haciendo lo mismo.",
    "El camino hacia el éxito está lleno de fracasos, pero solo los que persisten llegan al final.",
    "La vida no es esperar a que pase la tormenta, es aprender a bailar bajo la lluvia.",
    "El éxito es para aquellos que están dispuestos a hacer lo que otros no están.",
    "No importa cuántas veces caigas, importa cuántas veces te levantas.",
    "La resistencia es la clave de la victoria.",
    "Tus límites solo existen en tu mente.",
    "El éxito se construye con los ladrillos de los fracasos.",
    "La única forma de encontrar tus límites es sobrepasarlos.",
    "No dejes que tus miedos ocupen el lugar de tus sueños.",
    "La disciplina es el alma del éxito.",
    "Pequeñas acciones cada día crean grandes resultados.",
    "El futuro pertenece a quienes creen en la belleza de sus sueños.",
    "Si puedes imaginar el éxito, puedes alcanzarlo.",
    "La perseverancia convierte lo imposible en posible.",
    "La vida premia a los que se atreven.",
    "No hay atajos para ningún lugar que valga la pena.",
    "Cada amanecer es una nueva oportunidad para empezar de nuevo.",
    "La confianza en ti mismo es el primer secreto del éxito.",
    "El único momento en que el fracaso es definitivo es cuando dejas de intentarlo.",
    "No dejes para mañana lo que puedes hacer hoy.",
    "La excelencia no es un destino, es un viaje continuo.",
    "Cree en ti mismo y todo lo demás será más fácil."
)
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()  // debe ir ANTES de super.onCreate()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        Dentro de setContent se mete todoo lo que quieras que esté dentro de esa ventana. Normalmente deberías crear funciones que hagan cosas y luego las metes dentro de setContent. Según entiendo, su unico cometido debería ser recibir funciones

            setContent {
                WillForceEntrenaTuVoluntadTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        val navController = rememberNavController()

                        NavHost(
                            navController = navController,
                            startDestination = "principal",
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable("principal") {
                                PantallaPrincipal(navController = navController)
                            }
                            composable("desafios") {
                                PantallaDesafios(navController = navController)
                            }
                            composable("conceptos_clave") {
                                PantallaConceptosClave(navController = navController)
                            }
                        }
//                        HASTA AQUÍ LLEGA EL NAVHOST
                    }
                }
            }
//            HASTA AQUÍ LLEGA EL SETCONTENT
        }
    }

//Según entiendo, la etiqueta Composable lo que hace es indicar que esa función forma parte de la UI de la app y su estado puede ir variando
@Composable
fun PantallaPrincipal(modifier: Modifier = Modifier, navController: NavHostController) {
//    Se forma una columna. Entre sus parentesis metes las características propias de esa columna. Entre sus corchetes toddo lo que contendrá esa columna.
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF1F8E9)) // verde muy claro de fondo
            .padding(30.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo de la aplicación. Representa una persona y todo sus ámbitos de crecimiento.",

            modifier = Modifier
                .size(350.dp)
                .padding(bottom = 32.dp) // separación respecto a los textos
                .clip(CircleShape)
                .border(width = 2.dp, color = Color(0xFF1B5E20),shape = CircleShape),

            contentScale = ContentScale.Crop
        )

        TituloSeccion("Desafíos") {
            navController.navigate("desafios")
        }
        TituloSeccion("Desafíos completados") {
            // navController.navigate("desafios_completados")
        }
        TituloSeccion("Conceptos clave") {
            navController.navigate("conceptos_clave")
        }

        Row(
            modifier = modifier
            .background(Color(0xFFF3F7E8)) // verde muy claro de fondo
        )
        {
           Text(text = frasesAleatorias.random(),
               fontSize = 25.sp,
               fontWeight = FontWeight.Bold,
               color = Color(0xFF1B5E20))
        }
    }
}

@Composable
fun TituloSeccion(texto: String, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val colorFondo by animateColorAsState(
        targetValue = if (isPressed) Color(0xFFC8E6C9) else Color.Transparent,
        label = "colorFondoTitulo"
    )

    Text(
        text = texto,
        fontSize = 26.sp,
        fontWeight = FontWeight.Medium,
        color = Color(0xFF1B5E20),
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(colorFondo)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

