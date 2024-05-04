package Kengine.Prefabs

import Kengine.Application
import Kengine.Entity
import Kengine.Interfaces.Game
import Kengine.Interfaces.Prefab
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

object Backdrop: Prefab {

    @Composable
    override fun draw(entity: Entity) {
        return Box(
            modifier = Modifier.fillMaxSize(1F)
        ){
            Image(
                painter = painterResource("bg.png"),
                contentScale = ContentScale.FillBounds,
                contentDescription = "")
        }
    }

    @Composable
    override fun draw(entity: Entity, app: Application): Prefab {
        Box(
            modifier = Modifier
                .height(app.screenHeight)
                .width(app.screenWidth)
        ){
            Image(
                painter = painterResource("bg.png"),
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(app.screenWidth, app.screenHeight),
                contentDescription = "")
        }
        return this
    }
}