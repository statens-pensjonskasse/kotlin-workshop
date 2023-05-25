package no.spk.workshop.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EplepaiServiceTest {

    val eplepaiService = EplepaiService()

    val eksempelEpler = listOf(
        Eple(true),
        Eple(false),
        Eple(true)
    )

    val eksempelTraer = listOf(
        Epletre(150, 2, mutableListOf(Eple(false))),
        Epletre(300, 3, mutableListOf(Eple(true))),
        Epletre(400, 4, mutableListOf(Eple(true), Eple(false)))
    )

    @Test
    fun `Kan bake eplepai med riktig smak`() {
        val result = eplepaiService.bakEplePai(eksempelEpler)
        assertThat(result.size).isEqualTo(3)
        assertThat(result.filter { it.smakerGodt }.size).isEqualTo(2)
    }

    @Test
    fun `Kan plukke kun modne epler og bake god eplepai`() {
        val result = eplepaiService.plukkOgBakEplePai(eksempelTraer)
        assertThat(result.size).isEqualTo(2)
        assertThat(result).doesNotContain(Eplepai(false))
    }
}