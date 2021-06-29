package controller

import models.Channel
import models.User
import models.Video
import models.Youtube
import java.util.ArrayList

class YoutubeController(private val youtube: Youtube) {


    init {
        addChannelForDefault()
    }

    fun getAllUserFromYoutube():ArrayList<User> = youtube.users

    fun getAllChannelFromYoutube():ArrayList<Channel> = youtube.channels

    fun getAllVideosFromYoutube(){
       youtube.channels
    }

    fun haveAccountUser(user:User):Boolean =  youtube.users.contains(user)


    private fun addChannelForDefault(){
        val user=User("android@gmail.com","admin1234")
        val android=Channel("Android",user,"channel about android")
        val channelC=ChannelController(android)
        addChannelToYoutube(android)

        val video=Video("¿Que es kotlin?",5,android)
        val video2=Video("Fundamentos de programacion",10,android)
        val video3=Video("Programacion Orientada a objetos",20,android)
        val video4=Video("Programacion funcional",18,android)

        channelC.upVideo(video)
        channelC.upVideo(video2)
        channelC.upVideo(video3)
        channelC.upVideo(video4)

        channelC.showAllVideos()
    }


    fun searchAvideo(name:String){
        for (x in youtube.channels.iterator()){
            /** ArrayList<Video> get all videos from each channel in youtube*/
            val videos=x.videos
            for (y in videos.iterator())
                if (y.name==name)
                    println("llamar a una funtion para que imprima el video")
        }
    }



    fun showAllVideos(channels:ArrayList<Channel>){
        for (channel in channels.iterator())
            println()
    }


    private fun showCharacter(character:Char='*', size:Int=10){
        for (x in 0..size)
            println(character)
    }

    private fun printChannel(channel: Channel){
        println(channel.name)
    }

    fun showAllChannelsOfYoutube(channels: ArrayList<Channel>){
        showCharacter()
        for (x in channels.iterator())
            printChannel(x)
        showCharacter()
    }


    fun addUserToYoutube(user:User){
        youtube.users.add(user)
        println("account create correcly")
    }

    private fun addChannelToYoutube(channel: Channel){
        youtube.channels.add(channel)
        println("account create correcly")
    }


    fun initYoutube(){
        var titleYoutube ="Loading"
        for (x in 1..10){
            Thread.sleep(1000)
            println(titleYoutube)
            titleYoutube+="."
        }

    }


    fun seeTermsAndLicence(){
        println("You aggre")
    }

}