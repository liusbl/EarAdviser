package lt.liusbl.earadviser.training.notes

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class NoteItem(
        @PrimaryKey(autoGenerate = true) var noteId: Int = 0,
        var name: String = "",
        var semitones: Long = 0,
        var octave: Int = 0,
        var frequency: Double = 0.0,
        var isBaseNote: Boolean = false
)