package controller

import constants.Quality
import models.Video

class VideoController(val video: Video) {

    /**
     * cambiarVelocidadVideo()
     * cambiarCalidadVideo()
     * cambiarIdiomasSubtitulos()
     * desactivarSubtitulos()
     * activarSubtitulos()
     * descargarVideo()
     *
     * **/


    /** 140 240 360 480 720 1080
     * */
    fun changeSpeepVideo(){
        video.quality=Quality.Q140
    }





}