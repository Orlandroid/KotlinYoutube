package models

import controller.ChannelController
import controller.UserController
import kotlinx.coroutines.channels.Channel


data class Channel(val name:String,val user: User,val description:String){

    init {
        user.haveAchannel=true
        menuChanel()


    }

    val videos = mutableListOf<Video>()
    val subscribers= mutableListOf<User>()




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






