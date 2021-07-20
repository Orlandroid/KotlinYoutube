package view

import controller.ChannelController
import controller.UserController
import controller.YoutubeController
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import models.Channel
import models.User
import models.Youtube

class MainMenu {

    init {
        menu()
    }

    private fun menu() {
        var currentUser: User? = null
        var currentUserController: UserController? = null
        var currentChannelController: ChannelController? = null
        var currentChannel: Channel? = null
        try {
            do {
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
                        if (currentUser != null)
                            youtubeController.searchAvideo(currentUser)
                        else
                            youtubeController.searchAvideo()
                    }
                    2 -> {
                        if (currentUser != null) {
                            currentUserController = UserController(currentUser)
                            currentUserController.videosWhatLike(currentUser)
                        } else {
                            println("Debes de iniciar session")
                        }
                    }
                    3 -> {
                        if (currentUser != null) {
                            currentUserController = UserController(currentUser)
                            currentUserController.historialVideoswhatSee()
                        } else
                            print("Debes de iniciar session")
                    }
                    4 -> {
                        if (currentUser != null) {
                            if (currentChannel != null) {
                                currentChannelController = ChannelController(currentChannel)
                                currentChannelController.myChannel()
                            } else
                                println("Aun no tienes una canal")
                        } else
                            println("Debes de iniciar Session")
                    }
                    5 -> {
                        if (currentUser != null)
                            println("Ya tienes una session $currentUser")
                        else {
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
                    }
                    6 -> {
                        
                        if (currentUser != null) {
                            println("actualmente ya estas en el sistema $currentUser")
                        } else {
                            println("Ingresa tu usuario")
                            val user = readLine().toString()
                            println("Ingresa contraseña")
                            val password = readLine().toString()
                            currentUser = User(user, password)
                            currentUser.isOnline = true
                            Youtube.users.add(currentUser)
                            println("El usuario se ha creado correctamente")
                        }

                    }
                    7 -> {
                        if (currentUser != null) {
                            currentUserController = UserController(currentUser)
                            currentUserController.cerrarSession()
                        } else
                            println("Debes de iniciar session")
                    }
                    8 -> {
                        if (currentUser != null) {
                            if (currentUser.haveAchannel) {
                                println("Tu ya tienes una canal")
                            } else {
                                println("Ingresa el nombre de tu canal")
                                val nombre = readLine().toString()
                                println("Escribe una breve descripción de tu canal")
                                val descripcion = readLine().toString()
                                currentChannel = Channel(nombre, currentUser, descripcion)
                                Youtube.channels.add(currentChannel)
                                runBlocking {
                                    println("Creando tu canal")
                                    delay(2000)
                                    println("Se ha creado tu canal")
                                }
                            }
                        } else
                            println("Debes de iniciar Session")
                    }
                    9 -> {
                        if (currentUser != null) {
                            do {
                                println("1: Profile")
                                println("2: Subcripciones")
                                println("0: Salir")
                                val optionSubMenuProfile = readLine()?.toInt()
                                when (optionSubMenuProfile) {
                                    1 -> {
                                        println(
                                            """
                                            
                                            Usuario: ${currentUser.user}
                                            Online:  ${currentUser.isOnline}
                                            Tiene canal: ${currentUser.haveAchannel}
                                        """.trimIndent()
                                        )
                                    }
                                    2 -> {
                                        val userController = UserController(currentUser)
                                        userController.showChannelSubcribe()
                                    }
                                }
                            } while (optionSubMenuProfile != 0)
                        } else
                            println("Debes de iniciar session para ver tu perfil")
                    }
                }


            } while (opcion != 0)
        } catch (e: Exception) {
            println("Por favor ingresa un número válido $e")
        } finally {
            println("Proceso terminado")
        }

    }
}