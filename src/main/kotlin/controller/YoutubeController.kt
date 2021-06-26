package controller

import models.Channel
import models.Youtube
import view.YoutubeView
import java.util.ArrayList

class YoutubeController(private val youtube: Youtube,private val youtubeView: YoutubeView) {


    /**channel what youtube have for default*/
    fun channelForDefault(){

    }


    fun seeTermAndLicence(){

    }

    private fun addChannelsToYoutube(channel: Channel){
        youtube.canales.add(channel)
    }

    fun initYoutube(){
        youtubeView.initYoutube()
    }





}