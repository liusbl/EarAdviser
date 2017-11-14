package lt.liusbl.earadviser.training.player

import kotlin.experimental.and

class FrequencyAudioDataGeneratorImpl : FrequencyAudioDataGenerator {
    override fun generateAudioData(frequency: Double, durationInMillis: Long): List<Byte> {
        val sampleCount = SAMPLE_RATE * durationInMillis / 1000

        val samples = (0 until sampleCount).map { index ->
            Math.sin((2 * Math.PI - .001) * index / (SAMPLE_RATE / frequency))
        }
        val ramp = sampleCount / 20

        val firstPart = (0 until ramp).flatMap { i ->
            val value = (multiplySamples(samples, i) * i / ramp).toShort()
            list(value)
        }

        val secondPart = (ramp until sampleCount - ramp).flatMap { i ->
            val value = multiplySamples(samples, i).toShort()
            list(value)
        }

        val thirdPart = (sampleCount - ramp until sampleCount).flatMap { i ->
            val value = (multiplySamples(samples, i) * (sampleCount - i) / ramp).toShort()
            list(value)
        }

        return firstPart.plus(secondPart).plus(thirdPart)
    }

    private fun multiplySamples(samples: List<Double>, i: Long) = samples[i.toInt()] * 32767

    private fun list(value: Short): List<Byte> {
        return listOf((value and 0x00ff).toByte(),
                (value and 0xff00.toShort()).toInt().ushr(8).toByte())
    }

    companion object {
        const val SAMPLE_RATE: Long = 8000
    }
}