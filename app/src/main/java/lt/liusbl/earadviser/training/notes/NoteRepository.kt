package lt.liusbl.earadviser.training.notes

import io.reactivex.Observable

interface NoteRepository {
    fun getNoteList(): Observable<List<Note>>

    fun getFundamentalNote(): Observable<Note>

    fun getBaseNotes(): Observable<List<Note>>

    fun getRandomBaseNote(): Observable<Note>
}