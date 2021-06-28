package controller

import models.Channel
import models.User
import models.Youtube
import view.YoutubeView
import java.util.ArrayList

class YoutubeController(private val youtube: Youtube,private val youtubeView: YoutubeView) {


    fun getAllUserFromYoutube():ArrayList<User>{
        return youtube.usuarios
    }

    /**param User
     * retunr Boolean*/
    fun haveAccountUser(user:User):Boolean =  youtube.usuarios.contains(user)



    fun addUserToYoutube(user:User){
        youtube.usuarios.add(user)
        youtubeView.succesCreateAccount()
    }

    fun addChannelToYoutube(channel: Channel){
        youtube.canales.add(channel)
        youtubeView.succerCreateChannel()
    }


    fun seeTermsAndLicence(){

    }

    fun initYoutube(){
        youtubeView.initYoutube()
    }





}