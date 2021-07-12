package controller

import models.Video

class VideoController(private val video: Video) {

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


    /**Cambiar Velocidad de Video*/
    fun speedBack () {
        println("Selecciona la velocidad de reproducción del video:")
        println("1: 0.25x")
        println("2: 0.75x")
        println("3: NORMAL")
        println("4: 1.25x")
        println("5: 1.5x")
        println("6: 2x")

        val SpeedBack = readLine()?.toInt()

        if(SpeedBack == 1) {
            println("Velocidad actual de reproducción del Video es 0.25x")
        }
        if(SpeedBack == 2) {
            println("Velocidad actual de reproducción del Video es 0.75x")
        }
        if(SpeedBack == 3) {
            println("Velocidad actual de reproducción del Video es NORMAL")
        }
        if(SpeedBack == 4) {
            println("Velocidad actual de reproducción del Video es 1.25x")
        }
        if(SpeedBack == 5) {
            println("Velocidad actual de reproducción del Video es 1.5x")
        }
        if(SpeedBack == 6) {
            println("Velocidad actual de reproducción del Video es 2x")
        }
    }


    /**Cambiar Calidad de Video*/

    fun videoQuality () {
        println("Selecciona la calidad de reproducción del video:")
        println("1: 144p")
        println("2: 240p")
        println("3: 360p")
        println("4: 480p")
        println("5: 720p")
        println("6: 1080p")

        val videoQuality = readLine()?.toInt()
        if(videoQuality == 1) {
            println("Velocidad actual de reproducción del Video es 0.25x")
        }
        if(videoQuality == 2) {
            println("Velocidad actual de reproducción del Video es 0.75x")
        }
        if(videoQuality == 3) {
            println("Velocidad actual de reproducción del Video es NORMAL")
        }
        if(videoQuality == 4) {
            println("Velocidad actual de reproducción del Video es 1.25x")
        }
        if(videoQuality == 5) {
            println("Velocidad actual de reproducción del Video es 1.5x")
        }
        if(videoQuality == 6) {
            println("Velocidad actual de reproducción del Video es 2x")
        }
    }

    /**Activar y desactivar subtitulos*/

    var captionsOn = false
    fun activateCaptions (){
        captionsOn = true
    }
    fun captionsOff () {
        captionsOn = false
    }
    fun getcaptions(){
        val captionsMode = if(captionsOn) "Subtitulos activados" else "Subtitulos desactivados"
        println("Los subtitulos están $captionsMode")
    }

    /**Cambiar idioma de subtitulos*/
    fun captionsLanguage () {
        println ("Selecciona el idioma de subtitulos")
        println ("1: Spanish")
        println ("2: English")
        println ("3: Portuguese")

        val captionsLanguage = readLine()?.toInt()

        if(captionsLanguage == 1) {
            println("Subtitulos en español activados")
        }
        if(captionsLanguage == 2) {
            println("Subtitulos en inglés activados")
        }
        if(captionsLanguage == 3) {
            println("Subtitulos en portugués activados")
        }

    }
}