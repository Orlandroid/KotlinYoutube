package controller

import models.User
import view.UserView

class UserController(private val user:User, private val userview:UserView) {


    private fun checkUser():Map<String,String>{
        return mapOf("usuario@gmail.com" to "admin1234")
    }

    fun iniciarSession(){
        for ((clave, valor) in checkUser()){
            if(user.password==clave && user.password==valor)
                userview.welcome()
            else
                userview.passwordOrUserWrong()
        }
    }



}