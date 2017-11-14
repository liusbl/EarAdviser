package lt.liusbl.earadviser.training.notes

class NoteHandlerImpl : NoteHandler {
    override fun getNoteFromInterval(baseNote: Note, interval: Int, allNotes: List<Note>): Note {
        val combinedSemitones = baseNote.semitones + interval
        val semitones = combinedSemitones % 12
        return if (combinedSemitones > 11) {
            val additionalOctaves = combinedSemitones / 12
            val octave = baseNote.octave + additionalOctaves
            getNoteFromList(semitones, octave.toInt(), allNotes)
        } else {
            getNoteFromList(semitones, baseNote.octave, allNotes)
        }
    }

    private fun getNoteFromList(semitones: Long, octave: Int, allNotes: List<Note>): Note {
        return allNotes.firstOrNull {
            it.semitones == semitones && it.octave == octave
        } ?: Note()
    }
}