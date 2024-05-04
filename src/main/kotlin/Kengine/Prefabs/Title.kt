package Kengine.Prefabs

import Kengine.Application
import Kengine.Entity
import Kengine.Interfaces.Game
import Kengine.Interfaces.Prefab
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

object Title: Prefab {
    @Composable
    override fun draw(entity: Entity) {
        return Box(){
            Text(text = "Title Prefab")
        }
    }
    @Composable
    override fun draw(entity: Entity, app: Application): Prefab {
        return Title
    }

}