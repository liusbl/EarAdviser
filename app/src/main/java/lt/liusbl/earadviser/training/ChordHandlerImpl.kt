package lt.liusbl.earadviser.training

import io.reactivex.Observable
import lt.liusbl.earadviser.training.notes.Note
import lt.liusbl.earadviser.training.score.Chord

class ChordHandlerImpl(
        private val chordFactory: ChordFactory,
        private val chordRepository: ChordRepository
) : ChordHandler {
    override var baseNote: Note = Note()
    override var allNotes: List<Note> = emptyList()
    override var minInterval: Int = 2
    override var maxInterval: Int = 17
    override var noteCount: Int = 1

    override fun getNextChord(): Observable<Chord> {
        val nextChord = chordFactory.create(baseNote, allNotes, minInterval, maxInterval, noteCount)
        return Observable.fromCallable {
            chordRepository.insert(nextChord)
            nextChord
        }
    }

    override fun getLastChord() = chordRepository.queryLast()

    override fun getPreviousChord() = chordRepository.queryPrevious()
}