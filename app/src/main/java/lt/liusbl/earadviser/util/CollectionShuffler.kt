package lt.liusbl.earadviser.util

interface CollectionShuffler {
    fun <T> shuffle(list: List<T>): List<T>
}