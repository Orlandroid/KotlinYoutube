package controller

import models.User
import view.UserView

class UserController(private val user:User, private val userView:UserView, private val youtubeController: YoutubeController) {



    private fun checkUser():Map<String,String>{
        return mapOf("usuario@gmail.com" to "admin1234")
    }



    fun createAChannel(){

    }

    fun closeSession(){
        userView.cerrarSession()
        val option= readLine()?.toInt()
        if (option==1)
            user.isOnline=false
    }

   /**checka si el usuario tiene una session iniciada en youtube**/
    fun isOnline(){
        if(user.isOnline)
            userView.isOnline()
        else
            userView.isNotOnline()
    }

    private fun createUser(user:String, password:String):User{
        return User(user,password)
    }

    fun signIn(){
        userView.enterUser()
        val user= readLine().toString()
        userView.enterPassword()
        val password= readLine().toString()
        youtubeController.addUserToYoutube(createUser(user,password))
    }

    fun logIn(){
        for ((clave, valor) in checkUser()){
            if(user.user==clave && user.password==valor)
                userView.welcome()
            else
                userView.passwordOrUserWrong()
        }
    }



}