package no.spk.workshop.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HumanResourcesTest {
    val dagligLeder = Ansatt("SjefenOverAlleSjefer")
    val sjef = Ansatt("Mellomsjef")
    val avdeling = Avdeling("forbrukerkontakt", sjef)

    val ola = Ansatt("Ola")
    val kari = Ansatt("Kari", avdeling)

    val sjefHenterJava = HumanResourcesJava(dagligLeder)
    val sjefHenterKotlin = HumanResourcesKotlin(dagligLeder)

    @Test
    fun `a) Kan hente navnet til sjefen dersom ansatt har en avdeling med en sjef`() {
        val funnetSjef = sjefHenterJava.hentSjefenTil(kari)
        assertThat(funnetSjef).isEqualTo(sjef.navn)

        val funnetSjefKotlin = sjefHenterKotlin.hentSjefenTil(kari)
        assertThat(funnetSjefKotlin).isEqualTo(sjef.navn)
    }

    @Test
    fun `a) Kan ikke hente navnet til sjefen dersom ansatt ikke har en avdeling eller avdeling med sjef`() {
        val funnetSjef = sjefHenterJava.hentSjefenTil(ola)
        assertThat(funnetSjef).isEqualTo(null)

        val funnetSjefKotlin = sjefHenterKotlin.hentSjefenTil(ola)
        assertThat(funnetSjefKotlin).isEqualTo(null)
    }

    @Test
    fun `b) Dersom avdelingen til en ansatt har en sjef er dette naermeste kontaktpunkt til en ansatt`() {
        val funnetKontakt = sjefHenterJava.hentNaermesteKontaktpunkt(kari)
        assertThat(funnetKontakt).isEqualTo(sjef)

        val funnetKontaktKotlin = sjefHenterKotlin.hentNaermesteKontaktpunkt(kari)
        assertThat(funnetKontaktKotlin).isEqualTo(sjef)
    }

    @Test
    fun `b) Dersom en ansatt ikke har en sjef er daglig leder naermeste kontaktpunkt`() {
        val funnetKontakt = sjefHenterJava.hentNaermesteKontaktpunkt(ola)
        assertThat(funnetKontakt).isEqualTo(dagligLeder)

        val funnetKontaktKotlin = sjefHenterKotlin.hentNaermesteKontaktpunkt(ola)
        assertThat(funnetKontaktKotlin).isEqualTo(dagligLeder)
    }
}