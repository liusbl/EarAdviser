package lt.liusbl.earadviser.training.notes

interface NoteHandler {
    fun getNoteFromInterval(baseNote: NoteItem, interval: Int, allNotes: List<NoteItem>): NoteItem
}