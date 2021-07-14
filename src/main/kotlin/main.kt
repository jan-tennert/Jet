import androidx.compose.desktop.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.*
import org.pushingpixels.aurora.AuroraSkin
import org.pushingpixels.aurora.auroraBackground
import org.pushingpixels.aurora.component.model.ComboBoxContentModel
import org.pushingpixels.aurora.component.model.ComboBoxPresentationModel
import org.pushingpixels.aurora.component.model.Command
import org.pushingpixels.aurora.component.projection.ComboBoxProjection
import org.pushingpixels.aurora.component.projection.CommandButtonProjection
import org.pushingpixels.aurora.icon.AuroraThemedFollowTextIcon
import org.pushingpixels.aurora.skin.getAuroraSkins
import org.pushingpixels.aurora.skin.marinerSkin
import org.pushingpixels.aurora.skin.twilightSkin
import org.pushingpixels.aurora.window.AuroraWindow
import java.awt.SystemColor.text

@ExperimentalUnitApi
fun main() {
    AuroraWindow(
        skin = marinerSkin(),
        title = "Test",
        size = IntSize(800, 600),
        undecorated = true
    ) {
        /*var color by remember { mutableStateOf(Color.Red) }
        ColorPicker(modifier = Modifier.fillMaxSize(0.2f).offset(y = 150.dp)) {
            color = it
        }*/
        Column {
            val list = listOf("Test1", "Test2", "Test3")
            var currentIndex by remember { mutableStateOf(0) }
            Spinner(list, currentIndex, alignment = SpinnerAlignment.LEFT_RIGHT_RIGHT, modifier = Modifier
                .width(300.dp)
                .height(200.dp)
                .offset(x = 200.dp), onChange = { old, new ->
                println("Old: ${old.content}[${old.index}]")
                println("New: ${new.content}[${new.index}]")
            })
            Button(onClick = {
                currentIndex = 2
            }, content = {
                Text("Hi")
            })
            Text("")

        }
    }
}

