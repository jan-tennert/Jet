import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.*
import kotlin.reflect.KProperty


@Composable
fun <T> Spinner(content: List<T>, currentContent: T, modifier: Modifier = Modifier, colors: SpinnerColors = SpinnerColors(buttonColor = MaterialTheme.colors.primary),textStyle: TextStyle = TextStyle.Default, alignment: SpinnerAlignment = SpinnerAlignment.RIGHT, onChange: (ChangeValue<T>, ChangeValue<T>) -> Unit) {
    spinnerWidthIndex(modifier, currentContent, colors, content, onChange = onChange, alignment = alignment, textStyle = textStyle)
}

@ExperimentalUnitApi
@Composable
fun Spinner(range: IntProgression, currentContent: Int, modifier: Modifier = Modifier, colors: SpinnerColors = SpinnerColors(buttonColor = MaterialTheme.colors.primary), textStyle: TextStyle = TextStyle.Default, alignment: SpinnerAlignment = SpinnerAlignment.RIGHT, onChange: (ChangeValue<Int>, ChangeValue<Int>) -> Unit) {
    spinnerWidthIndex(modifier, currentContent, colors, range.toList(), onChange = onChange, alignment = alignment, textStyle = textStyle)
}

@Composable
private fun <T> spinnerWidthIndex(modifier: Modifier = Modifier, currentContent: T, colors: SpinnerColors = SpinnerColors(buttonColor = MaterialTheme.colors.primary), list: List<T>, textStyle: TextStyle = TextStyle.Default, alignment: SpinnerAlignment = SpinnerAlignment.LEFT, onChange: (ChangeValue<T>, ChangeValue<T>) -> Unit) {
    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        var index by remember { mutableStateOf(0) }
        var content by remember { mutableStateOf(currentContent) }
        val height = maxHeight / 2
        val width = maxWidth / 2
        when(alignment) {
            SpinnerAlignment.RIGHT -> {
                BasicTextField(
                    currentContent.toString(),
                    textStyle = textStyle,
                    readOnly = true,
                    onValueChange = {},
                    singleLine = true,
                    modifier = Modifier
                        .width(width)
                        .height(height)
                        .border(1.dp, colors.outlineColor, RoundedCornerShape(3f))
                )
                ButtonUp(
                    modifier = Modifier.fillMaxWidth(0.2f)
                        .height(height / 2)
                        .offset(x = width),
                    color = colors.buttonUpColor
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

                        .offset(x = width, y = height / 2),
                    color = colors.buttonDownColor
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
            SpinnerAlignment.LEFT -> {
                BasicTextField(
                    list[index].toString(),
                    textStyle = textStyle,
                    readOnly = true,
                    onValueChange = {},
                    singleLine = true,
                    modifier = Modifier
                        .width(width)
                        .height(height)
                        .border(1.dp, colors.outlineColor, RoundedCornerShape(3f))
                )
                ButtonUp(
                    modifier = Modifier.fillMaxWidth(0.2f)
                        .height(height / 2)
                        .offset(x = -(width / 2.5f)),
                    color = colors.buttonUpColor
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

                        .offset(x = -(width / 2.5f), y = height / 2),
                    color = colors.buttonDownColor
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
            SpinnerAlignment.LEFT_RIGHT -> {
                BasicTextField(
                    list[index].toString(),
                    textStyle = textStyle,
                    readOnly = true,
                    onValueChange = {},
                    singleLine = true,
                    modifier = Modifier
                        .width(width)
                        .height(height / 2)
                        .border(1.dp, colors.outlineColor, RoundedCornerShape(3f))
                )
                ButtonUp(
                    modifier = Modifier.fillMaxWidth(0.2f)
                        .height(height / 2)
                        .offset(x = width),
                    color = colors.buttonUpColor
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

                        .offset(x = -(width / 2.5f)),
                    color = colors.buttonDownColor
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
            SpinnerAlignment.LEFT_RIGHT_RIGHT -> {
                BasicTextField(
                    list[index].toString(),
                    textStyle = textStyle,
                    readOnly = true,
                    onValueChange = {},
                    singleLine = true,
                    modifier = Modifier
                        .width(width)
                        .height(height / 2)
                        .border(1.dp, colors.outlineColor, RoundedCornerShape(3f))
                )
                ButtonUp(
                    modifier = Modifier.fillMaxWidth(0.2f)
                        .height(height / 2)
                        .offset(x = width),
                    color = colors.buttonUpColor
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

                        .offset(x = width + width / 2.5f),
                    color = colors.buttonDownColor
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
            SpinnerAlignment.RIGHT_LEFT_LEFT -> {
                BasicTextField(
                    list[index].toString(),
                    textStyle = textStyle,
                    readOnly = true,
                    onValueChange = {},
                    singleLine = true,
                    modifier = Modifier
                        .width(width)
                        .height(height / 2)
                        .border(1.dp, colors.outlineColor, RoundedCornerShape(3f))
                )
                ButtonUp(
                    modifier = Modifier.fillMaxWidth(0.2f)
                        .height(height / 2)
                        .offset(x = -width / 1.25f),
                    color = colors.buttonUpColor
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

                        .offset(x = -width / 2.5f),
                    color = colors.buttonDownColor
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
    }
}

@Composable
private fun ButtonUp(modifier: Modifier = Modifier, color: Color, onClick: () -> Unit) {
    Image(imageResource("arrow_up.png"), "Arrow Up", modifier = modifier
        .clickable {
            onClick()
        }
        .background(color, shape = RoundedCornerShape(3f)))
}

@Composable
private fun ButtonDown(modifier: Modifier = Modifier, color: Color, onClick: () -> Unit) {
    Image(imageResource("arrow_down.png"), "Arrow Down", modifier = modifier
        .clickable {
            onClick()
        }
        .background(color, shape = RoundedCornerShape(3f)))
}

data class ChangeValue<T>(val content: T, val index: Int = -1)
data class SpinnerColors(val buttonColor: Color, val buttonUpColor: Color = buttonColor, val buttonDownColor: Color = buttonColor, val outlineColor: Color = Color.Gray)

enum class SpinnerAlignment {
    RIGHT,
    LEFT,
    LEFT_RIGHT,
    LEFT_RIGHT_RIGHT,
    RIGHT_LEFT_LEFT
}