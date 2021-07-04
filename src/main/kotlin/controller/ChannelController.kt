package controller

import models.Channel
import models.User
import models.Video

class ChannelController(private val channel: Channel){



    fun addSubscriber(user:User)=channel.subscribers.add(user)

    fun removeSubscriber(user: User)=channel.subscribers.remove(user)

    fun getAllVideo()=channel.videos

    private fun showCharacter(character:Char='*', size:Int=20){
        for (x in 0..size)
            print(character)
    }


    private fun sendNotificationAUserSubscribeAvideo(){
        /**implement one tipe of listener that when
         * up one video send one notifications to all users*/
    }

    private fun showVideo(video:Video){
        println("""         
            channel:${video.channel.name}
            name:${video.name}
            duration:${video.duration}
        """.trimIndent())
    }


    fun showAllVideos(){
        println("All videos from ${channel.name}")
        channel.videos.forEach {
            showVideo(it)
        }
    }

    fun showTotalOfSubscriber(){
        println("""
            The total of subcriber of the channel
            ${channel.name} are ${channel.subscribers.size}
        """.trimIndent())
    }

    fun sendNotification(){

    }

    fun upVideo(video:Video,show:Boolean=false){
        channel.videos.add(video)
        if(show)
        println("The video was upload correcly")
    }

    fun removeOneVideo(video: Video,show:Boolean=false){
        channel.videos.remove(video)
        if (show)
        println("The video was delete correcly")
    }


}