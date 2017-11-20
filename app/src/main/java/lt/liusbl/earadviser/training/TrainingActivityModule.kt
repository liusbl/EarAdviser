package lt.liusbl.earadviser.training

import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import lt.liusbl.earadviser.base.dagger.ActivityScope
import lt.liusbl.earadviser.base.scheduler.ComputationThread
import lt.liusbl.earadviser.base.scheduler.MainThread
import lt.liusbl.earadviser.training.notes.*
import lt.liusbl.earadviser.training.player.*
import java.util.*

@Module
abstract class TrainingActivityModule {
    @Binds
    @ActivityScope
    abstract fun bindView(activity: TrainingActivity): TrainingContract.View

    @Binds
    @ActivityScope
    abstract fun bindPresenter(presenter: TrainingPresenter): TrainingContract.Presenter

    @Binds
    @ActivityScope
    abstract fun bindOnChordEventListener(listener: TrainingActivity): () -> OnChordEventListener

    @Module
    companion object {
        @JvmStatic
        @ActivityScope
        @Provides
        fun provideNoteRepository(): NoteRepository = NoteRepositoryImpl()

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideNoteHandler(): NoteHandler = NoteHandlerImpl()

        @JvmStatic
        @ActivityScope
        @Provides
        fun providerFrequencyAudioDataGenerator(): FrequencyAudioDataGenerator =
                FrequencyAudioDataGeneratorImpl()

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideAudioTrackHandler(): AudioTrackHandler = AudioTrackHandlerImpl()

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideRandomSortedIntGenerator(): RandomSortedIntGenerator =
                RandomSortedIntGeneratorImpl(Random())

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideChordFactory(
                intGenerator: RandomSortedIntGenerator,
                noteHandler: NoteHandler
        ): ChordFactory = ChordFactoryImpl(intGenerator, noteHandler)

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideChordRepository(): ChordRepository = ChordRepositoryImpl()

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideChordHandler(
                chordFactory: ChordFactory,
                chordRepository: ChordRepository
        ): ChordHandler = ChordHandlerImpl(chordFactory, chordRepository)

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideNotePlayer(
                frequencyAudioDataGenerator: FrequencyAudioDataGenerator,
                audioTrackHandler: AudioTrackHandler
        ): NotePlayer = NotePlayerImpl(frequencyAudioDataGenerator, audioTrackHandler)

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideChordPlayer(
//                @MainThread mainScheduler: Scheduler,
//                @ComputationThread computationScheduler: Scheduler,
                notePlayer: NotePlayer,
                chordFactory: ChordHandler,
                trainingActivity: TrainingActivity
        ): ChordPlayer = ChordPlayerImpl(trainingActivity,  notePlayer, chordFactory)
    }
}
