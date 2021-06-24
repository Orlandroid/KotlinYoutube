package view

import models.Channel

class YoutubeView {

    fun showAllVideos(channels:ArrayList<Channel>){
        for (channel in channels.iterator())
            println(channel)
    }




}