package no.spk.workshop.kotlin

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.assertj.core.api.Assertions.assertThat


internal class MedlemServiceTest {

    @Autowired
    lateinit var medlemService: MedlemService

    @Test
    fun `Kan generere et medlem med Java`() {
        val brukernavn = "Arne"
        val result = medlemService.genererJavaMedlem(brukernavn)
        assertThat(result.brukernavn).isEqualTo(brukernavn)
    }

    @Test
    fun `Kan generere et medlem med Kotlin`() {
        val brukernavn = "Arne"
        val result = medlemService.genererKotlinMedlem(brukernavn)
        assertThat(result.brukernavn).isEqualTo(brukernavn)
    }
}
