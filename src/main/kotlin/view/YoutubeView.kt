package view

import models.Channel

class YoutubeView {


    /** mostar menu principal las actividades que el usuario puedo hacer **/

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