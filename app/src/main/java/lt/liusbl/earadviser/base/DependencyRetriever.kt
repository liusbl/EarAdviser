package lt.liusbl.earadviser.base

import android.content.Context
import com.google.gson.Gson
import lt.liusbl.earadviser.R
import lt.liusbl.earadviser.base.database.DatabaseBundleInitializerImpl
import lt.liusbl.earadviser.base.database.DatabaseFactoryImpl
import lt.liusbl.earadviser.base.database.DatabaseInitializerImpl

class DependencyRetriever(private val context: Context) {
    val gson by lazy { Gson() }

    val appDatabase by lazy {
        val bundleInitializer = DatabaseBundleInitializerImpl(gson)
        val initializer = DatabaseInitializerImpl(context, bundleInitializer, R.raw.bundle)
        DatabaseFactoryImpl(context, initializer).create()
    }
}

val Context.dependencyRetriever: DependencyRetriever
    get() = (applicationContext as BaseApplication).dependencyRetriever