package lt.liusbl.earadviser.training.player

import lt.liusbl.earadviser.training.notes.Note
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.Mockito.verify

class NotePlayerImplTest {
    private val generator = Mockito.mock(FrequencyAudioDataGenerator::class.java)
    private val trackHandler = Mockito.mock(AudioTrackHandler::class.java)
    private val player = NotePlayerImpl(generator, trackHandler)

    @Test
    fun play_playsSound() {
        val note = Note()
        given(generator.generateAudioData(note.frequency, 0)).willReturn(emptyList())

        player.play(note, 0)

        verify(trackHandler).playSound(emptyList(), 0)
    }
}