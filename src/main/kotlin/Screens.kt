import Engine.Area
import Engine.Entity
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MenuScreen(private val game: MyGame): Screen() {

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

    @Composable
    override fun create() {

    }

    override fun update(delta: Long) {

    }

    override fun onKeyEvent(keyEvent: KeyEvent): Boolean {
        return super.onKeyEvent(keyEvent)
    }

}
class GameScreen(val game: MyGame): Screen(){

    private val playArea = PlayArea()

    @Composable
    override fun create() {
        playArea.create()
    }

    @Composable
    override fun render() {
        playArea.render()
    }

    override fun update(delta: Long) {
        playArea.update(delta)
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
}

class MyEnt(): Entity(
    resource = "mon.png",
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
}

class MyEnt2(): Entity(
    resource = "mon.png",
    startX = 40.dp,
    startY = 10.dp
){
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
        this.offsetBL = listOf(0.dp, (-40).dp)
        this.offsetBR = listOf(0.dp, (-40).dp)
    }

    override fun update(delta: Long) {
        super.update(delta)
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
}