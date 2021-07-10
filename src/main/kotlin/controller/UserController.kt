package controller

import models.Channel
import models.User
import models.Youtube

class UserController(private val user: User) {


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


    /**muestra el historial de los videos que has visto*/
    fun historialVideoswhatSee() {
        println("Historial de videos que haz visto")
        user.historialOfWatchVideos.forEach {
            println(it)
        }
    }

    fun makeYourChannel(){
        println("Ingresa el nombre de tu canal")
        val canal = readLine().toString()
        println("Escribe una breve descripción de tu canal")
        val descripcion = readLine().toString()
        val channel = Channel(canal, user, descripcion)
        Youtube.channels.add(channel)
        println("Se ha creado tu canal")

    }

    fun myChannel() {
        if (user.haveAchannel) {
            println("Opciones de tu canal: ")
            println("1: subir video")
            println("2: mostrar número de suscriptores")
            // posteriormente agregar cambiar nombre, mostrar nombre y descripción, etc.
            // println("2: mostrar todos los videos")
        }



        else
            println("Debes de crear un canal primero")
    }

    fun haveAChanel(user: User) {
        if (user.haveAchannel)
            println("The ${user.user} have one channel")
        else
            println("The ${user.user} don,t have one channel yet.")
    }

    fun cerrarSession(): Boolean {
        println("Are sure that you want to leave")
        println("1:Yes")
        println("2.No")
        try{
            val option: Int? = readLine()?.toInt()
            if (option == 1){
                user.isOnline = false
                println("Finalizando tu session")
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
            println("Videos que te gustan $it")
        }
    }

    fun messageNoLogin() {
        println("Debes de iniciar session")
    }

    fun closeSession() {
        //cerrarSession()
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


}