package lt.liusbl.earadviser.training

import io.reactivex.disposables.CompositeDisposable
import lt.liusbl.earadviser.base.presenter.BasePresenterImpl
import lt.liusbl.earadviser.training.notes.Note
import lt.liusbl.earadviser.training.score.Chord

class TrainingPresenter(
        private val model: TrainingContract.Model,
        private val chordPlayer: ChordPlayer
) : TrainingContract.Presenter, BasePresenterImpl<TrainingContract.View>() {
    private val disposables: CompositeDisposable = CompositeDisposable()
    private var duration = 400L
    private var chords: List<Chord>? = null
    private var chordPosition = 0
    private var isChordPlaying = false

    override fun onChordStartedListener() {
        isChordPlaying = true
    }

    override fun onChordFinishedListener() {
        isChordPlaying = false
    }

    override fun onLoad() {
        model.getChords()
                .subscribe(chordPlayer::setChords)
    }

    override fun onPlayChordAgainSelected() {
        if (!isChordPlaying) {
            chordPlayer.playAgain(duration)
        }
    }

    override fun onPlay440ButtonSelected() {
        if (!isChordPlaying) {
            model.getBaseNote().subscribe({ note -> chordPlayer.playBaseNote(note, duration) })
        }
    }

    override fun onShowResultButtonSelected() {
        val chords = this.chords ?: listOf()
        onView {
            showResult(chords[chordPosition].notes
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