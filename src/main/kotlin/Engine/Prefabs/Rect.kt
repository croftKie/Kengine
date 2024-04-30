package Engine.Prefabs

import Engine.Entity
import Engine.Interfaces.Prefab
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object Rect: Prefab {
    @Composable
    override fun draw(entity: Entity): Prefab {
        Box(
            modifier = Modifier
                .offset(entity.getPosition().x,
                    entity.getPosition().y)
                .background(Color.Black)
                .height(100.dp)
                .fillMaxWidth()
        )
        return Rect
    }
}