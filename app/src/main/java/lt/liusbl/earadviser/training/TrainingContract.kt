package lt.liusbl.earadviser.training

import lt.liusbl.earadviser.base.presenter.BasePresenter
import lt.liusbl.earadviser.util.widget.utils.progress.ProgressViewController

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
}