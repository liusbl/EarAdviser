package lt.liusbl.earadviser.training

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.functions.BiFunction
import lt.liusbl.earadviser.training.notes.Note
import lt.liusbl.earadviser.training.notes.NoteHandler
import lt.liusbl.earadviser.training.notes.NoteRepository
import lt.liusbl.earadviser.training.score.Chord
import lt.liusbl.earadviser.training.score.Intervals
import lt.liusbl.earadviser.training.score.Score

class TrainingModel(
        private val scheduler: Scheduler,
        private val noteRepository: NoteRepository,
        private val noteHandler: NoteHandler
) : TrainingContract.Model {
    override fun getChords(): Observable<List<Chord>> {
        return Observable.zip(noteRepository.getNoteList(), noteRepository.getScore(),
                BiFunction { allNotes: List<Note>, score: Score ->
                    createChords(score, allNotes)
                }).observeOn(scheduler)
    }

    private fun createChords(score: Score, allNotes: List<Note>): List<Chord> {
        return score.baseNotes.zip(score.listOfIntervals, { baseNote: Note, intervals: Intervals ->
            Chord(listOf(baseNote).plus(intervals.values.map { interval: Int ->
                noteHandler.getNoteFromInterval(baseNote, interval, allNotes)
            }))
        })
    }

    override fun getFundamentalNote(): Observable<Note> {
        return noteRepository.getFundamentalNote()
                .observeOn(scheduler)
    }
}