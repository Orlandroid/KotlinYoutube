package controller

import models.Channel
import models.User
import models.Video
import models.Youtube
import java.util.ArrayList

class YoutubeController(private val youtube: Youtube) {


    fun initYoutube() {
        var titleYoutube = "Loading"
        for (x in 1..10) {
            Thread.sleep(1000)
            println(titleYoutube)
            titleYoutube += "."
        }
    }



    private fun historialOfwatchVideos() {
        val user = Youtube.users[0]
        val videos = user.historialOfWatchVideos
        videos.forEach {
            showVideo(it)
        }
    }

    /** funcion que nos regresa el usuario actual que
     * esta connectado a youtube si es que esta iniciando session en la plataforma**/


    private fun createAchannel() {
        println("Ingresa el nombre del canal")
        val nombre = readLine().toString()
        println("Ingresa el nombre del canal")
        val usuario = Youtube.users[0]
        println("Ingresa el nombre del canal")
        val descripcion = readLine().toString()
        val channel = Channel(nombre, usuario, descripcion)
        Youtube.channels.add(channel)
        println("Tu canal se ha creado correctamente")
    }

    private fun cerrarSession() {
        println("Estas seguro de que desas cerrar session? y|n")
        val opcion = readLine().toString()
        if (opcion == "s")
            println("Cerrando session")
        /*** Regresar otra vez al usuario al menu principal*/
    }

    private fun registrarse() {
        println("Ingresa tu usuario")
        val user = readLine().toString()
        println("Ingresa tu usuario")
        val password = readLine().toString()
        val usuario = User(user, password)
        Youtube.users.add(usuario)
        println("El usuario se ha registrado correctamete ahora puede iniciar session")
        /** despues de que el usuario se ha creado una cuenta podemos regresarlo a menu principal**/

    }


    private fun makeMePremium() {
        val user = Youtube.users[0]
        user.isPremium = true
        println("Felicidades ahora podras ver los videos sin anuncions")
    }

    private fun iniciarSession() {
        println("Ingresa tu usario")
        val usuario = readLine().toString()
        println("Ingresa tu contraseña")
        val contra = readLine().toString()
        val user = User(usuario, contra)
        if (Youtube.users.contains(user))
            println("Haz iniciado session correctamente")
        else
            println("El usuario no existe")
    }

    private fun mainMenuSessionDisable() {
        println("1:Buscar un video")
        println("2:Iniciar Session")
        println("3:Registrarse")
        println("What you want to do")
    }

    /**
     * Funcion la cual usa una expreion regular para buscar los videos que considan con la
     * busqueda de acurda a la expresion , la expresion regular que se usa es la siguiente
     * /name/i donde name es el nombre del video a buscar y i es ignore lo cual significa que
     * va a trata igual a kotlin KOTLIN KOtlin
     * **/

    fun searchAvideo() {
        println("give the name of the video")
        val videoName = readLine().toString()
        /** pattern /name/i **/
        val patternNameVideo = Regex(videoName,RegexOption.IGNORE_CASE)
        for (x in Youtube.channels.iterator()) {
            val videos = x.videos
            var totals = 1
            videos.forEach {
                if (patternNameVideo.containsMatchIn(it.name)) {
                    println(totals.toString())
                    totals++
                    showVideo(it)
                }
            }
        }
    }

    private fun showVideo(video: Video) {
        println(
            """
            channel:${video.channel.name}
            name:${video.name}
            duration:${video.duration}
        
        """.trimIndent()
        )
    }


    /**simulation of the user is waching one video*/
    fun watchAVide(video: Video) {
        println("Waching ${video.name}")
        Thread.sleep(video.duration.toLong())
        /**rise the number of visitas**/
        video.visits += 1
    }

    fun showAllVideos(channels: ArrayList<Channel>) {
        for (channel in channels.iterator())
            println(channel.videos)
    }


    private fun showCharacter(character: Char = '*', size: Int = 10) {
        for (x in 0..size)
            println(character)
    }

    private fun printChannel(channel: Channel) {
        println(channel.name)
    }



    fun addUserToYoutube(user: User) {
        Youtube.users.add(user)
        println("account create correcly")
    }


}