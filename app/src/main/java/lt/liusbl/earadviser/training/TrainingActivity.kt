package lt.liusbl.earadviser.training

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_training.*
import lt.liusbl.earadviser.R
import lt.liusbl.earadviser.R.id.*
import lt.liusbl.earadviser.base.dagger.BaseActivity
import lt.liusbl.earadviser.base.dependencyRetriever
import lt.liusbl.earadviser.training.notes.NoteHandlerImpl
import lt.liusbl.earadviser.training.notes.NoteRepositoryImpl
import lt.liusbl.earadviser.training.notes.RandomSortedIntGeneratorImpl
import lt.liusbl.earadviser.training.player.AudioTrackHandlerImpl
import lt.liusbl.earadviser.training.player.FrequencyAudioDataGeneratorImpl
import lt.liusbl.earadviser.training.player.NotePlayerImpl
import java.util.*

class TrainingActivity : BaseActivity(), TrainingContract.View {
    private lateinit var presenter: TrainingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_training)
        initializePresenter()
        setUpOnClickListener()
    }

    private fun initializePresenter() {
        val appDatabase = applicationContext.dependencyRetriever.appDatabase
        val noteRepository = NoteRepositoryImpl(appDatabase.noteItemDao())
        val noteHandler = NoteHandlerImpl()
        val frequencyAudioDataGenerator = FrequencyAudioDataGeneratorImpl()
        val audioTrackHandler = AudioTrackHandlerImpl()
        val intGenerator = RandomSortedIntGeneratorImpl(Random())
        val chordFactory = ChordFactoryImpl(intGenerator, noteHandler)
        val chordRepository = ChordRepositoryImpl()
        val chordHandler = ChordHandlerImpl(chordFactory, chordRepository)
        val notePlayer = NotePlayerImpl(frequencyAudioDataGenerator, audioTrackHandler)
        val chordPlayer = ChordPlayerImpl(this, AndroidSchedulers.mainThread(),
                Schedulers.computation(), notePlayer, chordHandler)
        presenter = TrainingPresenter(chordPlayer, noteRepository)
        presenter.takeView(this)
    }

    override fun invoke() = presenter

    private fun setUpOnClickListener() {
        trainingPlayChordAgainImage.setOnClickListener { presenter.onPlayChordAgainSelected() }
        trainingPlayInSequenceImage.setOnClickListener { presenter.onPlayInSequenceSelected() }
        trainingPlay440Button.setOnClickListener { presenter.onPlay440ButtonSelected() }
        trainingShowResultButton.setOnClickListener { presenter.onShowResultButtonSelected() }
        trainingPlayPreviousChordImage.setOnClickListener {
            presenter.onPlayPreviousChordSelected()
        }
        trainingPlayNextChordImage.setOnClickListener { presenter.onPlayNextChordButtonSelected() }
        trainingDiminishNotesImage.setOnClickListener { presenter.onDiminishNotesSelected() }
        trainingIncreaseNotesImage.setOnClickListener { presenter.onIncreaseNotesSelected() }
        trainingDurationSeekBar.setOnSeekBarChangeListener(createOnSeekBarChangeListener())
    }

    private fun createOnSeekBarChangeListener(): SeekBar.OnSeekBarChangeListener {
        return object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                presenter.onSpinnerProgressChanged(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // No need to implement
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // No need to implement
            }
        }
    }

    override fun showResult(result: String) {
        trainingResultsTextView.text = result
    }

    override fun setDuration(duration: Long) {
        trainingDurationTextView.text = getString(R.string.training_text_duration_format,
                duration.toInt())
    }

    override fun resetResult() {
        trainingResultsTextView.text = ""
    }

    override fun onDestroy() {
        presenter.dropView()
        super.onDestroy()
    }

    override fun showProgress() {
        progressBar.showProgress()
    }

    override fun hideProgress() {
        progressBar.hideProgress()
    }

    companion object {
        fun newInstance(context: Context) = Intent(context, TrainingActivity::class.java)
    }
}
