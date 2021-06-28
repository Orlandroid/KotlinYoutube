package view

import controller.YoutubeController
import models.Channel
import models.User

class YoutubeView {


    /** mostar menu principal las actividades que el usuario puedo hacer **/

    fun showAllVideos(channels:ArrayList<Channel>){
        for (channel in channels.iterator())
            println()
    }


    fun succesCreateAccount(){
        println("Account create correcty")
    }

    fun succerCreateChannel(){
        println("Channel create correcly")
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