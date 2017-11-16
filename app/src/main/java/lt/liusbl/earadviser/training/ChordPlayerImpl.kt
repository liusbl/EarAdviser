package lt.liusbl.earadviser.training

import io.reactivex.Completable
import io.reactivex.Scheduler
import lt.liusbl.earadviser.training.notes.Note
import lt.liusbl.earadviser.training.player.NotePlayer
import lt.liusbl.earadviser.training.score.Chord

class ChordPlayerImpl(
        private val listener: () -> OnChordEventListener,
        private val mainScheduler: Scheduler,
        private val computationScheduler: Scheduler,
        private val notePlayer: NotePlayer
) : ChordPlayer {
    private var chords: List<Chord>? = null
    private var chordPosition = 0

    override fun setChords(chords: List<Chord>) {
        this.chords = chords
    }

    override fun playNext(duration: Long) {
        if (chordPosition != chords?.size) {
            playAtOnce(++chordPosition, duration)
        }
    }

    override fun playAgainInSequence(duration: Long) {
        play { getNotes(chordPosition)?.forEach { note -> playNote(note, duration) } }
    }

    override fun playAgain(duration: Long) {
        playAtOnce(chordPosition, duration)
    }

    override fun playPrevious(duration: Long) {
        if (chordPosition != 0) {
            playAtOnce(--chordPosition, duration)
        }
    }

    private fun playAtOnce(chordPosition: Int, duration: Long) {
        getNotes(chordPosition)?.forEach { note -> play { playNote(note, duration) } }
    }

    private fun getNotes(chordPosition: Int) = chords?.get(chordPosition)?.notes

    override fun playBaseNote(note: Note, duration: Long) {
        play { playNote(note, duration) }
    }

    override fun getCurrentChord() = chords?.get(chordPosition) ?: Chord(emptyList())

    private fun playNote(note: Note, duration: Long) {
        notePlayer.play(note, duration)
    }

    private fun play(action: () -> Unit) {
        listener().onChordStartedListener()
        Completable.fromAction(action)
                .observeOn(mainScheduler)
                .subscribeOn(computationScheduler)
                .subscribe { listener().onChordFinishedListener() }
    }
}