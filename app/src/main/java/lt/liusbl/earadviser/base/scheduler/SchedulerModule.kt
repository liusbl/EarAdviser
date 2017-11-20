package lt.liusbl.earadviser.base.scheduler

import android.support.annotation.MainThread
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

//@Module
//abstract class SchedulerModule {
//    @Module
//    companion object {
//        @JvmStatic
//        @MainThread
//        @Singleton
//        @Provides
//        fun provideUiScheduler(): Scheduler = AndroidSchedulers.mainThread()
//
//        @JvmStatic
//        @ComputationThread
//        @Singleton
//        @Provides
//        fun provideComputationScheduler(): Scheduler = Schedulers.computation()
//
//        @JvmStatic
//        @IoThread
//        @Singleton
//        @Provides
//        fun provideIoScheduler(): Scheduler = Schedulers.io()
//    }
//}