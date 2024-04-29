package Engine.Interfaces

import Engine.Entity
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

interface Prefab {
    @Composable
    fun draw(entity: Entity): Prefab
}