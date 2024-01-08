package no.spk.workshop.kotlin

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test


internal class LambdasTest {

    @Test
    fun `Test 1, Lambda som produserer en hilsen for forskjellige navn`() {

        val helloGreeting = Lambdas.helloGreeting()

        helloGreeting("World") shouldBe "Hello, World!"
        helloGreeting("Kotlin") shouldBe "Hello, Kotlin!"
    }

    @Test
    fun `Test 2, Lambda som summerer to tall`() {

        val sum = Lambdas.sum()

        sum(2, 3) shouldBe 5
        sum(10, 5) shouldBe 15
    }

    val n = 5

    @Test
    fun `Test 3, Lambda som bruker variabelen i scopet utenfor (closure)`() {

        val sum = Lambdas.sumWithN()

        sum(2) shouldBe 7
        sum(10) shouldBe 15
    }

    @Test
    fun `Test 4, Lambda som produserer en annen lambda, som multipliserer to tall`() {

        val times = Lambdas.times()

        val doubleIt = times(2)
        doubleIt(3) shouldBe 6
        doubleIt(5) shouldBe 10

        val tripleIt = times(3)
        tripleIt(3) shouldBe 9
        tripleIt(5) shouldBe 15
    }
}
