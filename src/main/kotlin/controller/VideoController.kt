package controller

import models.Video
import view.VideoView

class VideoController(val video: Video, private val videoView: VideoView) {

    fun watchAVideo(){
        videoView.playAVideo(video.name,video.duration)
    }
}