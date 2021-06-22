
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    println("Menu principal")

    GlobalScope.launch {
        print("Loading....")
        delay(1000)
    }
}