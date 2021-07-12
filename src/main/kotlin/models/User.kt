package models

data class User(val user:String,val password:String) {
    var haveAchannel=false
    var isOnline=false
    var isPremium=false
    var upload = false

    val videosWhaLike= mutableListOf<Video>()
    val ChannelSubscribers= mutableListOf<Channel>()
    val historialOfWatchVideos= mutableListOf<Video>()

}
