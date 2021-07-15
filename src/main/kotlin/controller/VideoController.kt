package controller

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import models.User
import models.Video
import state.Quality
import state.Speed

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


    private fun donwload() {
        var percentage = 0
        GlobalScope.launch(Dispatchers.Default) {
            while (percentage < 100) {
                println("Descargando video: $percentage%")
                delay(1000)
                percentage += 10
            }
            println("Video descargado exitosamente")
        }
    }

    /**This is the reproductor de video*/
    /**simulation of the user is waching one video*/
    fun watchAVideo(video: Video, user: User? = null) {
        println("Waching ${video.name}")
        Thread.sleep(video.duration.toLong())
        /** si se tiene iniciada una session agregademos el video a lso videos vistos por el usuario**/
        user?.historialOfWatchVideos?.add(video)
        /**rise the number of visitas**/
        video.visits += 1
        do {
            println("1: dar like")
            println("2: Cambiar la velocidad de video")
            println("3: cambiar calidad")
            println("4: Descativar subtitulos")
            println("5: Activar subtitulos")
            println("6: Descargar video")
            println("7: comentar video")
            println("8: subcribirse al canal")
            println("9: desubcribirse al canal")
            println("10: imformacion video")
            println("0: volver al menu principal")
            val opcion = readLine()?.toInt()
            when (opcion) {
                1 -> {
                    if (user != null) {
                        user.videosWhaLike.add(video)
                        println("Añadido a videos que me gustan")
                    } else
                        println("Debes de iniciar sessio para ver los videos que te gustan")
                }
                2 -> {
                    changeSpeed()
                }
                3 -> {
                    changevideoQuality()
                }
                4 -> video.enableSubtitle = false
                5 -> video.enableSubtitle = true
                6 -> donwload()
                7 -> println("Comentando el video")
                8 -> {
                    if (user != null) {
                        user.ChannelSubscribers.add(video.channel)
                        println("Te has subscripto a este canal")
                    } else
                        println("Debes de iniciar session para subcribirte al canal")
                }
                9 -> {
                    if (user != null) {
                        println("¿Anular tu subcripcion a ${video.channel}?")
                        println("1: YES")
                        println("2: CANCELAR")
                        when (readLine()?.toInt()) {
                            1 -> {
                                user.ChannelSubscribers.remove(video.channel)
                                println("Te has desubcripto del canal")
                            }
                        }
                    } else
                        println("Debes de iniciar session para desuscribirte de una canal")
                }
                10 -> {
                    infoVideo()
                }
            }
        } while (opcion != 0)
    }

    private fun infoVideo(){
        println("""
            Nombre: ${video.name}
            Duracion: ${video.duration} minutos
            Canal: ${video.channel.name}
            visitas: ${video.visits}
            calidad: ${video.quality}
            subtitulos ${video.enableSubtitle}
            
        """.trimIndent())
    }

    fun showVideo(video: Video) {
        println(
            """
            channel:${video.channel.name}
            name:${video.name}
            duration:${video.duration}
        
        """.trimIndent()
        )
    }


    private fun changeSpeed(){
        println("Selecciona la velocidad del video")
        println("1: 0.25")
        println("2: 0.5")
        println("3: 0.75")
        println("4: NORMAl")
        println("5: 1.25")
        println("6: 1.5")
        println("7: 1.75")
        println("8: 2")
        when(readLine()?.toInt()){
            1 -> video.speed=Speed.S0_25X
            2 -> video.speed=Speed.S0_5X
            3 -> video.speed=Speed.S0_75X
            4 -> video.speed=Speed.NORMAL
            5 -> video.speed=Speed.S1_25X
            6 -> video.speed=Speed.S1_5X
            7 -> video.speed=Speed.S1_75X
            8 -> video.speed=Speed.S2x
        }

    }

    private fun changevideoQuality(){
        println("Selecciona la calida del video")
        println("1: 140p")
        println("2: 240p")
        println("3: 360p")
        println("4: 480p")
        println("5: 720p")
        println("6: 1080p")
        when(readLine()?.toInt()){
            1 -> video.quality=Quality.Q140
            2 -> video.quality=Quality.Q240
            3 -> video.quality=Quality.Q360
            4 -> video.quality=Quality.Q480
            5 -> video.quality=Quality.Q720
            6 -> video.quality=Quality.Q1080
        }
    }



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