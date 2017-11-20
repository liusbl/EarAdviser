package lt.liusbl.earadviser.base

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

abstract class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
            DaggerAppComponent.builder().create(this)
}