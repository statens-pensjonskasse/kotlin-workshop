package no.spk.workshop.kotlin

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test


internal class LambdaTest {

    @Test
    fun `Test 1, Lambda som produserer en hilsen for forskjellige navn`() {

        // skriv din lambda her:
        val helloGreeting = ...

        helloGreeting("World") shouldBe "Hello, World!"
        helloGreeting("Kotlin") shouldBe "Hello, Kotlin!"
    }

    @Test
    fun `Test 2, Lambda som summerer to tall`() {

        // skriv din lambda her:
        val sum = ...

        sum(2, 3) shouldBe 5
        sum(10, 5) shouldBe 15
    }

    val n = 5

    @Test
    fun `Test 3, Lambda som bruker variabelen over denne testen (closure)`() {

        // skriv din lambda her:
        val sum = ...

        sum(2) shouldBe 7
        sum(10) shouldBe 15
    }

    @Test
    fun `Test 4, Lambda som produserer en annen lambda, som multipliserer to tall`() {

        // skriv din lambda her:
        val times = ...

        val doubleIt = times(2)
        doubleIt(3) shouldBe 6
        doubleIt(5) shouldBe 10

        val tripleIt = times(3)
        tripleIt(3) shouldBe 9
        tripleIt(5) shouldBe 15
    }

    @Test
    fun `Test 5, Lambda som multipliserer et tall med én høyere enn et annet tall`() {

        // skriv din lambda her:
        val incrementByOne = ...
        val times = ...

        val doubleIt = times(2, incrementByOne)
        doubleIt(3) shouldBe 8
        doubleIt(5) shouldBe 12

        val tripleIt = times(3, incrementByOne)
        tripleIt(3) shouldBe 12
        tripleIt(5) shouldBe 18
    }
}
