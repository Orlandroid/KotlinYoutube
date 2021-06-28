
import controller.ChannelController
import controller.UserController
import controller.YoutubeController
import models.Channel
import models.User
import models.Video
import models.Youtube
import view.ChannelView
import view.UserView
import view.YoutubeView

fun main() {
    val youtube=Youtube()
    val youtubeView=YoutubeView()
    val youtubeController=YoutubeController(youtube,youtubeView)
    youtubeController.initYoutube()
    val user=User("android@gmail.com","admin1234")
    val userView=UserView()
    val userController=UserController(user,userView,youtubeController)
    userController.isOnline()
    userController.signIn()
    youtubeController.haveAccountUser(user)


}

fun video(){

}

fun userCreateAchannel(){
    val user=User("orlando","admin1234")
    val userView=UserView()
    userView.haveAChanel(user)
    val channel = Channel("Android",user,"Cannal dedicado acontenido sobre android")
    val channelView=ChannelView()
    userView.haveAChanel(user)
    val channelControl = ChannelController(channel,channelView)
    val video=Video("Android basic",5,channel)
    val vide2=Video("Fundamentals kotlin",5,channel)
    channelControl.upOneVideo(video)
    channelControl.upOneVideo(vide2)
    channelControl.showAllVideos()
    channelControl.removeOneVideo(video)
    channelControl.showAllVideos()
}

fun user(){
    val userview =UserView()
    userview.enterUser()
    val usuario= readLine().toString()
    userview.enterPassword()
    val password= readLine().toString()
    val user=User(usuario,password)

    //val userController=UserController(user,userview,)
    //userController.logIn()
}
