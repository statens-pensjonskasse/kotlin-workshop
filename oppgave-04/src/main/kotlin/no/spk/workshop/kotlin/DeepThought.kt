package no.spk.workshop.kotlin

import java.time.Duration
import java.util.concurrent.atomic.AtomicReference
import kotlin.random.Random

class DeepThought {

    private val answer = AtomicReference<Int>(null)

    fun calculateTheAnswerToLifeTheUniverseAndEverything(): Int {
        Thread {
            val secondsToSleep = Random.nextLong(1, 5)
            val duration = Duration.ofSeconds(secondsToSleep)
            Thread.sleep(duration.toMillis())
            answer.set(42)
        }.start()
        return answer.get() ?: throw RuntimeException("Still calculating...")
    }
}
