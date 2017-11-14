package lt.liusbl.earadviser.training.player

interface FrequencyAudioDataGenerator {
    fun generateAudioData(frequency: Double, durationInMillis: Long): List<Byte>
}