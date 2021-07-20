package models

import state.Quality
import state.Speed

data class Video(val name: String, val duration: Int, val channel: Channel) {
    var visits = 0
    var speed: Speed = Speed.NORMAL
    var quality: Quality = Quality.Q140
    var enableSubtitle = false
}
