package no.spk.workshop.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrimtallServiceTest {

    private val primtallService = PrimtallService()

    @Test
    fun `Kan finne riktige primtall`() {
        val fasit = listOf(2,3,5,7,11)
        val resultat = primtallService.kalkulerPrimtall(11)
        assertThat(resultat).containsExactlyElementsOf(fasit)
    }

    @Test
    fun `Kan finne riktige primtall lavt edgecase 0`() {
        val fasit = emptyList<Int>()
        val resultat = primtallService.kalkulerPrimtall(0)
        assertThat(resultat).containsExactlyElementsOf(fasit)
    }

    @Test
    fun `Kan finne riktige primtall lavt edgecase 1`() {
        val fasit = emptyList<Int>()
        val resultat = primtallService.kalkulerPrimtall(1)
        assertThat(resultat).containsExactlyElementsOf(fasit)
    }

    @Test
    fun `Kan finne riktige primtall lavt edgecase 2`() {
        val fasit = listOf(2)
        val resultat = primtallService.kalkulerPrimtall(2)
        assertThat(resultat).containsExactlyElementsOf(fasit)
    }

    @Test
    fun `Tidstest for store verdier`() {
        val stortTestTall = 1000000
        val startTid = System.currentTimeMillis()
        val resultat = primtallService.kalkulerPrimtall(stortTestTall)
        println("Tidsbruk for primtall opp til $stortTestTall: ${System.currentTimeMillis() - startTid} ms")
        assertThat(resultat).isNotEmpty
    }
}