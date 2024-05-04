package Kengine.Utils

import androidx.compose.ui.input.key.*

object Keys {
    fun keyDown(keyEvent: KeyEvent, key: Key, action: ()->Unit){
        if(keyEvent.type == KeyEventType.KeyDown){
            if (keyEvent.key == key){
                action()
            }
        }
    }
    fun keyUp(keyEvent: KeyEvent, key: Key, action: ()->Unit){
        if(keyEvent.type == KeyEventType.KeyUp){
            if (keyEvent.key == key){
                action()
            }
        }
    }
}
