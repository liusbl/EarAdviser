package lt.liusbl.earadviser.training

import io.reactivex.Observable
import lt.liusbl.earadviser.training.notes.Note
import lt.liusbl.earadviser.training.score.Chord

interface ChordHandler {
    var allNotes: List<Note>
    var baseNote: Note
    var minInterval: Int
    var maxInterval: Int
    var noteCount: Int

    fun getNextChord(): Observable<Chord>

    fun getLastChord(): Observable<Chord>

    fun getPreviousChord(): Observable<Chord>
}