package lt.liusbl.earadviser.training.notes

import lt.liusbl.earadviser.training.score.Score

interface ScoreFactory {
    fun createScore(noteCount: Int): Score
}