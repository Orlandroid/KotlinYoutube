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

        val userLinux=User("linux@gmail.com","linuxPenguin")
        val linux=Channel("Linux tips",userLinux,"Tutorials about android")
        val channelCL = ChannelController(linux)

        Youtube.channels.add(android)
        Youtube.users.add(user)

        Youtube.channels.add(linux)
        Youtube.users.add(userLinux)

        val video= Video("¿Que es kotlin?",5,android)
        val video2= Video("Fundamentos de programacion",10,android)
        val video3= Video("Programacion Orientada a objetos",20,android)
        val video4= Video("Programacion funcional",18,android)
        val video5= Video("Programacion asincrona",8,android)

        val video6 = Video("¿Qu es linux?",19,linux)

        android.videos.add(video)
        android.videos.add(video2)
        android.videos.add(video3)
        android.videos.add(video4)
        android.videos.add(video5)

        linux.videos.add(video6)

        channelC.showAllVideos()
        channelCL.showAllVideos()
    }


}