package lt.liusbl.earadviser.training

import io.reactivex.Observable
import lt.liusbl.earadviser.training.notes.Note
import lt.liusbl.earadviser.training.score.Chord

interface ChordHandler {
    fun getNextChord(baseNote: Note, allNote: List<Note>, noteCount: Int): Observable<Chord>

    fun getLastChord(): Observable<Chord>

    fun getPreviousChord(): Observable<Chord>
}