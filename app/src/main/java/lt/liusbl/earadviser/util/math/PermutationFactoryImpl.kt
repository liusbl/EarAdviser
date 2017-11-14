package lt.liusbl.earadviser.util.math

class PermutationFactoryImpl : PermutationFactory {
    override fun create(min: Int, max: Int, count: Int): List<List<Int>> {
        var initialList = (min..max).map { value -> listOf(value) }
        (0..count - 2).forEach {
            initialList = initialList.addPermutations(max)
        }
        return initialList.distinct()
    }

    private fun List<List<Int>>.addPermutations(max: Int): List<List<Int>> {
        return this.flatMap { list: List<Int> ->
            (list.last()..max).map { value: Int ->
                list.plus(value)
            }
        }.filter { list: List<Int> ->
            list[list.size - 1] != list[list.size - 2]
        }
    }
}