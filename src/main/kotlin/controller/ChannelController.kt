package controller

import models.Channel
import models.User
import models.Video

class ChannelController(private val channel: Channel){



    fun addSubscriber(user:User)=channel.subscribers.add(user)

    fun removeSubScriber(user: User)=channel.subscribers.remove(user)

    fun getAllVideo()=channel.videos

    private fun showCharacter(character:Char='*', size:Int=20){
        for (x in 0..size)
            print(character)

    }


    fun searcAvideo(searching:String){
        for (video in channel.videos){
            if(video.name==searching)
                showVideo(video)
        }
    }

    /***recibe one video and show ther properies*/
    private fun showVideo(video:Video){
        println("""
            
            channel:${video.channel.name}
            name:${video.name}
            duration:${video.duration}
        """.trimIndent())
    }

    fun watchAVide(video: Video){
        println("Waching ${video.name}")
        Thread.sleep(video.duration.toLong())
        /**rise the number of visitas**/
        video.visits+=1
    }

    fun showAllVideos(){
        println("All videos from ${channel.name}")
        for (x in channel.videos.iterator())
            showVideo(x)
    }

    fun showTotalOfSubscriber(){
        println("""
            The tottal of subcriber of the channel
            ${channel.name} are ${channel.subscribers.size}
        """.trimIndent())
    }

    fun sendNotification(){

    }

    fun upVideo(video:Video){
        channel.videos.add(video)
        println("The vide was upload correcly")
    }

    fun removeOneVideo(video: Video){
        channel.videos.remove(video)
        println("The vide was delete correcly")
    }



}