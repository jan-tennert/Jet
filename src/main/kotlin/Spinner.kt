import androidx.compose.desktop.SwingPanel
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.*
import javax.swing.JPanel
import javax.swing.JSpinner

@Composable
fun <T> Spinner(content: List<T>, modifier: Modifier = Modifier, onChange: (ChangeValue<T>, ChangeValue<T>) -> Unit) {
    spinnerWidthIndex(modifier, content, onChange = onChange)
}

@Composable
fun Spinner(range: IntProgression, modifier: Modifier = Modifier, onChange: (ChangeValue<Int>, ChangeValue<Int>) -> Unit) {
    spinnerWidthIndex(modifier, range.toList(), onChange = onChange)
}

@ExperimentalUnitApi
@Composable
fun Spinner(start: Int, step: Int = 1, modifier: Modifier = Modifier, textStyle: TextStyle = TextStyle.Default, onChange: (ChangeValue<Int>, ChangeValue<Int>) -> Unit) {
    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        var number by remember { mutableStateOf(start) }
        val height = maxHeight / 2
        val width = maxWidth / 2
        BasicTextField(
            number.toString(),
            textStyle = textStyle,
            readOnly = true,
            onValueChange = {},
            singleLine = true,
            modifier = Modifier
                .width(width)
                .height(height)
                .border(1.dp, Color.Gray, RoundedCornerShape(3f))
        )
        ButtonUp(
            modifier = Modifier.fillMaxWidth(0.2f)
                .height(height / 2)
                .offset(x = width)
        ) {
            val old = number
            number += step
            val new = number
            onChange(ChangeValue(old), ChangeValue(new))
        }
        ButtonDown(
            modifier = Modifier.fillMaxWidth(0.2f)
                .height(height / 2)

                .offset(x = width, y = height / 2)
        ) {
            val old = number
            number -= step
            val new = number
            onChange(ChangeValue(old), ChangeValue(new))
        }
    }
}

@Composable
private fun <T> spinnerWidthIndex(modifier: Modifier = Modifier, list: List<T>, textStyle: TextStyle = TextStyle.Default, onChange: (ChangeValue<T>, ChangeValue<T>) -> Unit) {
    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        var index by remember { mutableStateOf(0) }
        val height = maxHeight / 2
        val width = maxWidth / 2
        BasicTextField(
            list[index].toString(),
            textStyle = textStyle,
            readOnly = true,
            onValueChange = {},
            singleLine = true,
            modifier = Modifier
                .width(width)
                .height(height)
                .border(1.dp, Color.Gray, RoundedCornerShape(3f))
        )
        ButtonUp(
            modifier = Modifier.fillMaxWidth(0.2f)
                .height(height / 2)
                .offset(x = width)
        ) {
            if (list.lastIndex == index) {
                val old = ChangeValue(list[index], index)
                index = 0
                val new = ChangeValue(list[0], 0)
                onChange(old, new)
            } else {
                val old = ChangeValue(list[index], index)
                index++
                val new = ChangeValue(list[index], index)
                onChange(old, new)
            }
        }
        ButtonDown(
            modifier = Modifier.fillMaxWidth(0.2f)
                .height(height / 2)

                .offset(x = width, y = height / 2)
        ) {
            if (index == 0) {
                val old = ChangeValue(list[0], 0)
                index = list.lastIndex
                val new = ChangeValue(list[index], index)
                onChange(old, new)
            } else {
                val old = ChangeValue(list[index], index)
                index--
                val new = ChangeValue(list[0], 0)
                onChange(old, new)
            }
        }
    }
}

@Composable
fun ButtonUp(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Image(imageResource("arrow_up.png"), "Arrow Up", modifier = modifier
        .clickable {
            onClick()
        }
        .background(MaterialTheme.colors.primary, shape = RoundedCornerShape(3f)))
}

@Composable
fun ButtonDown(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Image(imageResource("arrow_down.png"), "Arrow Up", modifier = modifier
        .clickable {
            onClick()
        }
        .background(MaterialTheme.colors.primary, shape = RoundedCornerShape(3f)))
}

data class ChangeValue<T>(val content: T, val index: Int = -1)