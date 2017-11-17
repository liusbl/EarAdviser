package lt.liusbl.earadviser.training.notes

import io.reactivex.Observable
import lt.liusbl.earadviser.training.score.Score

interface NoteRepository {
    fun getNoteList(): Observable<List<Note>>

    fun getFundamentalNote(): Observable<Note>

    fun getBaseNotes(): Observable<List<Note>>
}