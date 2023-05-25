package no.spk.workshop.kotlin

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class GreetingProviderTest {

    @Test
    fun `Provides correct greeting`() {
        val greetingProvider = GreetingProvider()
        val greeting = greetingProvider.greeting("World")
        greeting shouldBe "Hello, World!"
    }
}
