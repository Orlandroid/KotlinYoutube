package controller

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import models.Channel
import models.User
import models.Youtube.Companion.channels

class UserController(private val user: User) {


    /** Este codigo hace que el usuario se cree un canal **/
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

    fun historialVideoswhatSee() {
        if (user.historialOfWatchVideos.isEmpty()) {
            println("Aun no haz visto ningun video")
            return
        }
        user.historialOfWatchVideos.forEach {
            val videoController = VideoController(it)
            videoController.showVideo(it)
        }
    }

    fun showChannelSubcribe() {
        if (user.ChannelSubscribers.isEmpty()) {
            println("Aun no te has subcrito a ningun canal")
            return
        }
        user.ChannelSubscribers.forEach {
            println(it.name)
        }
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
        try {
            val option: Int? = readLine()?.toInt()
            if (option == 1) {
                user.isOnline = false
                runBlocking {
                    println("Finalizando tu session...")
                    delay(5000)
                    println("Session finalizada")
                }
            } else {
                println("Sigues en la session")
            }
        } catch (e: Exception) {
            println("Ingresa un número válido $e")
        } finally {
            println("Proceso terminado")
        }
        return user.isOnline
    }


    fun videosWhatLike(user: User) {
        if (user.videosWhaLike.isEmpty()) {
            println("Aun no haz dado like a ningun video")
            return
        }
        user.videosWhaLike.forEach {
            val videoController = VideoController(it)
            videoController.showVideo(it)
        }
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

    fun optionsChannel() {
        val option = readLine()?.toInt()
        if (option == 1) {
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
    val ChannelCanSubscribe: Collection<Exception> //necesita inicializarse
        get() {
            return ChannelCanSubscribe
        }

    fun ChanneltoSubscribe() {
        if (subscription == true) {
            println("Te has suscrito al canal")
        } else {
            println("Aún no te has suscrito a ningún canal")
        }

    }

}