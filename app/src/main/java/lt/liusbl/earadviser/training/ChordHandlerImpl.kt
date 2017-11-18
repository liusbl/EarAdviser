package lt.liusbl.earadviser.training

import io.reactivex.Observable
import lt.liusbl.earadviser.training.notes.Note
import lt.liusbl.earadviser.training.score.Chord

class ChordHandlerImpl(
        private val chordFactory: ChordFactory,
        private val chordRepository: ChordRepository
) : ChordHandler {
    companion object {
        private const val MIN_INTERVAL: Int = 2
        private const val MAX_INTERVAL: Int = 17
    }

    override fun getNextChord(
            baseNote: Note,
            allNote: List<Note>,
            noteCount: Int
    ): Observable<Chord> {
        val nextChord = chordFactory.create(baseNote, allNote,
                MIN_INTERVAL, MAX_INTERVAL, noteCount)
        return Observable.fromCallable {
            chordRepository.insert(nextChord)
                    .subscribe()
            nextChord
        }
    }

    override fun getLastChord() = chordRepository.queryLast()

    override fun getPreviousChord() = chordRepository.queryPrevious()
}