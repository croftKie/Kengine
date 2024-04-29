package Engine

import Engine.Interfaces.Input
import Engine.Interfaces.Renderable
import Engine.Utils.Physics
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import org.openrndr.math.Vector2
import java.awt.Image

open class Entity(
    private val resource: String = "",
    private val startX: Dp = 0.dp,
    private val startY: Dp = 0.dp,
    val height: Dp? = null,
    val width: Dp? = null
):Renderable, Input {
    private var _zIndex: MutableState<Int> = mutableStateOf(0)
    private var _position: MutableState<DpOffset> = mutableStateOf(DpOffset(startX, startY))
    private var _asset: MutableState<String> = mutableStateOf("")
    private var _gravity: MutableState<Boolean> = mutableStateOf(false)
    private var _isGrounded: MutableState<Boolean> = mutableStateOf(false)
    private var _height: MutableState<Dp> = mutableStateOf(0.dp)
    private var _width: MutableState<Dp> = mutableStateOf(0.dp)
    private var _hitbox: MutableState<Map<String, Map<String, Dp>>> = mutableStateOf(mapOf(
        "TL" to mapOf(
            "x" to 0.dp,
            "y" to 0.dp
        ),
        "TR" to mapOf(
            "x" to 0.dp,
            "y" to 0.dp
        ),
        "BL" to mapOf(
            "x" to 0.dp,
            "y" to 0.dp
        ),
        "BR" to mapOf(
            "x" to 0.dp,
            "y" to 0.dp
        ),
    ))
    private var offsetTL: List<Dp> = listOf(0.dp, 0.dp)
    private var offsetTR: List<Dp> = listOf(0.dp, 0.dp)
    var offsetBL: List<Dp> = listOf(0.dp, 0.dp)
    var offsetBR: List<Dp> = listOf(0.dp, 0.dp)

    @Composable
    override fun create() {
        _position.value = DpOffset(startX, startY)
        _asset.value = resource
        if(resource != ""){
            val pr = painterResource(resource)
            _height.value = pr.intrinsicSize.height.dp
            _width.value = pr.intrinsicSize.width.dp
            _hitbox.value = mapOf(
                "TL" to mapOf(
                    "x" to startX,
                    "y" to startY
                ),
                "TR" to mapOf(
                    "x" to startX + pr.intrinsicSize.width.dp,
                    "y" to startY
                ),
                "BL" to mapOf(
                    "x" to startX,
                    "y" to startY + pr.intrinsicSize.height.dp
                ),
                "BR" to mapOf(
                    "x" to startX + pr.intrinsicSize.width.dp,
                    "y" to startY + pr.intrinsicSize.height.dp
                ),
            )
        }

        if (height != null && width != null){
            _height.value = height
            _width.value = width
        }
    }

    @Composable
    override fun render() {

    }

    override fun update(delta: Long) {
        if(!_isGrounded.value && _gravity.value){
            Physics.feelsGravity(this, fallRate = 5.dp)
        }
        setHitbox(offsetTL, offsetTR, offsetBL, offsetBR)
    }



//    GETTERS AND SETTERS

//    Position
    open fun getPosition(): DpOffset {
        return _position.value
    }
    open fun setPosition(position: DpOffset): Unit {
        _position.value = position
    }

//    Height
    open fun getHeight(): Dp {
        return _height.value
    }
    open fun setHeight(height: Dp): Unit {
        _height.value = height
    }

//    Width
    open fun getWidth(): Dp {
        return _width.value
    }
    open fun setWidth(width: Dp): Unit {
        _width.value = width
    }

//    Asset String Value
    open fun getAsset(): String {
        return _asset.value
    }
    open fun setAsset(resource: String): Unit {
        _asset.value = resource
    }

//    Gravity
    open fun getGravity(): Boolean {
        return _gravity.value
    }
    open fun setGravity(isGravityActive: Boolean): Unit {
        _gravity.value = isGravityActive
    }

//    Is Sprite Grounded Value
    open fun getIsGrounded(): Boolean {
        return _isGrounded.value
    }
    open fun setIsGrounded(isGrounded: Boolean): Unit {
        _isGrounded.value = isGrounded
    }

//    Hitbox value
    open fun getHitbox(): Map<String, Map<String, Dp>> {
        return _hitbox.value
    }
    open fun setHitbox(
        offsetTL: List<Dp>,
        offsetTR: List<Dp>,
        offsetBL: List<Dp>,
        offsetBR: List<Dp>
    ): Unit {
        _hitbox.value = mapOf(
            "TL" to mapOf(
                "x" to _position.value.x + offsetTL[0],
                "y" to _position.value.y + offsetTL[1],
            ),
            "TR" to mapOf(
                "x" to (_position.value.x + _width.value) + offsetTR[0],
                "y" to _position.value.y + offsetTR[1],
            ),
            "BL" to mapOf(
                "x" to _position.value.x + offsetBL[0],
                "y" to (_position.value.y + _height.value) + offsetBL[1],
            ),
            "BR" to mapOf(
                "x" to (_position.value.x + _width.value) + offsetBR[0],
                "y" to (_position.value.y + _height.value) + offsetBR[1],
            ),
        )
    }

//    ZIndex Value
    open fun getZIndex(): Int {
        return _zIndex.value
    }

    open fun setZIndex(zIndex: Int): Unit {
        _zIndex.value = zIndex
    }


}