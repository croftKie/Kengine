package Kengine.Interfaces

import Kengine.Application
import Kengine.Entity
import androidx.compose.runtime.Composable

interface Prefab {
    @Composable
    fun draw(entity: Entity)
    @Composable
    fun draw(entity: Entity, app: Application): Prefab
}