package lt.liusbl.earadviser.util

interface CollectionShuffler {
    fun <T> shuffle(list: Collection<T>): List<T>
}