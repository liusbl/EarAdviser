package lt.liusbl.earadviser.training.notes

interface NoteHandler {
    fun getNoteFromInterval(baseNote: Note, interval: Int, allNotes: List<Note>): Note
}