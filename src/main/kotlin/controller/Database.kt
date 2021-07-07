package controller

import models.Channel
import models.User
import models.Video
import models.Youtube

class Database {

    init {
        addChannelForDefault()
    }

    /**imformacion inicial que tendra Youtube**/

    private fun addChannelForDefault(){
        val user= User("android@gmail.com","admin1234")
        val android= Channel("Android",user,"channel about android")
        val channelC=ChannelController(android)
        Youtube.channels.add(android)
        Youtube.users.add(user)

        val video= Video("¿Que es kotlin?",5,android)
        val video2= Video("Fundamentos de programacion",10,android)
        val video3= Video("Programacion Orientada a objetos",20,android)
        val video4= Video("Programacion funcional",18,android)
        val video5= Video("Programacion asincrona",8,android)

        android.videos.add(video)
        android.videos.add(video2)
        android.videos.add(video3)
        android.videos.add(video4)
        android.videos.add(video5)


        channelC.showAllVideos()
    }

}