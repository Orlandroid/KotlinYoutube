package controller

import models.Channel
import models.User
import models.Video


class ChannelController(private val channel: Channel) {

    private fun sendNotificationAUserSubscribeAvideo() {
        /**implement one tipe of listener that when
         * up one video send one notifications to all users*/
    }

    private fun menuChanel(){
        val registeredUser: User? = null
        println(registeredUser)
        val paginaPrincipal = "PáginaPrincipal"
        val videos = "Videos"
        val listaDeReproduccion = "Lista de reproducción"
        val canales = "Canales"
        val debates = "Debates"
        val acercaDe = "Acerca de"
        val personalizarCanal = "Personalizar Canal"
        val administrarVideos = "Administrar Videos"
        val arrayMenu : ArrayList<String> = arrayListOf<String>()
        arrayMenu.add(paginaPrincipal)
        arrayMenu.add(videos)
        arrayMenu.add(listaDeReproduccion)
        arrayMenu.add(canales)
        arrayMenu.add(debates)
        arrayMenu.add(acercaDe)
        arrayMenu.add(personalizarCanal)
        arrayMenu.add(administrarVideos)
        print(arrayMenu)
        val opcion = readLine() ?.toInt()
        println("Opcion $opcion")
    }


    /***Recibe un video por parametro y muestra sun propiedades*/
    private fun showVideo(video: Video) {
        println(
            """         
            channel:${video.channel.name}
            name:${video.name}
            duration:${video.duration}
        """.trimIndent()
        )
    }


    /**muestra todos los videos del canal
     * y por cada canal llama a la funcion showVideo(video:Video)*/
    fun showAllVideos() {
        println("All videos from ${channel.name}")
        channel.videos.forEach {
            showVideo(it)
        }
    }

    /**  Muestra el nombre del canal y el total de subcriptores**/
    fun showTotalOfSubscriber(){
        println("""
        The total of subcriber of the channel
        ${channel.name} are ${channel.subscribers.size}
    """.trimIndent())
        val nombreDelCanal = "Nombre del Canal "
        val suscriptoresActuales =0
        val suscriptoresNuevos =0
        val totalDeSuscriptores = suscriptoresActuales + suscriptoresNuevos
        if (totalDeSuscriptores > 0){
            println("$nombreDelCanal$totalDeSuscriptores suscriptores")
        } else {
            print("$nombreDelCanal$totalDeSuscriptores sin suscriptores")
        }
    }

    /**Muestra los canales a los que está suscrito*/
    fun canalesAlosQueEstoySuscrito() {
        val canalAlQueEstoySuscrito = "Suscripciones"
        val numeroDeCanales = 10
        val actividadEnLosCanales = arrayListOf<String>(
            "Todo",
            "Hoy",
            "Continua mirando",
            "Sin mirar",
            "En tiempo real",
            "Publicaciones"
        )
        
        if (numeroDeCanales > 0) {
            println("$canalAlQueEstoySuscrito $numeroDeCanales $actividadEnLosCanales")
        } else {
            print("$numeroDeCanales sin suscripciones")
        }
    }


    /**recibe un video por parametro y lo sube al canal*/
    var upload: Boolean = false


    fun upVideo(video: Video) {
        if (upload == true) {//empieza con upload == false
            println("Write the name of your video")
            val name = readLine().toString()
            println("The video was uploaded correcly")
            channel.videos.add(video)
        } else {
            println("Something wen`t wrong, try again")
        }
    }

    /**Recibe un canal por parametro y lo elimina de los videos del usuario*/

    fun removeOneVideo(video: Video) {
        if (upload == true) {
            channel.videos.remove(video)
            println("The video was deleted correcly")
            //agregar una de seguridad para volver a preguntar a usuario si está seguro
        } else {
            println("Video still in your channel")
        }
    }

    val subscribers: Int
        get() {
            return channel.subscribers.size
        }
}





