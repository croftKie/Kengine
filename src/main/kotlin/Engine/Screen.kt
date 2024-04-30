package Engine

import Engine.Interfaces.Input
import Engine.Interfaces.Renderable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.pointer.PointerEvent

open class Screen(
    var game: Game,
    var areas: MutableList<Area> = mutableListOf(),
    var currentArea: MutableState<Area>? = null
):Renderable, Input {
    @Composable
    override fun create() {
        currentArea?.value?.create()
    }
    @Composable
    override fun render() {
        currentArea?.value?.render()
    }
    override fun update(delta: Long) {
        currentArea?.value?.update(delta)
    }
    override fun onKeyEvent(keyEvent: KeyEvent) {
    }
    override fun onMouseMove(pointerEvent: PointerEvent) {
    }
    override fun onMouseEnter(pointerEvent: PointerEvent) {
    }

    open fun setArea(area: Area){
        currentArea = mutableStateOf(area)
    }
}