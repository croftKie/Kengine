package Engine.Utils

import Engine.Entity
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.isUnspecified

object Collision {
    private var collisionActive = mutableStateOf(false)

    fun overlaps(entity: Entity, collidor: Entity, action: ()->Unit): Boolean{
        if(entity.getPosition().isUnspecified) {
            return false
        }

//        if(isInFront(entity, collidor)){
//            collisionActive = false
//            return false
//        }

        val entPos = entity.getHitbox()["BL"]?.get("y")
        val colPos = collidor.getHitbox()["BL"]?.get("y")

        if(entPos!! >= colPos!!){
            action()
        }
        return true
    }

    fun isInFront(entity: Entity, collidor: Entity, collisionActive: MutableState<Boolean>): Boolean{
        if(entity.getHitbox().get("BR")?.get("y")?.value!! > collidor.getHitbox().get("BL")?.get("y")?.value!!){
            return true
        }
        return false
    }

    fun isBehind(entity: Entity, collidor: Entity, action: () -> Unit): Boolean{
        if(entity.getHitbox().get("BR")?.get("y")?.value!! < collidor.getHitbox().get("BL")?.get("y")?.value!!){
            return true
        }
        return true
    }


}