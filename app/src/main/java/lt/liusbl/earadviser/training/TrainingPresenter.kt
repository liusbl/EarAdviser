package lt.liusbl.earadviser.training

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import lt.liusbl.earadviser.base.presenter.BasePresenterImpl
import lt.liusbl.earadviser.training.notes.NoteItem
import lt.liusbl.earadviser.training.notes.NoteRepository

class TrainingPresenter(
        private val chordPlayer: ChordPlayer,
        private val noteRepository: NoteRepository
) : TrainingContract.Presenter, BasePresenterImpl<TrainingContract.View>() {
    private val disposables: CompositeDisposable = CompositeDisposable()
    private var duration = 400L
    private var noteCount = 1
    private var isChordPlaying = false

    override fun onChordStartedListener() {
        isChordPlaying = true
    }

    override fun onChordFinishedListener() {
        isChordPlaying = false
    }

    override fun onPlayChordAgainSelected() {
        if (!isChordPlaying) {
            chordPlayer.playAgain(duration)
        }
    }

    override fun onPlay440ButtonSelected() {
        if (!isChordPlaying) {
            noteRepository.getFundamentalNote()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe { noteItem ->
                        chordPlayer.playBaseNote(noteItem, duration)
                    }
        }
    }

    override fun onShowResultButtonSelected() {
        onView {
            showResult(chordPlayer.getCurrentChord().notes
                    .joinToString(transform = NoteItem::name, separator = "\n"))
        }
    }

    override fun onPlayInSequenceSelected() {
        if (!isChordPlaying) {
            chordPlayer.playAgainInSequence(duration)
        }
    }

    override fun onDiminishNotesSelected() {
        noteCount--
    }

    override fun onIncreaseNotesSelected() {
        noteCount++
    }

    override fun onPlayPreviousChordSelected() {
        if (!isChordPlaying) {
            chordPlayer.playPrevious(duration)
        }
    }

    override fun onPlayNextChordButtonSelected() {
        if (!isChordPlaying) {
            onView { resetResult() }
            Single.zip(noteRepository.getRandomBaseNote(4), noteRepository.getNoteList(),
                    BiFunction { baseNote: NoteItem, allNotes: List<NoteItem> ->
                        chordPlayer.playNext(baseNote, allNotes, noteCount, duration)
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe { t1: Unit?, t2: Throwable? ->
                        // todo hide progress
                    }
        }
    }

    override fun onSpinnerProgressChanged(progress: Int) {
        duration = progress.toLong()
        onView { setDuration(duration) }
    }

    override fun dropView() {
        disposables.clear()
        super.dropView()
    }
}