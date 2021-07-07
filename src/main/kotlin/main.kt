import androidx.compose.desktop.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

fun main() {
    Window {
        /*var color by remember { mutableStateOf(Color.Red) }
        ColorPicker(modifier = Modifier.fillMaxSize(0.2f).offset(y = 150.dp)) {
            color = it
        }*/
        Spinner(content = listOf("Tomate", "Gurke", "Banane", "Schnittlauch"))

    }
}

