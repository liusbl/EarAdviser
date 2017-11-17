package lt.liusbl.earadviser.training.notes

import java.util.*

class RandomSortedIntGeneratorImpl(private val random: Random) : RandomSortedIntGenerator {
    override fun generate(min: Int, max: Int, count: Int): List<Int> {
        var list = list(min, max, count)
        while (list.size != count) {
            list = list(min, max, count)
        }
        return list
    }

    private fun list(min: Int, max: Int, count: Int) =
            (1..count).map { random.nextInt(max - min) + min }.distinct().sorted()
}