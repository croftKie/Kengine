package Engine.Interfaces

import Engine.Screen
import Engine.Utils.Enums
import androidx.compose.runtime.MutableState
import androidx.compose.ui.unit.Dp

interface Game {
    var currentGameState: MutableState<Enums.GameState>
    var screens: MutableList<Screen>
    var screenHeight: Dp
    var screenWidth: Dp
}