package Kengine

import Kengine.Interfaces.Input
import Kengine.Interfaces.Renderable
import Kengine.Utils.Physics
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

open class Entity(
    val app: Application,
    private val resource: String = "",
    private val startX: Dp = 0.dp,
    private val startY: Dp = 0.dp,
    private val height: Dp = 0.dp,
    private val width: Dp = 0.dp,
    private var zIndex: MutableState<Int> = mutableStateOf(0),
    private var game: Game? = null
):Renderable, Input {
    private var _position: MutableState<DpOffset> = mutableStateOf(DpOffset(startX, startY))
    private var _asset: MutableState<String> = mutableStateOf(resource)
    private var _gravity: MutableState<Boolean> = mutableStateOf(false)
    private var _isGrounded: MutableState<Boolean> = mutableStateOf(false)
    private var _height: MutableState<Dp> = mutableStateOf(height)
    private var _width: MutableState<Dp> = mutableStateOf(width)
    private var _hitbox: MutableState<Map<String, DpOffset>> = mutableStateOf(mapOf(
        "TL" to DpOffset(startX, startY),
        "TR" to DpOffset(startX + width, startY),
        "BL" to DpOffset(startX, startY + height),
        "BR" to DpOffset(startX + width, startY + height),
    ))
    private var offsetTL: List<Dp> = listOf(0.dp, 0.dp)
    private var offsetTR: List<Dp> = listOf(0.dp, 0.dp)
    var offsetBL: List<Dp> = listOf(0.dp, 0.dp)
    var offsetBR: List<Dp> = listOf(0.dp, 0.dp)
    private var scale: MutableList<Float> = mutableListOf(1F, 1F)
    var delta: Float = 0F
    var velocity: Double = 0.0
    var collided: Boolean = false


    @Composable
    override fun create() {

    }

    @Composable
    override fun render() {

    }

    override fun update(delta: Float) {
        this.delta = delta
        if(!_isGrounded.value && _gravity.value){
            Physics.feelsGravity(this, fallRate = 5.dp)
        }

        _hitbox.value = mapOf(
            "TL" to DpOffset(
                _position.value.x + offsetTL[0],
                _position.value.y + offsetTL[1]
            ),
            "TR" to DpOffset((
                    _position.value.x + _width.value) + offsetTR[0],
                _position.value.y + offsetTR[1]
            ),
            "BL" to DpOffset(
                _position.value.x + offsetBL[0],
                (_position.value.y + _height.value) + offsetBL[1]
            ),
            "BR" to DpOffset((
                    _position.value.x + _width.value) + offsetBR[0],
                (_position.value.y + _height.value) + offsetBR[1]
            ),
        )

        if(!collided){
            setPosition(
                DpOffset(
                    x = this.getPosition().x + velocity.dp,
                    y = this.getPosition().y
                )
            )
        }
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
    open fun getHitbox(): Map<String, DpOffset> {
        return _hitbox.value
    }
    open fun updateHitbox(
        offsetTL: List<Dp> = listOf(0.dp, 0.dp),
        offsetTR: List<Dp> = listOf(0.dp, 0.dp),
        offsetBL: List<Dp> = listOf(0.dp, 0.dp),
        offsetBR: List<Dp> = listOf(0.dp, 0.dp)
    ): Unit {
        this.offsetBL = offsetBL
        this.offsetBR = offsetBR
        this.offsetTL = offsetTL
        this.offsetTR = offsetTR
    }
//    ZIndex Value
    open fun getZIndex(): Int {
        return zIndex.value
    }
    open fun setZIndex(zIndex: Int): Unit {
        this.zIndex.value = zIndex
    }
    //    ZIndex Value
    open fun getScale(): MutableList<Float> {
        return scale
    }
    open fun setScale(scale: List<Float>): Unit {
        this.scale = scale.toMutableList()
    }


//    Listeners
    override fun onKeyEvent(keyEvent: KeyEvent) {
    }

    override fun onMouseMove(pointerEvent: PointerEvent) {
    }

    override fun onMouseEnter(pointerEvent: PointerEvent) {
    }


}