package Engine.Interfaces

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

interface Renderable {
    @Composable
    fun create()
    @Composable
    fun render()
    fun update(delta: Long)
}