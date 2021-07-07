package view

import controller.UserController
import controller.YoutubeController
import models.User
import models.Youtube

class MainMenu {

    init {
        menu()
    }

    private fun menu() {
        var currentUser: User? = null
        var currentUserController:User?=null
        do {
            println("new")
            println()
            println("1:Buscar un video")
            println("2:Videos que me gustan")
            println("3:Historial")
            println("4:Canal")
            println("5:Iniciar Session")
            println("6:Registrarse")
            println("7:Cerrar Session")
            println("8:Crear un canal")
            println("9:Perfil")
            println("0:Salir")
            println("What you want to do")
            val opcion = readLine()?.toInt()
            when (opcion) {
                1 -> {
                    val youtube = Youtube()
                    val youtubeController = YoutubeController(youtube)
                    youtubeController.searchAvideo()
                }
                2 ->{
                    if(currentUser!=null)
                        println("Videos que me gustan")
                    else
                        println("Debes de iniciar session")
                }
                3 ->{
                    if(currentUser != null)
                        println("Este es tu historial")
                    else
                        print("Debes de iniciar session")
                }
                4 ->{
                    if(currentUser != null)
                        println("Este es tu canal")
                    else
                        println("Debes de iniciar Session")
                }
                5 -> {
                    println("Ingres el usuario")
                    val usuario = readLine().toString()
                    println("Ingresa la password")
                    val password = readLine().toString()
                    val user = User(usuario, password)
                    if (Youtube.users.contains(user))
                        println("El usuario se encuentra en la base de datos")
                    else
                        println("No hay ningun usuario registrado con ese nombre")
                }
                6 -> {
                    if(currentUser != null){
                        println("actualmente ya estas en el sistema $currentUser")
                    }
                    else{
                        println("Ingresa tu usuario")
                        val user = readLine().toString()
                        println("Ingresa contraseña")
                        val password = readLine().toString()
                        currentUser = User(user, password)
                        Youtube.users.add(currentUser)
                        println("El usuario se ha creado correctamente")
                    }

                }
                7 ->{
                    println("Cerrando session")
                    currentUser=null
                }
                8 ->{
                    if (currentUser!=null)
                        println("Vamos a crear tu canal")
                    else
                        println("Debes de iniciar Session")
                }
                9 -> {
                    if(currentUser!=null)
                        println(currentUser.user)
                    else
                        println("Debes de iniciar session para ver tu perfil")
                }
            }
        } while (opcion != 0)

    }

}