package controller

//import jdk.internal.net.http.common.Log.channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import models.Channel
import models.User
import models.Video
import models.Youtube
import models.Youtube.Companion.channels

class UserController(private val user: User) {

    val canal = String()
    val descripcion = String()
    val durationUnit = 0
    val name = String()
    val Video1 = Video(name, durationUnit, Channel(canal, user, descripcion))
    /***
     *      ACCIONES QUE EL USUARIO PUEDE HACER
     *    TuCanal()
     *   subirAvideo()
     *   verCanalesAlosQueEstoySubscripto()
     *   darLikeAvideos()
     *   commentarUnVideo()
     *   desuscribirseDeUnCanal()
     *   subscribirseAunCanal()
     *   crearUnCanal()
     *   mostrarHistorialDeVideos()
     *   probarPremium()
     *   cerrarSession()
     *   * **/


    private fun enterUser() {
        println("Enter User: ")
    }


    fun historialVideoswhatSee() {
        println("Historial de videos que haz visto")
        println()
        user.historialOfWatchVideos.forEach {
            val videoController=VideoController(it)
            videoController.showVideo(it)
        }
    }

    fun showChannelSubcribe(){
        user.ChannelSubscribers.forEach{
            println(it.name)
        }
    }

    fun makeYourChannel(){
        println("Ingresa el nombre de tu canal")
        val canal = readLine().toString()
        println("Escribe una breve descripción de tu canal")
        val descripcion = readLine().toString()
        val channel = Channel(canal, user, descripcion)
        channels.add(channel)

        runBlocking { println("Creando tu canal")
            delay(2000)
            println("Se ha creado tu canal") }
    }
    fun myChannel() {
        if (user.haveAchannel) {
            try{
            do {
                println("Opciones de tu canal: ")
                println("1: Subir video")
                println("2: Mostrar número de suscriptores")
                println("3: Eliminar video")
                println("4: Mostrar nombre del canal y descripción")
                println("0: Salir de este menú")

                val option: Int? = readLine()?.toInt()
                when (option) {
                    1 -> {
                        user.upload = true
                        val currentChannel = ChannelController(Channel(canal, user,descripcion))
                        currentChannel.upVideo(Video1)
                    }
                    2 -> {
                        if (user.haveAchannel) {
                            user.ChannelSubscribers.forEach {
                                println(it)
                                val currentChannel = ChannelController(Channel(canal, user,descripcion))
                                currentChannel.showTotalOfSubscriber()
                            }
                        } else {
                            println("You don`t have subscribers yet")}

                    }
                    3 -> {
                        if(user.upload){
                        val currentChannel = ChannelController(Channel(canal, user,descripcion))
                        currentChannel.removeOneVideo(Video1)
                    }else{
                        println("You need to load a video")
                    }}
                    4 -> {
                        if(user.haveAchannel){
                            val currentChannel = channels
                            println("Tu canal(es) ${channels}")
                        }else{
                            println("You don´t have any channel yet")
                        }
                    }
                }
            } while (option != 0)}
            catch (e:Exception){
                println("Por favor ingresa un número válido $e")
            }
            finally{
                println("Proceso terminado")
            }
        }
            else{
                println("Debes de crear un canal primero")}
                    }

    fun haveAChanel(user: User) {
        if (user.haveAchannel)
            println("The ${user.user} have one channel")
        else
            println("The ${user.user} don,t have one channel yet.")
    }

     fun cerrarSession(): Boolean {
        println("Are you sure that you want to leave")
        println("1:Yes")
        println("2.No")
        try{
            val option: Int? = readLine()?.toInt()
            if (option == 1){
                user.isOnline = false
                runBlocking {  println("Finalizando tu session...")
                        delay(5000)//demora el cierre de la sesión por 5 segundos
                        println("Session finalizada") }
            }
            else{
                println("Sigues en la session")
            }}
        catch (e: Exception){
            println("Ingresa un número válido $e")
        }
        finally {
            println("Proceso terminado")
        }
        return user.isOnline
    }

    private fun enterPassword() {
        println("Enter Password: ")
    }


    fun videosWhatLike(user: User) {
        println("Videos que te gustan")
        user.videosWhaLike.forEach {
            val videoController=VideoController(it)
            videoController.showVideo(it)
        }
    }

    fun messageNoLogin() {
        println("Debes de iniciar session")
    }

    //Se sustituye función por cerrarSession()
    fun closeSession() {
        val option = readLine()?.toInt()
        if (option == 1)
            user.isOnline = false
    }


    fun isOnline() {
        if (user.isOnline)
            println("El user is current online")
        else
            println("El user is current not online")
    }

    fun optionsChannel(){
        myChannel()
        val option = readLine()?.toInt()
        if(option == 1){
            println("Ingresa el nombre de tu video")
        }
    }

    /**receive one user,passsword and return one Object of User
     * in other words make one object of user**/
    private fun createUser(user: String, password: String): User {
        return User(user, password)
    }


    fun signIn() {

    }
//Código para saber a qué canales está suscrito el usuario, falta darle funcionalidad
    val subscription = false
    val ChannelCanSubscribe : Collection<Exception> //necesita inicializarse
        get() {
        return ChannelCanSubscribe
        }

    fun ChanneltoSubscribe(){
    if(subscription== true){
    println("Te has suscrito al canal")
    }
    else{
        println("Aún no te has suscrito a ningún canal")
    }

    }

        }