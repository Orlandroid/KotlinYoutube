package controller

import models.Channel
import models.Video


class ChannelController(private val channel: Channel){

    private fun sendNotificationAUserSubscribeAvideo(){
        /**implement one tipe of listener what when
         * up one video send one notifications to all users*/
    }


    /***Recibe un video por parametro y muestra sun propiedades*/
    private fun showVideo(video:Video){
        println("""         
            channel:${video.channel.name}
            name:${video.name}
            duration:${video.duration}
        """.trimIndent())
    }


    /**muestra todos los videos del canal
     * y por cada canal llama a la funcion showVideo(video:Video)*/
    fun showAllVideos(){
        println("All videos from ${channel.name}")
        channel.videos.forEach {
            showVideo(it)
        }
    }

    /**  Muestra el nombre del canal y el total de subcriptores**/
    fun showTotalOfSubscriber(){
        println("""
            The tottal of subcriber of the channel
            ${channel.name} are ${channel.subscribers.size}
        """.trimIndent())
    }

    /**recibe un video por parametro y lo sube al canal*/
    fun upVideo(video:Video,show:Boolean=false){
        channel.videos.add(video)
        if(show)
        println("The vide was upload correcly")
    }

/**Recibe un canal por parametro y lo elima de los videos del usuario*/
    fun removeOneVideo(video: Video,show:Boolean=false){
        channel.videos.remove(video)
        if (show)
        println("The vide was delete correcly")
    }


}