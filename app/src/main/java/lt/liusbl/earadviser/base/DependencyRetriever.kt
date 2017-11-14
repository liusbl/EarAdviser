package lt.liusbl.earadviser.base

import android.content.Context

class DependencyRetriever(private val context: Context) {
    val databaseHelper by lazy { }
}

val Context.dependencyRetriever: DependencyRetriever
    get() = (applicationContext as BaseApplication).dependencyRetriever