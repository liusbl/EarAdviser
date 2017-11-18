package lt.liusbl.earadviser.training

import lt.liusbl.earadviser.training.notes.NoteHandler
import lt.liusbl.earadviser.training.notes.NoteItem
import lt.liusbl.earadviser.training.notes.RandomSortedIntGenerator
import lt.liusbl.earadviser.training.score.Chord

class ChordFactoryImpl(
        private val intGenerator: RandomSortedIntGenerator,
        private val noteHandler: NoteHandler
) : ChordFactory {
    override fun create(
            baseNote: NoteItem,
            allNotes: List<NoteItem>,
            minInterval: Int,
            maxInterval: Int,
            noteCount: Int
    ): Chord {
        val intervals = intGenerator.generate(minInterval, maxInterval, noteCount)
        return Chord(listOf(baseNote).plus(
                intervals.map { interval: Int ->
                    noteHandler.getNoteFromInterval(baseNote, interval, allNotes)
                }
        ))
    }
}