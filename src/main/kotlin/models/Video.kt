package models

import constants.Quality

data class Video(val name:String,val duration:Int,val channel:Channel){
    var visits=0
    var speed=1
    var quality:Quality=Quality.Q140
    var subtitleLanguaje="es"
    var enableSubtitle=false
}
