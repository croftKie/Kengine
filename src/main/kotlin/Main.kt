import Engine.Application
import Engine.Game
import Engine.Screen
import Engine.Utils.Enums
import androidx.compose.runtime.*
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


class MyGame() : Game(

) {
    private var menu = MenuScreen(this)
    private var playArea = GameScreen(this )

    override var currentGameState = mutableStateOf(Enums.GameState.MENU)
    override var screens: MutableList<Screen> = mutableListOf(
        menu, playArea
    )
    override var screenHeight: Dp = 500.dp
    override var screenWidth: Dp = 500.dp

    @Composable
    override fun render() {
        if(currentGameState.value == Enums.GameState.MENU){
            screens[0].render()
        } else {
            screens[1].render()
        }
    }

    @Composable
    override fun create() {
        if(currentGameState.value == Enums.GameState.MENU){
            screens[0].create()
        } else {
            screens[1].create()
        }
    }

    override fun update(delta: Long) {
        if(currentGameState.value == Enums.GameState.MENU){
            screens[0].update(delta)
        } else {
            screens[1].update(delta)
        }
    }

    override fun onKeyEvent(keyEvent: KeyEvent): Boolean {
        if(currentGameState.value == Enums.GameState.MENU){
            screens[0].onKeyEvent(keyEvent)
        } else {
            screens[1].onKeyEvent(keyEvent)
        }
        return true
    }

    override fun onMouseMove(pointerEvent: PointerEvent) {
    }

    override fun onMouseEnter(pointerEvent: PointerEvent) {
    }
}


fun main() {
    val app = Application()
    val game = MyGame()
    app.start(game)
}
