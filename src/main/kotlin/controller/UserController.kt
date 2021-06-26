package controller

import models.User
import view.UserView

class UserController(private val user:User, private val userView:UserView) {


    private fun checkUser():Map<String,String>{
        return mapOf("usuario@gmail.com" to "admin1234")
    }

    fun createAChannel(){

    }

    fun iniciarSession(){
        for ((clave, valor) in checkUser()){
            if(user.password==clave && user.password==valor)
                userView.welcome()
            else
                userView.passwordOrUserWrong()
        }
    }



}