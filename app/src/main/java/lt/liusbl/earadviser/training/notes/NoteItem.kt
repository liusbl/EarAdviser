package lt.liusbl.earadviser.training.notes

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class NoteItem(
        @PrimaryKey(autoGenerate = true) val noteId: Int,
        val name: String,
        val semitones: Long,
        val octave: Int,
        val frequency: Double
)