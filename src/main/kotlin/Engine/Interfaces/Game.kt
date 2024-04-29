package Engine.Interfaces

import Engine.Screen
import androidx.compose.ui.unit.Dp

interface Game {
    var screens: MutableList<Screen>
    var screenHeight: Dp
    var screenWidth: Dp
}