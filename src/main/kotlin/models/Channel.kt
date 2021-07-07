package models


data class Channel(val name:String,val user: User,val description:String){

    init {
        user.haveAchannel=true
    }

    val videos = mutableListOf<Video>()
    val subscribers= mutableListOf<User>()

}

