package no.spk.workshop.kotlin

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class KotlinGreetingProviderTest {

    @Test
    fun `Provides correct greeting`() {
        val greetingProvider = KotlinGreetingProvider("Kotlin")
        val greeting = greetingProvider.greeting()
        greeting shouldBe "Hello, Kotlin!"
    }
}
