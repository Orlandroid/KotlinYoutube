package view

import models.User

class UserView {

    fun enterUser(){
        println("Enter User: ")
    }

    fun haveAChanel(user:User){
        if(user.haveAchannel)
            println("The ${user.user} have one channel")
        else
            println("The ${user.user} don,t have one channel yet.")
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