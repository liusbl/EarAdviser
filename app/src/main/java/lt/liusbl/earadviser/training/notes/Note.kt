package lt.liusbl.earadviser.training.notes

import android.annotation.SuppressLint
import android.support.annotation.IntDef
import android.support.annotation.IntRange

data class Note(
        val name: String = "",
        @NoteName val semitones: Long = -1,
        @IntRange(from = 0, to = 8) val octave: Int = 0,
        val frequency: Double = 0.0
) {
    @SuppressLint("UniqueConstants")
    @IntDef(C, C_SHARP, D_FLAT, D, D_SHARP, E_FLAT, E, F, F_SHARP, G_FLAT, G, G_SHARP,
            A_FLAT, A, A_SHARP, B_FLAT, B)
    annotation class NoteName

    companion object {
        const val C: Long = 0
        const val C_SHARP: Long = 1
        const val D_FLAT: Long = 1
        const val D: Long = 2
        const val D_SHARP: Long = 3
        const val E_FLAT: Long = 3
        const val E: Long = 4
        const val F: Long = 5
        const val F_SHARP: Long = 6
        const val G_FLAT: Long = 6
        const val G: Long = 7
        const val G_SHARP: Long = 8
        const val A_FLAT: Long = 8
        const val A: Long = 9
        const val A_SHARP: Long = 10
        const val B_FLAT: Long = 10
        const val B: Long = 11
    }
}