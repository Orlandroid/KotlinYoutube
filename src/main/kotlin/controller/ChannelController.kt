package controller


import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import models.Channel
import models.Video


class ChannelController(private val channel: Channel) {

    private fun sendNotificationAUserSubscribeAvideo() {
        /**implement one tipe of listener that when
         * up one video send one notifications to all users*/
    }


    fun myChannel() {
        if (channel.user.haveAchannel) {
            try {
                do {
                    println("Opciones de tu canal: ")
                    println("1: Subir video")
                    println("2: Mostrar número de suscriptores")
                    println("3: Eliminar video")
                    println("4: Info canal")
                    println("5: Mostrar todos los videos")
                    println("0: Salir de este menú")

                    val option: Int? = readLine()?.toInt()
                    when (option) {
                        1 -> {
                            val video = createVideo()
                            if (video != null) {
                                upVideo(video)
                            } else {
                                println("No se pudo subir el video")
                            }
                        }
                        2 -> {
                            println("Total de subcriptores")
                            println(channel.subscribers.size)
                        }
                        3 -> {
                            //removeOneVideo()
                        }
                        4 -> {
                            println(
                                """
                                
                                Nombre: ${channel.name}
                                Descripcion : ${channel.description}
                                Subscriptores: ${channel.subscribers.size}
                                Videos:        ${channel.videos.size}
                                
                            """.trimIndent()
                            )
                        }
                        5 -> {
                            showAllVideos()
                        }
                    }
                } while (option != 0)
            } catch (e: Exception) {
                println("Por favor ingresa un número válido $e")
            } finally {
                println("Proceso terminado")
            }
        } else {
            println("Debes de crear un canal primero")
        }
    }

    private fun upVideo(video: Video) {
        runBlocking {
            println("Subiendo tu video..")
            delay(4000)
        }
        channel.videos.add(video)
        println("Tu video a subido correctamente")
    }

    private fun createVideo(): Video? {
        println("Ingresa el nombre el video")
        val name = readLine().toString()
        println("Ingresa la duracion del video")
        val duration = readLine()?.toInt()
        return duration?.let { Video(name, it, channel) }
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
    fun showTotalOfSubscriber() {
        println(
            """
        The total of subcriber of the channel
        ${channel.name} are ${channel.subscribers.size}
    """.trimIndent()
        )
        val nombreDelCanal = "Nombre del Canal "
        val suscriptoresActuales = 0
        val suscriptoresNuevos = 0
        val totalDeSuscriptores = suscriptoresActuales + suscriptoresNuevos
        if (totalDeSuscriptores > 0) {
            println("$nombreDelCanal$totalDeSuscriptores suscriptores")
        } else {
            print("$nombreDelCanal$totalDeSuscriptores sin suscriptores")
        }
    }


    /**Recibe un canal por parametro y lo elimina de los videos del usuario*/

    /***Candado de seguridad para ver si el usuario esta completamente seguro de eliminar el video**/
    fun removeOneVideo(video: Video) {
        println("Estas seguro que deseas eliminar el video")
        println("1: Yes")
        println("2: No")
        when (readLine()?.toInt()) {
            1 -> {
                runBlocking {
                    println("Eliminado el video")
                    delay(3000)
                }
                channel.videos.remove(video)
                println("The video was deleted correcly")
            }
        }
    }

    val subscribers: Int
        get() {
            return channel.subscribers.size
        }
}





