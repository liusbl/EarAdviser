package lt.liusbl.earadviser.base

import lt.liusbl.earadviser.BuildTypeApplication

class BaseApplication : BuildTypeApplication() {
    lateinit var dependencyRetriever: DependencyRetriever private set

    override fun onCreate() {
        super.onCreate()
        dependencyRetriever = DependencyRetriever(this)
    }
}