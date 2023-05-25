package no.spk.workshop.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EpletreServiceTest {

    val epletreService = EpletreService()

    val eksempelEpler = listOf(
        Eple(true),
        Eple(false),
        Eple(true)
    )

    val eksempelTraer = listOf(
        Epletre(150, 2),
        Epletre(300, 3),
        Epletre(400, 4)
    )

    @Test
    fun `Kan filtrere modne epler`() {
        val result = epletreService.hentModneEpler(eksempelEpler)
        assertThat(result.size).isEqualTo(2)
        assertThat(result).doesNotContain(Eple(false))
    }

    @Test
    fun `Kan filtrere etter lengden av traerne`() {
        val result = epletreService.filtrerEtterLengde(eksempelTraer, 200, 350)
        assertThat(result.size).isEqualTo(1)
        assertThat(result.first().lengdeCm).isEqualTo(300)
    }
}