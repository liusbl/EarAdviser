package lt.liusbl.earadviser.training

import lt.liusbl.earadviser.training.notes.NoteItem
import lt.liusbl.earadviser.training.score.Chord

interface ChordFactory {
    fun create(
            baseNote: NoteItem,
            allNotes: List<NoteItem>,
            minInterval: Int,
            maxInterval: Int,
            noteCount: Int
    ): Chord
}