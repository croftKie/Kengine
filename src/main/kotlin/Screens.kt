import Kengine.Application
import Kengine.Screen
import Kengine.Utils.Collision
import Kengine.Utils.Enums
import Kengine.Utils.Keys
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
import androidx.compose.ui.unit.dp


class MenuScreen(app: Application): Screen(app) {

    @Composable
    override fun create() {
        super.create()
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
                            app.currentScreen.value = app.screens.values.toList()[1]
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
}
class GameScreen(app: Application): Screen(
    app,
    entities = mutableMapOf(
        "background" to Background(app),
        "bookshelf" to BookShelf(app),
        "bed" to Bed(app),
        "player" to MyEnt2(app),
        "floor" to Floor(app)
    )
){
    private val player = this.getEntity("player")
    private val floor = this.getEntity("floor")
    private val bookShelf = this.getEntity("bookshelf")
    private val bed = this.getEntity("bed")

    @Composable
    override fun create() {
        super.create()
    }

    @Composable
    override fun render() {
        super.render()
    }

    override fun update(delta: Float) {
        super.update(delta)

        Collision.overlaps(player, floor){
            player.setIsGrounded(true)
        }
        Collision.overlaps(player, bookShelf){
            println("You should go to sleep, Kenji!")
        }

    }

    override fun onKeyEvent(keyEvent: KeyEvent) {
        super.onKeyEvent(keyEvent)
        Keys.keyDown(keyEvent, Key.Spacebar){
            if(Collision.overlaps(player, bed)){
                app.currentScreen.value = app.screens["menu"]
            }
        }
    }
}

