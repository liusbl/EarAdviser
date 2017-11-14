package lt.liusbl.earadviser.training.notes

import lt.liusbl.earadviser.training.score.Intervals
import lt.liusbl.earadviser.training.score.Score
import lt.liusbl.earadviser.util.CollectionShuffler
import lt.liusbl.earadviser.util.math.PermutationFactory

class ScoreFactoryImpl(
        private val permutationFactory: PermutationFactory,
        private val shuffler: CollectionShuffler
) : ScoreFactory {
    override fun createScore(): Score {
        val baseNotes = listOf(
                Note("C", Note.C, 4, 261.63),
                Note("C#", Note.C_SHARP, 4, 277.18),
                Note("D", Note.D, 4, 293.66),
                Note("D#", Note.D_SHARP, 4, 311.13),
                Note("E", Note.E, 4, 329.63),
                Note("F", Note.F, 4, 349.23),
                Note("F#", Note.F_SHARP, 4, 369.99),
                Note("G", Note.G, 4, 392.00),
                Note("G#", Note.G_SHARP, 4, 415.30),
                Note("A", Note.A, 4, 440.00),
                Note("A#", Note.A_SHARP, 4, 466.16),
                Note("B", Note.B, 4, 493.88)
        )
        val permutations = permutationFactory.create(2, 17, 4)

        val listOfIntervals = permutations.map { aa: List<Int> ->
            Intervals(aa)
        }
        val newBaseNotes = mutableListOf<Note>()
        val newIntervals = mutableListOf<Intervals>()
        listOfIntervals.forEach { intervals: Intervals ->
            baseNotes.forEach { note: Note ->
                newBaseNotes.add(note)
                newIntervals.add(intervals)
            }
        }

        return Score(shuffler.shuffle(newBaseNotes), shuffler.shuffle(newIntervals))
    }
}