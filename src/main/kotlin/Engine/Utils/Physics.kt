package Engine.Utils

import Engine.Entity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset

object Physics {

    fun feelsGravity(entity: Entity, fallRate: Dp){
        if(entity.getGravity() && !entity.getIsGrounded()){
            entity.setPosition(
                DpOffset(
                    entity.getPosition().x,
                    entity.getPosition().y + fallRate
                )
            )
        }
    }

}