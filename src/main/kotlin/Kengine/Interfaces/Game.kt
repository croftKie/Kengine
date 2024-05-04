package Kengine.Interfaces

import Kengine.Screen
import Kengine.Utils.Enums
import androidx.compose.runtime.MutableState
import androidx.compose.ui.unit.Dp

interface Game {
    var currentGameState: MutableState<Enums.GameState>
    var screens: MutableMap<String, Screen>
    var screenHeight: Dp
    var screenWidth: Dp
}