package controller

import models.User
import models.Youtube

class UserController(private val user: User) {


    /***
     *      ACCIONES QUE EL USUARIO PUEDO HACER
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


    /**muestra el historial de los videos que has visto*/
    fun historialVideoswhatSee() {
        println("Historial de videos que haz visto")
        user.historialOfWatchVideos.forEach {
            println(it)
        }
    }

    fun makeYourChannel(){
        println("Creando tu canl")
    }

    fun myChannel() {
        if (user.haveAchannel)
            println("Opciones de tu canal")
        else
            println("Debes de crear un canal primero")
    }

    fun haveAChanel(user: User) {
        if (user.haveAchannel)
            println("The ${user.user} have one channel")
        else
            println("The ${user.user} don,t have one channel yet.")
    }

    private fun cerrarSession() {
        println("Are sure what do you want to leave")
        println("1:YES")
        println("2.No")
    }

    private fun enterPassword() {
        println("Enter Password: ")
    }


    fun videosWhatLike(user: User) {
        println("Videos que te gustan")
        user.videosWhaLike.forEach {
            println("Videos que te gustan $it")
        }
    }

    fun messageNoLogin() {
        println("Debes de iniciar session")
    }

    fun closeSession() {
        cerrarSession()
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

    /**receive one user,passsword and return one Object of User
     * in other words make one object of user**/
    private fun createUser(user: String, password: String): User {
        return User(user, password)
    }


    fun signIn() {

    }


}