package lt.liusbl.earadviser.training

import lt.liusbl.earadviser.training.notes.NoteItem
import lt.liusbl.earadviser.training.score.Chord

interface ChordPlayer {
    fun playNext(baseNote: NoteItem, allNotes: List<NoteItem>, noteCount: Int, duration: Long)

    fun playAgainInSequence(duration: Long)

    fun playAgain(duration: Long)

    fun playPrevious(duration: Long)

    fun playBaseNote(note: NoteItem, duration: Long)

    fun getCurrentChord(): Chord
}