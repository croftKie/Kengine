package Kengine

import Kengine.Interfaces.Input
import Kengine.Interfaces.Renderable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.pointer.PointerEvent

open class Screen(
    var app: Application,
    var entities: MutableMap<String, Entity> = mutableMapOf(),
): Renderable, Input {
    private var sorted: MutableList<Entity> = entities.values.toList().sortedBy {
        it.getZIndex()
    }.toMutableList()

    open fun getEntity(name: String): Entity{
        return entities[name]!!
    }

    override fun onKeyEvent(keyEvent: KeyEvent) {
        sorted.forEach{
            it.onKeyEvent(keyEvent)
        }
    }

    override fun onMouseMove(pointerEvent: PointerEvent) {
    }

    override fun onMouseEnter(pointerEvent: PointerEvent) {
    }

    @Composable
    override fun create() {

    }
    @Composable
    override fun render() {
        sorted.forEach {
            it.render()
        }
    }

    override fun update(delta: Float) {
        sorted.forEach {
            it.update(delta)
        }
    }
}