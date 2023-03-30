package no.spk.workshop.kotlin

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class Oppgave1Test {

    @Test
    fun `Henter hilsen`() {
        val greeting = getGreeting("World")
        greeting shouldBe "Hello, World!"
    }
}
