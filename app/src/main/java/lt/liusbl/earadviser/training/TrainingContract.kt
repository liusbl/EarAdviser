package lt.liusbl.earadviser.training

import io.reactivex.Observable
import lt.liusbl.earadviser.base.presenter.BasePresenter
import lt.liusbl.earadviser.util.widget.utils.progress.ProgressViewController
import lt.liusbl.earadviser.training.notes.Note
import lt.liusbl.earadviser.training.score.Chord

interface TrainingContract {
    interface View : () -> OnChordEventListener, ProgressViewController {
        fun showResult(result: String)

        fun setDuration(duration: Long)

        fun resetResult()
    }

    interface Presenter : BasePresenter<View>, OnChordEventListener {
        fun onPlayChordAgainSelected()

        fun onPlay440ButtonSelected()

        fun onShowResultButtonSelected()

        fun onPlayNextChordButtonSelected()

        fun onSpinnerProgressChanged(progress: Int)

        fun onPlayInSequenceSelected()

        fun onPlayPreviousChordSelected()

        fun onDiminishNotesSelected()

        fun onIncreaseNotesSelected()
    }

    interface Model {
        fun getChords(noteCount: Int): Observable<List<Chord>>

        fun getFundamentalNote(): Observable<Note>
    }
}