package Engine.Interfaces

import androidx.compose.runtime.MutableState
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset

interface Moveable {
    var velocity: MutableState<Dp>
    var friction: MutableState<Dp>
}