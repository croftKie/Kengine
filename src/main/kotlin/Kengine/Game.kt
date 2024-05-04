package Kengine

import Kengine.Interfaces.Game
import Kengine.Utils.Enums
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.unit.Dp

open class Game(
    override var screens: MutableMap<String, Screen> = mutableMapOf(),
    override var currentGameState: MutableState<Enums.GameState>,
    override var screenHeight: Dp,
    override var screenWidth: Dp,
): Game {
    private var currentScreen: MutableState<Screen>? = null

    open fun getScreen(name: String): Screen{
        return screens[name]!!
    }
    open fun getCurrentScreen(): Screen{
        return currentScreen?.value!!
    }
    open fun setCurrentScreen(name: String){
        currentScreen = mutableStateOf(screens[name]!!)
    }



//
//
//
    @Composable
    open fun create(){
    }
    @Composable
    open fun render(){

    }
    open fun update(floatDelta: Float){

    }
    open fun onKeyEvent(keyEvent: KeyEvent): Boolean{
        return true
    }
    open fun onMouseMove(pointerEvent: PointerEvent){}
    open fun onMouseEnter(pointerEvent: PointerEvent){}
    open fun onMouseExit(pointerEvent: PointerEvent){}
    open fun onMousePress(pointerEvent: PointerEvent){}
    open fun onMouseRelease(pointerEvent: PointerEvent){}
    open fun onMouseScroll(pointerEvent: PointerEvent){}
}