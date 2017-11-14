package lt.liusbl.earadviser.training.notes

import io.reactivex.Observable
import lt.liusbl.earadviser.training.score.Score

class NoteRepositoryImpl(private val scoreFactory: ScoreFactory) : NoteRepository {
    override fun getNoteList(): Observable<List<Note>> {
        return Observable.just(listOf(
                Note("C", Note.C, 0, 16.35),
                Note("C#", Note.C_SHARP, 0, 17.32),
                Note("D♭", Note.D_FLAT, 0, 17.32),
                Note("D", Note.D, 0, 18.35),
                Note("D#", Note.D_SHARP, 0, 19.45),
                Note("E♭", Note.E_FLAT, 0, 19.45),
                Note("E", Note.E, 0, 20.60),
                Note("F", Note.F, 0, 21.83),
                Note("F#", Note.F_SHARP, 0, 23.12),
                Note("G♭", Note.G_FLAT, 0, 23.12),
                Note("G", Note.G, 0, 24.50),
                Note("G#", Note.G_SHARP, 0, 25.96),
                Note("A♭", Note.A_FLAT, 0, 25.96),
                Note("A", Note.A, 0, 27.50),
                Note("A#", Note.A_SHARP, 0, 29.14),
                Note("B♭", Note.B_FLAT, 0, 29.14),
                Note("B", Note.B, 0, 30.87),
                Note("C", Note.C, 1, 32.70),
                Note("C#", Note.C_SHARP, 1, 34.65),
                Note("D♭", Note.D_FLAT, 1, 34.65),
                Note("D", Note.D, 1, 36.71),
                Note("D#", Note.D_SHARP, 1, 38.89),
                Note("E♭", Note.E_FLAT, 1, 38.89),
                Note("E", Note.E, 1, 41.20),
                Note("F", Note.F, 1, 43.65),
                Note("F#", Note.F_SHARP, 1, 46.25),
                Note("G♭", Note.G_FLAT, 1, 46.25),
                Note("G", Note.G, 1, 49.00),
                Note("G#", Note.G_SHARP, 1, 51.91),
                Note("A♭", Note.A_FLAT, 1, 51.91),
                Note("A", Note.A, 1, 55.00),
                Note("A#", Note.A_SHARP, 1, 58.27),
                Note("B♭", Note.B_FLAT, 1, 58.27),
                Note("B", Note.B, 1, 61.74),
                Note("C", Note.C, 2, 65.41),
                Note("C#", Note.C_SHARP, 2, 69.30),
                Note("D♭", Note.D_FLAT, 2, 69.30),
                Note("D", Note.D, 2, 73.42),
                Note("D#", Note.D_SHARP, 2, 77.78),
                Note("E♭", Note.E_FLAT, 2, 77.78),
                Note("E", Note.E, 2, 82.41),
                Note("F", Note.F, 2, 87.31),
                Note("F#", Note.F_SHARP, 2, 92.50),
                Note("G♭", Note.G_FLAT, 2, 92.50),
                Note("G", Note.G, 2, 98.00),
                Note("G#", Note.G_SHARP, 2, 103.83),
                Note("A♭", Note.A_FLAT, 2, 103.83),
                Note("A", Note.A, 2, 110.00),
                Note("A#", Note.A_SHARP, 2, 116.54),
                Note("B♭", Note.B_FLAT, 2, 116.54),
                Note("B", Note.B, 2, 123.47),
                Note("C", Note.C, 3, 130.81),
                Note("C#", Note.C_SHARP, 3, 138.59),
                Note("D♭", Note.D_FLAT, 3, 138.59),
                Note("D", Note.D, 3, 146.83),
                Note("D#", Note.D_SHARP, 3, 155.56),
                Note("E♭", Note.E_FLAT, 3, 155.56),
                Note("E", Note.E, 3, 164.81),
                Note("F", Note.F, 3, 174.61),
                Note("F#", Note.F_SHARP, 3, 185.00),
                Note("G♭", Note.G_FLAT, 3, 185.00),
                Note("G", Note.G, 3, 196.00),
                Note("G#", Note.G_SHARP, 3, 207.65),
                Note("A♭", Note.A_FLAT, 3, 207.65),
                Note("A", Note.A, 3, 220.00),
                Note("A#", Note.A_SHARP, 3, 233.08),
                Note("B♭", Note.B_FLAT, 3, 233.08),
                Note("B", Note.B, 3, 246.94),
                Note("C", Note.C, 4, 261.63),
                Note("C#", Note.C_SHARP, 4, 277.18),
                Note("D♭", Note.D_FLAT, 4, 277.18),
                Note("D", Note.D, 4, 293.66),
                Note("D#", Note.D_SHARP, 4, 311.13),
                Note("E♭", Note.E_FLAT, 4, 311.13),
                Note("E", Note.E, 4, 329.63),
                Note("F", Note.F, 4, 349.23),
                Note("F#", Note.F_SHARP, 4, 369.99),
                Note("G♭", Note.G_FLAT, 4, 369.99),
                Note("G", Note.G, 4, 392.00),
                Note("G#", Note.G_SHARP, 4, 415.30),
                Note("A♭", Note.A_FLAT, 4, 415.30),
                Note("A", Note.A, 4, 440.00),
                Note("A#", Note.A_SHARP, 4, 466.16),
                Note("B♭", Note.B_FLAT, 4, 466.16),
                Note("B", Note.B, 4, 493.88),
                Note("C", Note.C, 5, 523.25),
                Note("C#", Note.C_SHARP, 5, 554.37),
                Note("D♭", Note.D_FLAT, 5, 554.37),
                Note("D", Note.D, 5, 587.33),
                Note("D#", Note.D_SHARP, 5, 622.25),
                Note("E♭", Note.E_FLAT, 5, 622.25),
                Note("E", Note.E, 5, 659.25),
                Note("F", Note.F, 5, 698.46),
                Note("F#", Note.F_SHARP, 5, 739.99),
                Note("G♭", Note.G_FLAT, 5, 739.99),
                Note("G", Note.G, 5, 783.99),
                Note("G#", Note.G_SHARP, 5, 830.61),
                Note("A♭", Note.A_FLAT, 5, 830.61),
                Note("A", Note.A, 5, 880.00),
                Note("A#", Note.A_SHARP, 5, 932.33),
                Note("B♭", Note.B_FLAT, 5, 932.33),
                Note("B", Note.B, 5, 987.77),
                Note("C", Note.C, 6, 1046.50),
                Note("C#", Note.C_SHARP, 6, 1108.73),
                Note("D♭", Note.D_FLAT, 6, 1108.73),
                Note("D", Note.D, 6, 1174.66),
                Note("D#", Note.D_SHARP, 6, 1244.51),
                Note("E♭", Note.E_FLAT, 6, 1244.51),
                Note("E", Note.E, 6, 1318.51),
                Note("F", Note.F, 6, 1396.91),
                Note("F#", Note.F_SHARP, 6, 1479.98),
                Note("G♭", Note.G_FLAT, 6, 1479.98),
                Note("G", Note.G, 6, 1567.98),
                Note("G#", Note.G_SHARP, 6, 1661.22),
                Note("A♭", Note.A_FLAT, 6, 1661.22),
                Note("A", Note.A, 6, 1760.00),
                Note("A#", Note.A_SHARP, 6, 1864.66),
                Note("B♭", Note.B_FLAT, 6, 1864.66),
                Note("B", Note.B, 6, 1975.53),
                Note("C", Note.C, 7, 2093.00),
                Note("C#", Note.C_SHARP, 7, 2217.46),
                Note("D♭", Note.D_FLAT, 7, 2217.46),
                Note("D", Note.D, 7, 2349.32),
                Note("D#", Note.D_SHARP, 7, 2489.02),
                Note("E♭", Note.E_FLAT, 7, 2489.02),
                Note("E", Note.E, 7, 2637.02),
                Note("F", Note.F, 7, 2793.83),
                Note("F#", Note.F_SHARP, 7, 2959.96),
                Note("G♭", Note.G_FLAT, 7, 2959.96),
                Note("G", Note.G, 7, 3135.96),
                Note("G#", Note.G_SHARP, 7, 3322.44),
                Note("A♭", Note.A_FLAT, 7, 3322.44),
                Note("A", Note.A, 7, 3520.00),
                Note("A#", Note.A_SHARP, 7, 3729.31),
                Note("B♭", Note.B_FLAT, 7, 3729.31),
                Note("B", Note.B, 7, 3951.07),
                Note("C", Note.C, 8, 4186.01),
                Note("C#", Note.C_SHARP, 8, 4434.92),
                Note("D♭", Note.D_FLAT, 8, 4434.92),
                Note("D", Note.D, 8, 4698.63),
                Note("D#", Note.D_SHARP, 8, 4978.03),
                Note("E♭", Note.E_FLAT, 8, 4978.03),
                Note("E", Note.E, 8, 5274.04),
                Note("F", Note.F, 8, 5587.65),
                Note("F#", Note.F_SHARP, 8, 5919.91),
                Note("G♭", Note.G_FLAT, 8, 5919.91),
                Note("G", Note.G, 8, 6271.93),
                Note("G#", Note.G_SHARP, 8, 6644.88),
                Note("A♭", Note.A_FLAT, 8, 6644.88),
                Note("A", Note.A, 8, 7040.00),
                Note("A#", Note.A_SHARP, 8, 7458.62),
                Note("B♭", Note.B_FLAT, 8, 7458.62),
                Note("B", Note.B, 8, 7902.13)
        ))
    }

    override fun getScore(): Observable<Score> = Observable.just(scoreFactory.createScore())

    override fun getFundamentalNote(): Observable<Note> =
            Observable.just(Note("A", Note.A, 4, 440.00))

    override fun getBaseNotes(): Observable<List<Note>> {
        return Observable.just(listOf(
                Note("C", Note.C, 4, 261.63),
                Note("C#", Note.C_SHARP, 4, 277.18),
                Note("D", Note.D, 4, 293.66),
                Note("D#", Note.D_SHARP, 4, 311.13),
                Note("E", Note.E, 4, 329.63),
                Note("F", Note.F, 4, 349.23),
                Note("F#", Note.F_SHARP, 4, 369.99),
                Note("G", Note.G, 4, 392.00),
                Note("G#", Note.G_SHARP, 4, 415.30),
                Note("A", Note.A, 4, 440.00),
                Note("A#", Note.A_SHARP, 4, 466.16),
                Note("B", Note.B, 4, 493.88)
        ))
    }
}