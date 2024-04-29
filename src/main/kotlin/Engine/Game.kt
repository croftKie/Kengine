package Engine

import Engine.Interfaces.Game
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.pointer.PointerEvent

abstract class Game: Game {
    @Composable
    abstract fun render()
    @Composable
    abstract fun create()
    abstract fun update(delta: Long)
    abstract fun onKeyEvent(keyEvent: KeyEvent): Boolean
    abstract fun onMouseMove(pointerEvent: PointerEvent)
    abstract fun onMouseEnter(pointerEvent: PointerEvent)
}