package Engine

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpOffset

abstract class Object {
    @Composable
    abstract fun draw(entity: Entity): Unit
}