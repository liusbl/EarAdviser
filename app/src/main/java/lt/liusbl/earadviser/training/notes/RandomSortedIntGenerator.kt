package lt.liusbl.earadviser.training.notes

interface RandomSortedIntGenerator {
    fun generate(min: Int, max: Int, count: Int): List<Int>
}