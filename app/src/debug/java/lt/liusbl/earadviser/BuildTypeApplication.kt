package lt.liusbl.earadviser

import android.app.Application
import com.facebook.stetho.Stetho
import com.facebook.stetho.timber.StethoTree
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

open class BuildTypeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build())
        Timber.plant(Timber.DebugTree())
        Timber.plant(StethoTree())

        LeakCanary.install(this)
    }
}
