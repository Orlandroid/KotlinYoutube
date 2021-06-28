package view

import models.User

class UserView {

    fun enterUser(){
        println("Enter User: ")
    }

    fun isOnline(){
        println("El user is current online")
    }

    fun isNotOnline(){
        println("El user current don,t is not online")
    }


    fun haveAChanel(user:User){
        if(user.haveAchannel)
            println("The ${user.user} have one channel")
        else
            println("The ${user.user} don,t have one channel yet.")
    }
    
    fun cerrarSession(){
        println("Are sure what do you want to leave")
        println("1:YES")
        println("2.No")
    }

    fun enterPassword(){
        println("Enter Password: ")
    }

    fun passwordOrUserWrong(){
        println("username and password not found")
    }

    fun welcome(){
        println("Welcome to youtube")
    }


}