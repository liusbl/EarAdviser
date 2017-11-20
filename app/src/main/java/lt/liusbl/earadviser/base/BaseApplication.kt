package lt.liusbl.earadviser.base

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import lt.liusbl.earadviser.base.dagger.DaggerAppComponent

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
            DaggerAppComponent.builder().create(this)
}