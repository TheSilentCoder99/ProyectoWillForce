package com.example.willforce_entrenatuvoluntad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()  // debe ir ANTES de super.onCreate()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        Dentro de setContent se mete todoo lo que quieras que esté dentro de esa ventana. Normalmente deberías crear funciones que hagan cosas y luego las metes dentro de setContent. Según entiendo, su unico cometido debería ser recibir funciones.
        setContent {

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

