package lt.liusbl.earadviser.training.player

import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import lt.liusbl.earadviser.training.player.FrequencyAudioDataGeneratorImpl.Companion.SAMPLE_RATE

class AudioTrackHandlerImpl : AudioTrackHandler {
    override fun playSound(audioData: List<Byte>, duration: Long) {
        val audioTrack = AudioTrack(AudioManager.STREAM_MUSIC,
                SAMPLE_RATE.toInt(), AudioFormat.CHANNEL_OUT_MONO,
                AudioFormat.ENCODING_PCM_16BIT, audioData.size,
                AudioTrack.MODE_STATIC)
        try {
            audioTrack.write(audioData.toByteArray(), 0, audioData.size)
            audioTrack.play()
        } catch (e: IllegalStateException) {
            return
        }
        Thread.sleep(duration)
    }
}