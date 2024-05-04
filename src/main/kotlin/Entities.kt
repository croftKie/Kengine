import Kengine.Application
import Kengine.Entity
import Kengine.Prefabs.Backdrop
import Kengine.Prefabs.Rect
import Kengine.Prefabs.Sprite
import Kengine.Utils.Keys
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

class BookShelf(app: Application): Entity(
    app,
    resource = "Bookshelf.png",
    startX = 460.dp,
    startY = 380.dp,
    height = 256.dp,
    width = 128.dp,
    zIndex = mutableStateOf(1)
){
    @Composable
    override fun create() {
        super.create()
        this.setGravity(false)
    }

    @Composable
    override fun render() {
        super.render()
        Sprite.draw(this)
    }

    override fun update(delta: Float) {
        super.update(delta)
    }

    override fun onKeyEvent(keyEvent: KeyEvent) {
        super.onKeyEvent(keyEvent)
    }

    override fun onMouseMove(pointerEvent: PointerEvent) {
    }

    override fun onMouseEnter(pointerEvent: PointerEvent) {
    }
}
class Bed(app: Application): Entity(
    app,
    resource = "Bed.png",
    startX = (-40).dp,
    startY = 500.dp,
    height = 128.dp,
    width = 256.dp,
    zIndex = mutableStateOf(2)
){
    @Composable
    override fun create() {
        super.create()
        this.setGravity(false)
    }

    @Composable
    override fun render() {
        super.render()
        Sprite.draw(this)
    }

    override fun update(delta: Float) {
        super.update(delta)
    }

    override fun onKeyEvent(keyEvent: KeyEvent) {
        super.onKeyEvent(keyEvent)
    }

    override fun onMouseMove(pointerEvent: PointerEvent) {
    }

    override fun onMouseEnter(pointerEvent: PointerEvent) {
    }
}

class MyEnt2(
    app: Application
): Entity(
    app,
    resource = "Kenji.png",
    startX = 250.dp,
    startY = 200.dp,
    height = 96.dp,
    width = 96.dp,
    zIndex = mutableStateOf(1),
) {
    init{
        this.setGravity(true)
    }
    @Composable
    override fun create() {
        super.create()
    }
    @Composable
    override fun render() {
        super.render()
        Sprite.draw(this)
    }
    override fun update(delta: Float) {
        super.update(delta)
    }

    override fun onKeyEvent(keyEvent: KeyEvent) {
        Keys.keyDown(keyEvent, Key.A){
            this.velocity = -(60 * this.delta.toDouble())
            this.setScale(listOf(1F, 1F))
        }
        Keys.keyDown(keyEvent, Key.D){
            this.velocity = 60 * this.delta.toDouble()
            this.setScale(listOf(-1F, 1F))
        }
        Keys.keyUp(keyEvent, Key.D){
            this.collided = false
            this.velocity = 0.0
        }
        Keys.keyUp(keyEvent, Key.A){
            this.collided = false
            this.velocity = 0.0
        }

    }

    override fun onMouseMove(pointerEvent: PointerEvent) {
    }

    override fun onMouseEnter(pointerEvent: PointerEvent) {
    }

}

class Floor(
    app: Application
): Entity(
    app,
    startX = 0.dp,
    startY = 620.dp,
    height = 100.dp,
    width = 500.dp,
    zIndex = mutableStateOf(1)
){
    @Composable
    override fun create() {
        super.create()
    }

    @Composable
    override fun render() {
        super.render()
        Rect.draw(this)
    }

    override fun update(delta: Float) {
        super.update(delta)
    }

    override fun onKeyEvent(keyEvent: KeyEvent) {
    }

    override fun onMouseMove(pointerEvent: PointerEvent) {
    }

    override fun onMouseEnter(pointerEvent: PointerEvent) {
    }
}

class Background(
    app: Application
): Entity(
    app,
    startY = 0.dp,
    startX = 0.dp,
    zIndex = mutableStateOf(0)
){
    @Composable
    override fun create() {
        super.create()
    }

    @Composable
    override fun render() {
        super.render()
        Backdrop.draw(this, app)
    }

    override fun update(delta: Float) {
        super.update(delta)
    }
}