package lt.liusbl.earadviser.base.database

import android.content.Context
import android.support.annotation.RawRes
import lt.liusbl.earadviser.R
import lt.liusbl.earadviser.training.notes.NoteItem
import java.io.InputStream
import java.nio.charset.Charset

class DatabaseInitializerImpl(
        private val context: Context,
        private val bundleInitializer: DatabaseBundleInitializer,
        @RawRes private val bundleRes: Int
) : DatabaseInitializer {
    override fun initialize(appDatabase: AppDatabase) {
        val bundleJson = getBundledJson()
        initialize(bundleJson, NoteItem::class.java, appDatabase.noteItemDao(), HEADER_NOTES)
//        initialize(bundleJson, NoteItem::class.java, appDatabase.noteItemDao(), HEADER_BASE_NOTES)
    }

    private fun getBundledJson(): String {
        val inputStream: InputStream = context.resources.openRawResource(bundleRes)
        return inputStream.bufferedReader(Charset.defaultCharset()).readLines()
                .joinToString(separator = "")
    }

    private fun <T> initialize(
            bundleJson: String,
            genericClass: Class<T>,
            baseDao: BaseDao<T>,
            header: String
    ) {
        bundleInitializer.initialize(bundleJson, genericClass, baseDao, header)
    }

    companion object {
        private const val HEADER_NOTES = "notes"
        private const val HEADER_BASE_NOTES = "base_notes"
    }
}