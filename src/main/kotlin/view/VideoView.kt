package view

import java.util.*
import kotlin.concurrent.schedule

class VideoView {

    fun playAVideo(name:String,duration:Int){
        Timer("SettingUp", false).schedule((duration*1000).toLong()) {
            println("Reproduciendo el video $name")
        }

    }

}