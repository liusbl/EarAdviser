package lt.liusbl.earadviser.util

import java.util.*

class CollectionShufflerImpl : CollectionShuffler {
    override fun <T> shuffle(list: List<T>): List<T> {
        val mutableList = list.toMutableList()
        Collections.shuffle(mutableList)
        return mutableList.toList()
    }
}