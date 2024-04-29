package Engine.Interfaces

import androidx.compose.ui.input.key.*

interface MovementXY {
    fun keyDownLeft(keyEvent: KeyEvent, key: Key, action: ()->Unit){
        if(keyEvent.type == KeyEventType.KeyDown){
            if (keyEvent.key == key){
                action()
            }
        }
    }
    fun keyDownRight(keyEvent: KeyEvent, key: Key, action: ()->Unit){
        if(keyEvent.type == KeyEventType.KeyDown){
            if (keyEvent.key == key){
                action()
            }
        }
    }
    fun keyUpRight(keyEvent: KeyEvent, key: Key, action: ()->Unit){
        if(keyEvent.type == KeyEventType.KeyUp){
            if (keyEvent.key == key){
                action()
            }
        }
    }
    fun keyUpLeft(keyEvent: KeyEvent, key: Key, action: ()->Unit){
        if(keyEvent.type == KeyEventType.KeyUp){
            if (keyEvent.key == key){
                action()
            }
        }
    }
}

interface Movement2d {

}
