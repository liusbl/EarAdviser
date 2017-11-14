package lt.liusbl.earadviser.training.player

import lt.liusbl.earadviser.training.notes.Note


class NotePlayerImpl(
        private val frequencyAudioDataGenerator: FrequencyAudioDataGenerator,
        private val audioTrackHandler: AudioTrackHandler
) : NotePlayer {
    override fun play(note: Note, duration: Long) {
        val audioData = frequencyAudioDataGenerator.generateAudioData(note.frequency, duration)
        audioTrackHandler.playSound(audioData, duration)
    }
}