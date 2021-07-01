package models

data class User(val user:String,val password:String) {
    var haveAchannel=false
    var isOnline=false
    var isPremium=false

    val videosWhaLike= mutableListOf<Video>()
    val channalSuscribe= mutableListOf<Channel>()
    val historialOfWatchVideos= mutableListOf<Video>()



}
