package Kengine.Utils

import Kengine.Entity
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isUnspecified

object Collision {
    fun overlaps(
        entity: Entity,
        collidor: Entity,
        type: String = "lower",
        action: ()->Unit = {}
    ): Boolean{
        if(entity.getPosition().isUnspecified) {
            return false
        }

        when (type){
            "lower" -> {
                if(!lowerXCollision(entity, collidor) && !lowerYCollision(entity, collidor)){
                    action()
                    return true
                }
            }
            "upper" -> {
                if(
                    !upperXCollision(entity, collidor) ||
                    !upperYCollision(entity, collidor)
                        ){
                    action()
                    return true
                }
            }
            "total" -> {
                if(
                    !lowerXCollision(entity, collidor) ||
                    !lowerYCollision(entity, collidor) ||
                    !upperXCollision(entity, collidor) ||
                    !upperYCollision(entity, collidor)
                ){
                    action()
                    return true
                }
            }
        }

        return false
    }


    fun proximityOverlap(
        entity: Entity,
        collidor: Entity,
        percentage: Int = 10,
        action: ()->Unit
    ): Boolean{
        if(entity.getPosition().isUnspecified) {
            return false
        }
        if(!lowerCollision(entity, collidor, percentage)){
            action()
            return true
        }
        return false
    }


//
//    Internal Util Functions

    private fun lowerXCollision(
        entity: Entity,
        collidor: Entity,
        percentage: Int = 0
    ): Boolean{
        val p: Double = 1.0 + (percentage / 100)

        if(entity.getPosition().x > collidor.getPosition().x){
            if (entity.getHitbox()["BL"]?.x!!.value.toDouble() * p <= collidor.getHitbox()["BR"]?.x!!.value.toDouble() * p) return false
        }

        if(entity.getPosition().x < collidor.getPosition().x){
            if (entity.getHitbox()["BR"]?.x!!.value.toDouble() * p >= collidor.getHitbox()["BL"]?.x!!.value.toDouble() * p) {
                return false
            }
        }

        return true
    }
    private fun upperXCollision(
        entity: Entity,
        collidor: Entity,
        percentage: Int = 0
    ): Boolean{
        val p: Double = 1.0 + (percentage / 100)

        if(entity.getPosition().x > collidor.getPosition().x){
            if (entity.getHitbox()["TL"]?.x!!.value.toDouble() * p <= collidor.getHitbox()["TR"]?.x!!.value.toDouble() * p) return false
        }

        if(entity.getPosition().x < collidor.getPosition().x){
            if (entity.getHitbox()["TR"]?.x!!.value.toDouble() * p <= collidor.getHitbox()["TL"]?.x!!.value.toDouble() * p) return false
        }

        return true
    }
    private fun lowerYCollision(
        entity: Entity,
        collidor: Entity,
        percentage: Int = 0
    ): Boolean{
        val p: Double = 1.0 + (percentage / 100)

        if (entity.getHitbox()["BL"]?.y!!.value.toDouble() * p >= collidor.getHitbox()["TL"]?.y!!.value.toDouble() * p) return false
        if (entity.getHitbox()["BR"]?.y!!.value.toDouble() * p >= collidor.getHitbox()["TR"]?.y!!.value.toDouble() * p) return false

        return true
    }
    private fun upperYCollision(
        entity: Entity,
        collidor: Entity,
        percentage: Int = 0
    ): Boolean{
        val p: Double = 1.0 + (percentage / 100)

        if (entity.getHitbox()["TL"]?.y!!.value.toDouble() * p <= collidor.getHitbox()["BL"]?.y!!.value.toDouble() * p) return false
        if (entity.getHitbox()["TR"]?.y!!.value.toDouble() * p <= collidor.getHitbox()["BR"]?.y!!.value.toDouble() * p) return false

        return true
    }



    private fun lowerCollision(
    entity: Entity,
    collidor: Entity,
    percentage: Int = 0
    ): Boolean {
        val p: Double = 1.0 + (percentage / 100)
        println(entity.getHitbox()["BL"]?.x!!.value.toDouble() * p <= collidor.getHitbox()["BR"]?.x!!.value.toDouble() * p)
        if (entity.getHitbox()["BL"]?.x!!.value.toDouble() * p <= collidor.getHitbox()["BR"]?.x!!.value.toDouble() * p) return false
        if (entity.getHitbox()["BR"]?.x!!.value.toDouble() * p <= collidor.getHitbox()["BL"]?.x!!.value.toDouble() * p) return false
        if (entity.getHitbox()["BL"]?.y!!.value.toDouble() * p >= collidor.getHitbox()["TL"]?.y!!.value.toDouble() * p) return false
        if (entity.getHitbox()["BR"]?.y!!.value.toDouble() * p >= collidor.getHitbox()["TR"]?.y!!.value.toDouble() * p) return false
        return true
    }
    private fun upperCollision(
        entity: Entity,
        collidor: Entity,
        percentage: Int = 0
    ): Boolean {
        val p: Double = 1.0 + (percentage / 100)

        if (entity.getHitbox()["TL"]?.x!!.value.toDouble() * p >= collidor.getHitbox()["TR"]?.x!!.value.toDouble() * p) return false
        if (entity.getHitbox()["TR"]?.x!!.value.toDouble() * p <= collidor.getHitbox()["TL"]?.x!!.value.toDouble() * p) return false
        if (entity.getHitbox()["TL"]?.y!!.value.toDouble() * p <= collidor.getHitbox()["BL"]?.y!!.value.toDouble() * p) return false
        if (entity.getHitbox()["TR"]?.y!!.value.toDouble() * p <= collidor.getHitbox()["BR"]?.y!!.value.toDouble() * p) return false

        return true
    }

}



