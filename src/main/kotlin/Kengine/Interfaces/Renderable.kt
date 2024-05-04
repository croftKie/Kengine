package Kengine.Interfaces

import androidx.compose.runtime.Composable

interface Renderable {
    @Composable
    fun create()
    @Composable
    fun render()
    fun update(delta: Float)
}