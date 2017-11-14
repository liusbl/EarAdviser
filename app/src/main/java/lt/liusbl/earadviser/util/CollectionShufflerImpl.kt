package lt.liusbl.earadviser.util

class CollectionShufflerImpl : CollectionShuffler {
    override fun <T> shuffle(list: Collection<T>) = list.shuffled()
}