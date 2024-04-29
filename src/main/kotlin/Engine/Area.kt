package Engine

import Engine.Interfaces.Input
import Engine.Interfaces.Renderable
import androidx.compose.runtime.Composable

open class Area(
    val entities: MutableList<Entity> = mutableListOf()
): Renderable, Input {

    private var sorted: MutableList<Entity> = entities.sortedBy {
        it.getZIndex()
    }.toMutableList()

    @Composable
    override fun create() {
        sorted.forEach {
            it.create()
        }
    }
    @Composable
    override fun render() {
        sorted.forEach {
            it.render()
        }
    }

    override fun update(delta: Long) {
        sorted.forEach {
            it.update(delta)
        }
    }
}