package lt.liusbl.earadviser.base.database

import android.content.Context
import android.support.annotation.RawRes
import lt.liusbl.earadviser.R
import lt.liusbl.earadviser.training.notes.NoteItem
import java.io.InputStream
import java.nio.charset.Charset

class DatabaseInitializerImpl(
        private val context: Context,
        private val bundleInitializer: DatabaseBundleInitializer
) : DatabaseInitializer {
    override fun initialize(appDatabase: AppDatabase) {
        val notesJsonObject = getBundledJson(context, R.raw.notes)
        bundleInitializer.initialize(notesJsonObject, NoteItem::class.java,
                appDatabase.noteItemDao(), HEADER_NOTES)
    }

    private fun getBundledJson(context: Context, @RawRes bundleRes: Int): String {
        val inputStream: InputStream = context.resources.openRawResource(bundleRes)
        return inputStream.bufferedReader(Charset.defaultCharset()).readLines()
                .joinToString(separator = "")
    }

    companion object {
        private const val HEADER_NOTES = "notes"
    }
}