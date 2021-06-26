package view

import models.Channel

class YoutubeView {


    fun showAllVideos(channels:ArrayList<Channel>){
        for (channel in channels.iterator())
            println()
    }

    fun initYoutube(){
        var titleYoutube ="Loading"
        for (x in 1..10){
            Thread.sleep(1000)
            println(titleYoutube)
            titleYoutube+="."
        }
    }




}