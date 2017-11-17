package lt.liusbl.earadviser.training

import io.reactivex.Completable
import io.reactivex.Observable
import lt.liusbl.earadviser.training.score.Chord

class ChordRepositoryImpl : ChordRepository {
    private val chords: MutableList<Chord> = mutableListOf()
    private var position: Int = 0

    override fun insert(chord: Chord): Completable {
        return Completable.fromCallable {
            chords.add(chord)
            position++
        }
    }

    override fun queryLast(): Observable<Chord> = Observable.just(chords.last())

    override fun queryPrevious(): Observable<Chord> = Observable.just(chords[--position])
}