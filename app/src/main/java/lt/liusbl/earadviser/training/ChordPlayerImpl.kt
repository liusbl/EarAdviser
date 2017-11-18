package lt.liusbl.earadviser.training

import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import lt.liusbl.earadviser.training.notes.Note
import lt.liusbl.earadviser.training.notes.NoteItem
import lt.liusbl.earadviser.training.player.NotePlayer
import lt.liusbl.earadviser.training.score.Chord

class ChordPlayerImpl(
        private val listener: () -> OnChordEventListener,
        private val mainScheduler: Scheduler,
        private val computationScheduler: Scheduler,
        private val notePlayer: NotePlayer,
        private val chordHandler: ChordHandler
) : ChordPlayer {
    override fun playNext(
            baseNote: NoteItem,
            allNotes: List<NoteItem>,
            noteCount: Int,
            duration: Long
    ) {
        chordHandler.getNextChord(baseNote, allNotes, noteCount)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { chord: Chord ->
                    chord.notes.forEach { note -> play { playNote(note, duration) } }
                }
    }

    override fun playAgainInSequence(duration: Long) {
        chordHandler.getLastChord()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { chord: Chord ->
                    play { chord.notes.forEach { note -> playNote(note, duration) } }
                }
    }

    override fun playAgain(duration: Long) {
        chordHandler.getLastChord()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { chord: Chord ->
                    chord.notes.forEach { note -> play { playNote(note, duration) } }
                }
    }

    override fun playPrevious(duration: Long) {
        chordHandler.getPreviousChord()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { chord: Chord ->
                    chord.notes.forEach { note -> play { playNote(note, duration) } }
                }
    }

    override fun playBaseNote(note: Note, duration: Long) {
        play { playNote(note, duration) }
    }

    override fun getCurrentChord() = Chord(emptyList()) // todo

    private fun playNote(noteItem: NoteItem, duration: Long) {
        val note = Note(noteItem.name, noteItem.semitones, noteItem.octave, noteItem.frequency)
        notePlayer.play(note, duration)
    }

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