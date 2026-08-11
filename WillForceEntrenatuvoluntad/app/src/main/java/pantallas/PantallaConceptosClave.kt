package pantallas

import Concepto
import Desafio
import android.R.attr.padding
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaConceptosClave(modifier: Modifier = Modifier, navController: NavController) {
//    Se forma una columna. Entre sus parentesis metes las características propias de esa columna. Entre sus corchetes toddo lo que contendrá esa columna.
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Conceptos clave") },
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
    )
    { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(ListaDeConceptos) { concepto ->
                TarjetaConceptos(concepto = concepto)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
val ListaDeConceptos = listOf(
    Concepto(
        id = 1,
        nombre = "Incomodidad controlada",
        descripcion = """
            Práctica deliberada de exponerse a situaciones que generan malestar físico o emocional, pero en dosis manejables y progresivas. 
            El objetivo no es sufrir por sufrir, sino entrenar la mente para que las dificultades cotidianas pierdan su poder sobre nosotros. 
            Al enfrentar voluntariamente lo incómodo, disminuimos la ansiedad ante lo imprevisto y aumentamos nuestra confianza para afrontar adversidades reales.
            
            Ejemplo: Tomar una ducha fría durante 30 segundos cada mañana, aumentando gradualmente el tiempo. 
            Al principio resulta desagradable, pero con el tiempo el cuerpo se adapta y la mente aprende que el malestar no es peligroso, solo incómodo.
        """.trimIndent()
    ),

    Concepto(
        id = 2,
        nombre = "Fuerza de voluntad",
        descripcion = """
            Recurso mental finito que nos permite posponer gratificaciones inmediatas en favor de recompensas futuras más valiosas. 
            Implica tres componentes: control atencional (mantener el foco), control de impulsos (resistir tentaciones) y perseverancia (no rendirse ante el fracaso). 
            Funciona como un músculo que se fatiga con el uso excesivo, pero que también se fortalece con el entrenamiento constante.
            
            Ejemplo: Tener un pastel de chocolate en la nevera, pero decidir no comerlo porque estás en un déficit calórico para llegar a tu peso ideal en verano. 
            Cada vez que resistes, estás ejercitando tu fuerza de voluntad.
        """.trimIndent()
    ),

    Concepto(
        id = 3,
        nombre = "Hormesis",
        descripcion = """
            Principio adaptativo por el cual un agente estresante, en dosis bajas o moderadas, activa mecanismos de reparación y fortalecimiento que mejoran la resistencia general del organismo o la mente. 
            Sin embargo, en dosis altas, ese mismo agente causa daño. 
            La clave está en la "dosis adecuada": ni demasiado poco (no hay estímulo) ni demasiado (hay lesión).
            
            Ejemplo: Hacer ejercicio intenso pero breve (como correr 20 minutos) provoca microdesgarros musculares que, al repararse, hacen los músculos más fuertes. 
            En cambio, correr durante 5 horas sin entrenamiento previo puede causar lesiones graves o rabdomiólisis.
        """.trimIndent()
    ),

    Concepto(
        id = 4,
        nombre = "Adaptación hedónica",
        descripcion = """
            Fenómeno psicológico por el cual las personas retornan a un nivel estable de felicidad (llamado "set point" o punto de referencia) después de experimentar eventos que alteran ese estado, ya sean positivos (ganar la lotería) o negativos (sufrir un accidente). 
            Este mecanismo evolutivo evita que nos estanquemos en extremos emocionales, pero también explica por qué los logros materiales no nos hacen felices a largo plazo.
            
            Ejemplo: Compras un coche nuevo y durante la primera semana sientes una gran emoción cada vez que lo miras. 
            Al mes, ya te parece normal y ni siquiera lo notas. 
            Al año, ya estás pensando en cambiar de modelo. 
            La felicidad volvió a su nivel anterior.
        """.trimIndent()
    ),

    Concepto(
        id = 5,
        nombre = "Vista desde arriba",
        descripcion = """
            Ejercicio de imaginación estoica que consiste en elevar mentalmente nuestro punto de vista hasta observar la Tierra desde gran altura —como un satélite o incluso desde el espacio— y vernos a nosotros mismos como un punto diminuto entre millones. 
            Esta perspectiva cósmica reduce la magnitud de nuestras preocupaciones diarias (discusiones, atascos, retrasos) y nos ayuda a distinguir entre lo trivial y lo verdaderamente importante (salud, relaciones, integridad).
            
            Ejemplo: Estás estresado porque llegaste tarde a una reunión. 
            Cierras los ojos e imaginas que ves la ciudad desde un avión, luego desde la atmósfera, y finalmente desde el espacio, donde tu ciudad ni siquiera se distingue. 
            Entonces piensas: "¿Realmente importa este retraso en el panorama general de mi vida?". 
            La ansiedad disminuye y recuperas la calma para disculparte y seguir adelante.
        """.trimIndent()
    )
)

    @Composable
    fun TarjetaConceptos(concepto: Concepto, modifier: Modifier = Modifier) {
        var expanded by remember { mutableStateOf(false) }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFE8F5E9))
                .clickable {
                    expanded = !expanded
                }
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = concepto.nombre,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1B5E20)
            )
            if (expanded) {
                Text(
                    text = concepto.descripcion,
                    fontSize = 14.sp,
                    color = Color(0xFF33691E),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }