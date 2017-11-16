package lt.liusbl.earadviser.util

class CollectionShufflerImpl : CollectionShuffler {
    override fun <T> shuffle(list: List<T>) = list.toList()
}