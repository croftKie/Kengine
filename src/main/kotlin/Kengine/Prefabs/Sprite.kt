package Kengine.Prefabs

import Kengine.Application
import Kengine.Entity
import Kengine.Interfaces.Game
import Kengine.Interfaces.Prefab
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.zIndex

object Sprite: Prefab {
    @Composable
    override fun draw(entity: Entity) {
        return Box(
            modifier = Modifier
                .height(entity.getHeight())
                .width(entity.getWidth())
                .offset(entity.getPosition().x, entity.getPosition().y)
        ){
            Image(
                painter = painterResource(entity.getAsset()),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .zIndex(entity.getZIndex().toFloat())
                    .scale(entity.getScale()[0],entity.getScale()[1]),
            )
        }
    }

    @Composable
    override fun draw(entity: Entity, app: Application): Prefab {
        return Sprite
    }

}