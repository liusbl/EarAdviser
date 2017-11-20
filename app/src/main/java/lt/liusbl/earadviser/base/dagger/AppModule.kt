package lt.liusbl.earadviser.base.dagger

import android.content.Context
import android.content.res.Resources
import dagger.Binds
import dagger.Module
import dagger.Provides
import lt.liusbl.earadviser.base.BaseApplication

@Module
abstract class AppModule {
    @Binds abstract fun bindContext(app: BaseApplication): Context

    @Module
    companion object {
        @JvmStatic @Provides
        fun provideResources(context: Context): Resources = context.resources
    }
}