package Engine

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

class Application() {
    @OptIn(ExperimentalComposeUiApi::class)
    fun start(game: Game) = application {

        Window(
            state = WindowState(
                height = game.screenHeight,
                width = game.screenWidth
            ),
            onKeyEvent = {
                game.onKeyEvent(it)
            },
            onCloseRequest = ::exitApplication
        ) {
            val g = remember { game }
            val density = LocalDensity.current
            LaunchedEffect(Unit) {
                while (true) {
                    withFrameNanos {
                        g.update(it)
                    }
                }
            }

            g.create()

            MaterialTheme {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .onPointerEvent(PointerEventType.Move){
                        game.onMouseMove(it)
                    }
                    .onPointerEvent(PointerEventType.Enter){
                        game.onMouseEnter(it)
                    }){
                    g.render()
                }
            }
        }
    }
}