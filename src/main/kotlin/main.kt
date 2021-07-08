import androidx.compose.desktop.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@ExperimentalUnitApi
fun main() {
    Window {
        /*var color by remember { mutableStateOf(Color.Red) }
        ColorPicker(modifier = Modifier.fillMaxSize(0.2f).offset(y = 150.dp)) {
            color = it
        }*/
        Column {
            Spinner(start = 2, step = 4, modifier = Modifier
                .width(150.dp)
                .height(100.dp), onChange = { old, new ->

            })
            Spinner(listOf("Keks", "Nein"), modifier = Modifier
                .width(100.dp)
                .height(60.dp), onChange = { old, new ->
                println("Old: ${old.content}[${old.index}]")
                println("New: ${new.content}[${new.index}]")
            })
        }
    }
}

