package lt.liusbl.earadviser.training

import io.reactivex.Completable
import io.reactivex.Observable
import lt.liusbl.earadviser.training.score.Chord

interface ChordRepository {
    fun insert(chord: Chord): Completable

    fun queryLast(): Observable<Chord>

    fun queryPrevious(): Observable<Chord>
}