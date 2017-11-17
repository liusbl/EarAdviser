package lt.liusbl.earadviser.training

import lt.liusbl.earadviser.training.notes.Note
import lt.liusbl.earadviser.training.score.Chord

interface ChordFactory {
    fun create(
            baseNote: Note,
            allNotes: List<Note>,
            minInterval: Int,
            maxInterval: Int,
            noteCount: Int
    ): Chord
}