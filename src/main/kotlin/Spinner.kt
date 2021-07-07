import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Composable
fun Spinner(modifier: Modifier = Modifier, content: List<Any>) {
    Box(modifier = modifier.fillMaxSize()) {
        var index by remember { mutableStateOf(0) }

        TextField(content[index].toString(), readOnly = true, onValueChange = {})
        ButtonUp(modifier = Modifier.fillMaxSize(0.04f)
            .offset(x = 280.dp)) {
            if(content.lastIndex == index) {
                index = 0
            } else {
                index++
            }
        }
    }
}

@Composable
fun ButtonUp(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(onClick = {
        onClick()
    }, content = {
    }, modifier = modifier)

}