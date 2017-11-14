package lt.liusbl.earadviser.training

import lt.liusbl.earadviser.training.notes.Note
import lt.liusbl.earadviser.training.score.Chord

interface ChordPlayer {
    fun setChords(chords: List<Chord>)

    fun playNext(duration: Long)

    fun playAgainInSequence(duration: Long)

    fun playAgain(duration: Long)

    fun playPrevious(duration: Long)

    fun playBaseNote(note: Note, duration: Long)
}