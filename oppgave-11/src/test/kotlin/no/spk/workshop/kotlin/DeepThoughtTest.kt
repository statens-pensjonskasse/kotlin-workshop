package no.spk.workshop.kotlin

import io.kotest.assertions.timing.eventually
import io.kotest.common.runBlocking
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import kotlin.time.Duration.Companion.seconds

internal class DeepThoughtTest {

    @Test
    fun `Gets the answer as fast as possible`() = runBlocking {

        val deepThought = DeepThought()
        eventually(30.seconds) {
            val answer = deepThought.calculateTheAnswerToLifeTheUniverseAndEverything()
            answer shouldBe 42
        }
    }
}
