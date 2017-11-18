package lt.liusbl.earadviser.training.notes

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import io.reactivex.Single
import lt.liusbl.earadviser.base.database.BaseDao

@Dao
interface NoteItemDao : BaseDao<NoteItem> {
    @Query("SELECT * FROM NoteItem")
    fun queryAll(): Single<List<NoteItem>>

    @Query("SELECT * FROM NoteItem WHERE octave = :octave")
    fun queryByOctave(octave: Int): Single<List<NoteItem>>
}