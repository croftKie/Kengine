package Kengine

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.ComposeWindow
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import java.awt.GraphicsConfiguration

class Application(
    val screenHeight: Dp = 600.dp,
    val screenWidth: Dp = 677.dp,
    var screens: MutableMap<String, Screen> = mutableMapOf<String, Screen>()
) {
    var currentScreen = mutableStateOf<Screen?>(null)
    var prevTime = 0L
    var drawCalls = mutableStateOf(0)

    fun initialise(screens: MutableMap<String, Screen>){
        this.screens = screens
        currentScreen = mutableStateOf(screens.values.toList()[0])
    }

    private fun getCurrentScreen(): Screen{
        return currentScreen?.value!!
    }

    @OptIn(ExperimentalComposeUiApi::class)
    fun start() = application {

        Window(
            state = WindowState(
                height = screenHeight,
                width = screenWidth
            ),
            onKeyEvent = {
                getCurrentScreen().onKeyEvent(it)
                true
            },
            onCloseRequest = ::exitApplication
        ) {

            key(currentScreen.value){
                loop(getCurrentScreen())

                Box{
                    MaterialTheme {
                        Box(modifier = Modifier
                            .fillMaxSize()
//                            .onKeyEvent {
//                                println("fired")
//                                getCurrentScreen().onKeyEvent(it)
//                                true
//                            }
                            .onPointerEvent(PointerEventType.Move){
                                getCurrentScreen().onMouseMove(it)
                            }
                            .onPointerEvent(PointerEventType.Enter){
                                getCurrentScreen().onMouseEnter(it)
                            }
//                            .onPointerEvent(PointerEventType.Exit){
//                                getCurrentScreen().onMouseExit(it)
//                            }
//                            .onPointerEvent(PointerEventType.Press){
//                                getCurrentScreen().onMousePress(it)
//                            }
//                            .onPointerEvent(PointerEventType.Release){
//                                getCurrentScreen().onMouseRelease(it)
//                            }
//                            .onPointerEvent(PointerEventType.Scroll){
//                                getCurrentScreen().onMouseScroll(it)
//                            }
                        ){
                            getCurrentScreen().render()
                        }
                    }
                }
            }

        }
    }

    @Composable
    private fun loop(screen: Screen){
        LaunchedEffect(Unit) {
            while (true) {
                withFrameNanos {
                    val delta = it - prevTime
                    val floatDelta = (delta / 1E8).toFloat()
                    prevTime = it
                    screen.update(floatDelta)
                }
            }
        }
    }
}