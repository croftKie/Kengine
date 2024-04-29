package Engine.Interfaces

import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.pointer.PointerEvent

interface Input {
   fun onKeyEvent(keyEvent: KeyEvent): Boolean {
        return true
    }
    fun onMouseMove(pointerEvent: PointerEvent) {
    }

    fun onMouseEnter(pointerEvent: PointerEvent) {
    }
}