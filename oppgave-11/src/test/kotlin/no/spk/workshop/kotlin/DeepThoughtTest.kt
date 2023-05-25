package no.spk.workshop.kotlin

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class DeepThoughtTest {

    @Test
    fun `Gets the answer as fast as possible`() {

        val deepThought = DeepThought()
        val answer = deepThought.calculateTheAnswerToLifeTheUniverseAndEverything()
        answer shouldBe 42
    }
}
