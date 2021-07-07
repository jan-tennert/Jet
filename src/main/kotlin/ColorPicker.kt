import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import java.awt.MouseInfo
import java.awt.Robot

@Composable
fun ColorPicker(modifier: Modifier = Modifier, onSelect: (Color) -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    var selectedColor by remember { mutableStateOf(Color.Red) }
    var r by remember { mutableStateOf(TextFieldValue()) }
    var g by remember { mutableStateOf(TextFieldValue()) }
    var b by remember { mutableStateOf(TextFieldValue()) }

    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.horizontalGradient(colors()))
                .clickable(interactionSource = interactionSource, indication = null) {
                    val robot = Robot()
                    val color = robot.getPixelColor(
                        MouseInfo.getPointerInfo().location.x,
                        MouseInfo.getPointerInfo().location.y
                    )
                    selectedColor = Color(color.red, color.green, color.blue, color.alpha)
                    onSelect(selectedColor)
                }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.2f)
                    .offset(y = (-50).dp)
                    .background(selectedColor)
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxSize()
                )
            }

            TextField(
                r, onValueChange = {
                    r = it
                }, modifier = Modifier
                    .fillMaxSize(0.5f)
                    .offset(x = 200.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                )
        }

    }


}

fun colors(n: Int = 359): List<Color> {
    val cols = mutableListOf<Color>()
    for (i in 0 until n) {
        val color = java.awt.Color.getHSBColor(i.toFloat() / n.toFloat(), 0.85f, 1.0f)
        cols.add(Color(color.red, color.green, color.blue, color.alpha))
    }
    return cols
}

fun getColor(position: Float, maxWidth: Float): Color {
    val hue = (position / maxWidth) * 359
    val color = java.awt.Color.getHSBColor(hue, 0.85f, 1.0f)
    return Color(color.red, color.green, color.blue, color.alpha)
}