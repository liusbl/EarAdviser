package lt.liusbl.earadviser.base.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import lt.liusbl.earadviser.training.TrainingActivity
import lt.liusbl.earadviser.training.TrainingActivityModule

@Module
abstract class ActivitiesModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(TrainingActivityModule::class))
    abstract fun bindTrainingActivity(): TrainingActivity
}