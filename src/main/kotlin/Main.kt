import controller.YoutubeController
import models.Youtube

fun main() {
    val youtube= Youtube()
    val cYoutubeController=YoutubeController(youtube)
}

fun video(){

}


fun userCreateAchannel(){

}

fun user(){

}

fun showCharacter(character:Char='*',size:Int=10){
    for (x in 0..size)
        print(character)
}