package lt.liusbl.earadviser.training.notes

import io.reactivex.Observable
import io.reactivex.Single

interface NoteRepository {
    fun getNoteList(): Single<List<NoteItem>>

    fun getFundamentalNote(): Observable<Note>

    fun getBaseNotes(): Observable<List<Note>>

    fun getRandomBaseNote(octave: Int): Single<NoteItem>
}