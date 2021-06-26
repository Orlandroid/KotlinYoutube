package view

import models.Video

class ChannelView {

    fun showVideo(video:Video){
        println("""
                    ${video.name}
                    Duration:${video.duration}
                    
        """.trimIndent())
    }

    /** make a function what return the total of videos what have el channel*/
    fun countVideos(total:Int){

    }

}