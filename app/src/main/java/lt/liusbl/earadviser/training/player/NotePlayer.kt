package lt.liusbl.earadviser.training.player

import lt.liusbl.earadviser.training.notes.Note

interface NotePlayer {
    fun play(note: Note, duration: Long)
}