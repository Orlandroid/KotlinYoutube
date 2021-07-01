package controller

import models.Channel
import models.User
import models.Video
import models.Youtube
import java.util.ArrayList

class YoutubeController(private val youtube: Youtube) {


    init {
        //addChannelForDefault()
        mainMenu()
    }



    fun initYoutube(){
        var titleYoutube ="Loading"
        for (x in 1..10){
            Thread.sleep(1000)
            println(titleYoutube)
            titleYoutube+="."
        }
    }

    fun getAllUserFromYoutube():MutableList<User> = youtube.users

    fun getAllChannelFromYoutube():MutableList<Channel> = youtube.channels

    fun getAllVideosFromYoutube(){
       youtube.channels
    }

    fun haveAccountUser(user:User):Boolean =  youtube.users.contains(user)


    private fun addChannelForDefault(){
        val user=User("android@gmail.com","admin1234")
        val android=Channel("Android",user,"channel about android")
        val channelC=ChannelController(android)
        addChannelToYoutube(android)

        val video=Video("¿Que es kotlin?",5,android)
        val video2=Video("Fundamentos de programacion",10,android)
        val video3=Video("Programacion Orientada a objetos",20,android)
        val video4=Video("Programacion funcional",18,android)
        val video5=Video("Programacion asincrona",8,android)

        channelC.upVideo(video)
        channelC.upVideo(video2)
        channelC.upVideo(video3)
        channelC.upVideo(video4)
        channelC.upVideo(video5)

        channelC.showAllVideos()
    }

    private fun mainMenu(){
        do {
            println("1:Buscar un video")
            println("2:Videos que me gustan")
            println("3:Historial")
            println("4:Canal")
            println("5:Iniciar Session")
            println("6:Registrarse")
            println("7:Cerrer Session")
            println("8:Crear un canal")
            println("0:Salir")
            println("What you want to do")
            val opcion= readLine()?.toInt()
            when(opcion){
                1 -> searchAvideo()
            }
        }while (opcion!=0)

    }


    private fun historialOfwatchVideos(){
        val user=getCurrentUser()
        val videos=user.historialOfWatchVideos
        videos.forEach {
            showVideo(it)
        }
    }

    /** funcion que nos regresa el usuario actual que
     * esta connectado a youtube si es que esta iniciando session en la plataforma**/

    private fun getCurrentUser():User{
        return youtube.users[0]
    }

    private fun createAchannel(){
        println("Ingresa el nombre del canal")
        val nombre= readLine().toString()
        println("Ingresa el nombre del canal")
        val usuario= getCurrentUser()
        println("Ingresa el nombre del canal")
        val descripcion= readLine().toString()
        val channel=Channel(nombre,usuario,descripcion)
        youtube.channels.add(channel)
        println("Tu canal se ha creado correctamente")
    }

    private  fun cerrarSession(){
        println("Estas seguro de que desas cerrar session? y|n")
        val opcion= readLine().toString()
        if(opcion == "s")
            println("Cerrando session")
        /*** Regresar otra vez al usuario al menu principal*/
    }

    private fun registrarse(){
        println("Ingresa tu usuario")
        val user= readLine().toString()
        println("Ingresa tu usuario")
        val password= readLine().toString()
        val usuario=User(user,password)
        youtube.users.add(usuario)
        println("El usuario se ha registrado correctamete ahora puede iniciar session")
        /** despues de que el usuario se ha creado una cuenta podemos regresarlo a menu principal**/

    }


    private fun makeMePremium(){
        val user=getCurrentUser()
        user.isPremium=true
        println("Felicidades ahora podras ver los videos sin anuncions")
    }

    private fun iniciarSession(){
        println("Ingresa tu usario")
        val usuario= readLine().toString()
        println("Ingresa tu contraseña")
        val contra= readLine().toString()
        val user=User(usuario,contra)
        if(youtube.users.contains(user))
            println("Haz iniciado session correctamente")
        else
            println("El usuario no existe")
    }

    private fun mainMenuSessionDisable(){
        println("1:Buscar un video")
        println("2:Iniciar Session")
        println("3:Registrarse")
        println("What you want to do")
    }

    private fun searchAvideo(){
        println("give the name of the video")
        val name= readLine().toString()
        val patternNameVideo = name.toRegex()
        for (x in youtube.channels.iterator()){
            /** ArrayList<Video> get all videos from each channel in youtube*/
            val videos=x.videos
            var totales=1
            videos.forEach {
                if (patternNameVideo.containsMatchIn(it.name)){
                    println(totales.toString())
                    totales++
                    showVideo(it)
                }
            }
        }
    }

    private fun showVideo(video:Video){
        println("""
            channel:${video.channel.name}
            name:${video.name}
            duration:${video.duration}
        
        """.trimIndent())
    }


    /**simulation of the user is waching one video*/
    fun watchAVide(video: Video){
        println("Waching ${video.name}")
        Thread.sleep(video.duration.toLong())
        /**rise the number of visitas**/
        video.visits+=1
    }

    fun showAllVideos(channels:ArrayList<Channel>){
        for (channel in channels.iterator())
            println(channel.videos)
    }


    private fun showCharacter(character:Char='*', size:Int=10){
        for (x in 0..size)
            println(character)
    }

    private fun printChannel(channel: Channel){
        println(channel.name)
    }

    fun showAllChannelsOfYoutube(channels: ArrayList<Channel>){
        showCharacter()
        for (x in channels.iterator())
            printChannel(x)
        showCharacter()
    }


    fun addUserToYoutube(user:User){
        youtube.users.add(user)
        println("account create correcly")
    }

    private fun addChannelToYoutube(channel: Channel){
        youtube.channels.add(channel)
        println("account create correcly")
    }



    fun seeTermsAndLicence(){
        println("You aggre")
    }

}