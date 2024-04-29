package Engine

import Engine.Interfaces.Input
import androidx.compose.runtime.Composable

abstract class Screen: Input {
    @Composable
    abstract fun render()
    @Composable
    abstract fun create()
    abstract fun update(delta: Long)
}