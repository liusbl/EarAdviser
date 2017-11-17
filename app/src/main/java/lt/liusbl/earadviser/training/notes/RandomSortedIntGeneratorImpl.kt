package lt.liusbl.earadviser.training.notes

import java.util.*

class RandomSortedIntGeneratorImpl(private val random: Random) : RandomSortedIntGenerator {
    override fun generate(min: Int, max: Int, count: Int): List<Int> {
        var list = list(count, max, min)
        while (list.size != count) {
            list = list(count, max, min)
        }
        return list
    }

    private fun list(count: Int, max: Int, min: Int) =
            (1..count).map { random.nextInt(max - min) + min }.distinct().sorted()
}