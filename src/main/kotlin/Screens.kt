import Engine.Area
import Engine.Entity
import Engine.Interfaces.MovementXY
import Engine.Prefabs.Rect
import Engine.Prefabs.Sprite
import Engine.Screen
import Engine.Utils.Collision
import Engine.Utils.Enums
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MenuScreen(game: MyGame): Screen(
    game
) {
    @Composable
    override fun create() {

    }
    @Composable
    override fun render() {
        Box(modifier = Modifier.fillMaxSize()){
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Row(modifier = Modifier.padding(16.dp).height(100.dp)) {
                    Image(painter = painterResource("KenginE.png"), "")
                }
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Image(painter = painterResource("Kenji.png"), "")
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(0.5F),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(onClick = {
                            game.currentGameState.value = Enums.GameState.PLAYING
                        }){
                            Text("Start")
                        }
                        Button(onClick = {}){
                            Text("Quit")
                        }
                    }
                }
            }
        }
    }

    override fun update(delta: Long) {

    }

    override fun onKeyEvent(keyEvent: KeyEvent) {

    }

    override fun onMouseMove(pointerEvent: PointerEvent) {
    }

    override fun onMouseEnter(pointerEvent: PointerEvent) {
    }

}
class GameScreen(
    game: MyGame
): Screen(
    game,
    areas = mutableListOf(
        PlayArea()
    ),
    currentArea = mutableStateOf(PlayArea())
){
    @Composable
    override fun create() {
        super.create()
    }
    @Composable
    override fun render() {
        super.render()
    }

    override fun update(delta: Long) {
        super.update(delta)
    }

    override fun onKeyEvent(keyEvent: KeyEvent) {
        currentArea?.value?.onKeyEvent(keyEvent)
    }

    override fun onMouseMove(pointerEvent: PointerEvent) {
    }

    override fun onMouseEnter(pointerEvent: PointerEvent) {
    }
}

class PlayArea(
): Area(
    entities = mutableListOf(
    MyEnt(),
    MyEnt2(),
    Floor()
    )
){

    @Composable
    override fun create() {
        super.create()
    }

    @Composable
    override fun render() {
        super.render()
    }

    override fun update(delta: Long) {
        super.update(delta)
        Collision.overlaps(entities[0], entities[2]){
            entities[0].setIsGrounded(true)
        }
        Collision.overlaps(entities[1], entities[2]){
            entities[1].setIsGrounded(true)
        }
    }

    override fun onKeyEvent(keyEvent: KeyEvent) {
        entities[1].onKeyEvent(keyEvent)
    }

    override fun onMouseMove(pointerEvent: PointerEvent) {
    }

    override fun onMouseEnter(pointerEvent: PointerEvent) {
    }
}

class MyEnt(): Entity(
    resource = "Kenji.png",
    startX = 10.dp,
    startY = 10.dp
){
    @Composable
    override fun create() {
        super.create()
        this.setGravity(true)
        this.setZIndex(1)
    }

    @Composable
    override fun render() {
        super.render()
        Sprite.draw(this)
    }

    override fun update(delta: Long) {
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

class MyEnt2(): Entity(
    resource = "Kenji.png",
    startX = 40.dp,
    startY = 10.dp
), MovementXY{
    @Composable
    override fun create() {
        super.create()
        this.setGravity(true)
        this.setZIndex(2)
    }

    @Composable
    override fun render() {
        super.render()
        Sprite.draw(this)
        this.offsetBL = listOf(0.dp, (-25).dp)
        this.offsetBR = listOf(0.dp, (-25).dp)
    }

    override fun update(delta: Long) {
        super.update(delta)
    }

    override fun onKeyEvent(keyEvent: KeyEvent) {
        keyDownLeft(keyEvent, Key.A){
            this.setPosition(DpOffset(
                x = this.getPosition().x - 8.dp,
                y = this.getPosition().y
            ))
        }
        keyDownRight(keyEvent, Key.D){
            this.setPosition(DpOffset(
                x = this.getPosition().x + 8.dp,
                y = this.getPosition().y
            ))
        }
    }

    override fun onMouseMove(pointerEvent: PointerEvent) {
    }

    override fun onMouseEnter(pointerEvent: PointerEvent) {
    }

}

class Floor(): Entity(
    startX = 0.dp,
    startY = 400.dp
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

    override fun update(delta: Long) {
        super.update(delta)
    }

    override fun onKeyEvent(keyEvent: KeyEvent) {
    }

    override fun onMouseMove(pointerEvent: PointerEvent) {
    }

    override fun onMouseEnter(pointerEvent: PointerEvent) {
    }
}