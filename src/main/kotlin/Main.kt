
import controller.UserController
import controller.VideoController
import models.User
import models.Video
import view.UserView
import view.VideoView

fun main() {
    video()
}

fun video(){
    val videoView=VideoView()
    val video=Video("clean code",5)
    val videoController=VideoController(video,videoView)
    videoController.watchAVideo()
}

fun user(){
    val userview =UserView()
    userview.enterUser()
    val usuario= readLine().toString()
    userview.enterPassword()
    val password= readLine().toString()
    val user=User(usuario,password)

    val userController=UserController(user,userview)
    userController.iniciarSession()
}
