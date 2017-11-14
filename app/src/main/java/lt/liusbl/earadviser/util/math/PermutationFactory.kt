package lt.liusbl.earadviser.util.math

import android.support.annotation.IntRange

interface PermutationFactory {
    fun create(
            @IntRange(from = 1) min: Int,
            @IntRange(from = 2) max: Int,
            @IntRange(from = 2, to = 17) count: Int
    ): List<List<Int>>
}