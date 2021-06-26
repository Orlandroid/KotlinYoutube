package models

import java.util.ArrayList

data class Channel(val name:String,val user: User,val description:String){

    init {
        user.haveAchannel=true
    }

    val videos = ArrayList<Video>()
    val subscribers=ArrayList<User>()
    fun getCountVideos() = videos.size


}

