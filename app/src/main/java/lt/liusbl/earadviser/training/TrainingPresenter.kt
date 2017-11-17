package lt.liusbl.earadviser.training

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import lt.liusbl.earadviser.base.presenter.BasePresenterImpl
import lt.liusbl.earadviser.training.notes.Note

class TrainingPresenter(
        private val model: TrainingContract.Model,
        private val chordPlayer: ChordPlayer
) : TrainingContract.Presenter, BasePresenterImpl<TrainingContract.View>() {
    private val disposables: CompositeDisposable = CompositeDisposable()
    private var duration = 400L
    private var noteCount = 2
    private var isChordPlaying = false

    override fun onChordStartedListener() {
        isChordPlaying = true
    }

    override fun onChordFinishedListener() {
        isChordPlaying = false
    }

    override fun onLoad() {
        onView { showProgress() }
        model.getChords(noteCount)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ chords ->
                    chordPlayer.setChords(chords)
                    onView { hideProgress() }
                })
    }

    override fun onPlayChordAgainSelected() {
        if (!isChordPlaying) {
            chordPlayer.playAgain(duration)
        }
    }

    override fun onPlay440ButtonSelected() {
        if (!isChordPlaying) {
            model.getFundamentalNote().subscribe({ note ->
                chordPlayer.playBaseNote(note, duration)
            })
        }
    }

    override fun onShowResultButtonSelected() {
        onView {
            showResult(chordPlayer.getCurrentChord().notes
                    .joinToString(transform = Note::name, separator = "\n"))
        }
    }

    override fun onPlayInSequenceSelected() {
        if (!isChordPlaying) {
            chordPlayer.playAgainInSequence(duration)
        }
    }

    override fun onDiminishNotesSelected() {

    }

    override fun onIncreaseNotesSelected() {
        onView { showProgress() }
        model.getChords(++noteCount)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ chords ->
                    chordPlayer.setChords(chords)
                    onView { hideProgress() }
                })
    }

    override fun onPlayPreviousChordSelected() {
        if (!isChordPlaying) {
            chordPlayer.playPrevious(duration)
        }
    }

    override fun onPlayNextChordButtonSelected() {
        if (!isChordPlaying) {
            onView { resetResult() }
            chordPlayer.playNext(duration)
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