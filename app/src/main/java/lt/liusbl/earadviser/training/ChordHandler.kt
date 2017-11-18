package lt.liusbl.earadviser.training

import io.reactivex.Observable
import lt.liusbl.earadviser.training.notes.NoteItem
import lt.liusbl.earadviser.training.score.Chord

interface ChordHandler {
    fun getNextChord(baseNote: NoteItem, allNote: List<NoteItem>, noteCount: Int): Observable<Chord>

    fun getLastChord(): Observable<Chord>

    fun getPreviousChord(): Observable<Chord>
}