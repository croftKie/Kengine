import Kengine.Application
import Kengine.Game
import Kengine.Utils.Enums
import androidx.compose.runtime.*
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.unit.dp


fun main() {
    val app = Application(
        screenWidth = 600.dp,
        screenHeight = 677.dp,
    )

    app.initialise(
        screens = mutableMapOf(
            "menu" to MenuScreen(app),
            "play" to GameScreen(app)
        )
    )

    app.start()
}
