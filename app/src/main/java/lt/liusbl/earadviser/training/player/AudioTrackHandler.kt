package lt.liusbl.earadviser.training.player

interface AudioTrackHandler {
    fun playSound(audioData: List<Byte>, duration: Long)
}