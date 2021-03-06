package lt.liusbl.earadviser.training.notes

import io.reactivex.Observable
import io.reactivex.Single

class NoteRepositoryImpl(/*private val noteItemDao: NoteItemDao*/) : NoteRepository {
    override fun getNoteList(): Single<List<NoteItem>> = Single.just(emptyList<NoteItem>())

    override fun getRandomBaseNote(octave: Int): Single<NoteItem> = Single.just(NoteItem())

    override fun getFundamentalNote(): Single<NoteItem> =
            Single.just(NoteItem())

    override fun getBaseNotes(): Observable<List<Note>> {
        return Observable.just(listOf(
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
        ))
    }

    companion object {
        private const val FUNDAMENTAL_FREQUENCY = 440.00
    }
}