package Engine.Prefabs

import Engine.Entity
import Engine.Interfaces.Prefab
import Engine.Interfaces.Renderable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

object Sprite: Prefab {
    @Composable
    override fun draw(entity: Entity): Sprite {
        Image(
            painter = painterResource(entity.getAsset()), null, modifier = Modifier.offset(entity.getPosition().x, entity.getPosition().y).zIndex(entity.getZIndex().toFloat()),
        )
        return Sprite
    }
}