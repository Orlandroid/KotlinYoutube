package controller

import models.Channel
import models.User
import models.Video
import view.ChannelView

class ChannelController(private val channel: Channel, private val channelView:ChannelView){


    fun showAllVideos(){
        println("All videos from ${channel.name}")
        for (x in channel.videos.iterator())
            channelView.showVideo(x)
    }

    fun addSubscriber(user:User)=channel.subscribers.add(user)

    fun removeSubScriber(user: User)=channel.subscribers.remove(user)

    fun upOneVideo(video:Video){
        channel.videos.add(video)
    }

    fun removeOneVideo( video: Video){
        channel.videos.remove(video)
    }



}