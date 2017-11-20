package lt.liusbl.earadviser.training

import dagger.Binds
import dagger.Module
import dagger.Provides
import lt.liusbl.earadviser.base.dagger.ActivityScope

@Module
abstract class TrainingActivityModule {
    @Binds
    @ActivityScope
    abstract fun bindView(activity: TrainingActivity): TrainingContract.View

    @Binds
    @ActivityScope
    abstract fun bindPresenter(presenter: TrainingPresenter): TrainingContract.Presenter

//    @Module
//    companion object {
//        @JvmStatic
//        @ActivityScope
//        @Provides
//        fun provideTextFormatter(): TextFormatter = TextFormatterImpl()
//    }
}
