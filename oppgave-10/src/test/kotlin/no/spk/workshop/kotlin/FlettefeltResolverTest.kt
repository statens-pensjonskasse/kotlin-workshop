package no.spk.workshop.kotlin

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class FlettefeltResolverTest {

    private val flettefeltResolver: FlettefeltResolver = FlettefeltResolver()

    data class TestCase(
        val adresse: Adresse,
        val expectedFlettefelt: Map<String, Any?>,
    )

    @TestFactory
    fun `Mapper adresselinjer til flettefelt`() = listOf(
        // forskjellig sammensetning av adresselinjer, uten land
        TestCase(
            adresse = Adresse(
                navn = "Test Testersen",
                adresselinje1 = "Testveien 1",
                adresselinje2 = null,
                adresselinje3 = null,
                adresselinje4 = null,
                postnr = "1337",
                poststed = "Sandvika",
                land = null,
            ),
            expectedFlettefelt = mapOf(
                "brevhode.adresselinje1" to "Test Testersen",
                "brevhode.adresselinje2" to "Testveien 1",
                "brevhode.adresselinje3" to "1337 Sandvika",
                "brevhode.adresselinje4" to "",
                "brevhode.adresselinje5" to "",
                "brevhode.ukjent" to "uendret",
            ),
        ),
        TestCase(
            adresse = Adresse(
                navn = "Test Testersen",
                adresselinje1 = "Testveien 1",
                adresselinje2 = "Leilighet H0101",
                adresselinje3 = null,
                adresselinje4 = null,
                postnr = "1337",
                poststed = "Sandvika",
                land = null,
            ),
            expectedFlettefelt = mapOf(
                "brevhode.adresselinje1" to "Test Testersen",
                "brevhode.adresselinje2" to "Testveien 1",
                "brevhode.adresselinje3" to "Leilighet H0101",
                "brevhode.adresselinje4" to "1337 Sandvika",
                "brevhode.adresselinje5" to "",
                "brevhode.ukjent" to "uendret",
            ),
        ),
        TestCase(
            adresse = Adresse(
                navn = "Test Testersen",
                adresselinje1 = "Testveien 1",
                adresselinje2 = "Oppgang 2",
                adresselinje3 = "Leilighet H0101",
                adresselinje4 = null,
                postnr = "1337",
                poststed = "Sandvika",
                land = null,
            ),
            expectedFlettefelt = mapOf(
                "brevhode.adresselinje1" to "Test Testersen",
                "brevhode.adresselinje2" to "Testveien 1",
                "brevhode.adresselinje3" to "Oppgang 2",
                "brevhode.adresselinje4" to "Leilighet H0101",
                "brevhode.adresselinje5" to "1337 Sandvika",
                "brevhode.ukjent" to "uendret",
            ),
        ),
        TestCase(
            adresse = Adresse(
                navn = "Test Testersen",
                adresselinje1 = "Testveien 1",
                adresselinje2 = "Blokk 3",
                adresselinje3 = "Oppgang 2",
                adresselinje4 = "Leilighet H0101",
                postnr = "1337",
                poststed = "Sandvika",
                land = null,
            ),
            expectedFlettefelt = mapOf(
                "brevhode.adresselinje1" to "Test Testersen",
                "brevhode.adresselinje2" to "Testveien 1",
                "brevhode.adresselinje3" to "Blokk 3",
                "brevhode.adresselinje4" to "Oppgang 2, Leilighet H0101",
                "brevhode.adresselinje5" to "1337 Sandvika",
                "brevhode.ukjent" to "uendret",
            ),
        ),
        // samme sammensetning som over, men med land
        TestCase(
            adresse = Adresse(
                navn = "Test Testersen",
                adresselinje1 = "Testveien 1",
                adresselinje2 = null,
                adresselinje3 = null,
                adresselinje4 = null,
                postnr = "1337",
                poststed = "Sandvika",
                land = "Norge",
            ),
            expectedFlettefelt = mapOf(
                "brevhode.adresselinje1" to "Test Testersen",
                "brevhode.adresselinje2" to "Testveien 1",
                "brevhode.adresselinje3" to "1337 Sandvika",
                "brevhode.adresselinje4" to "Norge",
                "brevhode.adresselinje5" to "",
                "brevhode.ukjent" to "uendret",
            ),
        ),
        TestCase(
            adresse = Adresse(
                navn = "Test Testersen",
                adresselinje1 = "Testveien 1",
                adresselinje2 = "Leilighet H0101",
                adresselinje3 = null,
                adresselinje4 = null,
                postnr = "1337",
                poststed = "Sandvika",
                land = "Norge",
            ),
            expectedFlettefelt = mapOf(
                "brevhode.adresselinje1" to "Test Testersen",
                "brevhode.adresselinje2" to "Testveien 1",
                "brevhode.adresselinje3" to "Leilighet H0101",
                "brevhode.adresselinje4" to "1337 Sandvika",
                "brevhode.adresselinje5" to "Norge",
                "brevhode.ukjent" to "uendret",
            ),
        ),
        TestCase(
            adresse = Adresse(
                navn = "Test Testersen",
                adresselinje1 = "Testveien 1",
                adresselinje2 = "Oppgang 2",
                adresselinje3 = "Leilighet H0101",
                adresselinje4 = null,
                postnr = "1337",
                poststed = "Sandvika",
                land = "Norge",
            ),
            expectedFlettefelt = mapOf(
                "brevhode.adresselinje1" to "Test Testersen",
                "brevhode.adresselinje2" to "Testveien 1",
                "brevhode.adresselinje3" to "Oppgang 2, Leilighet H0101",
                "brevhode.adresselinje4" to "1337 Sandvika",
                "brevhode.adresselinje5" to "Norge",
                "brevhode.ukjent" to "uendret",
            ),
        ),
        TestCase(
            adresse = Adresse(
                navn = "Test Testersen",
                adresselinje1 = "Testveien 1",
                adresselinje2 = "Blokk 3",
                adresselinje3 = "Oppgang 2",
                adresselinje4 = "Leilighet H0101",
                postnr = "1337",
                poststed = "Sandvika",
                land = "Norge",
            ),
            expectedFlettefelt = mapOf(
                "brevhode.adresselinje1" to "Test Testersen",
                "brevhode.adresselinje2" to "Testveien 1",
                "brevhode.adresselinje3" to "Blokk 3, Oppgang 2, Leilighet H0101",
                "brevhode.adresselinje4" to "1337 Sandvika",
                "brevhode.adresselinje5" to "Norge",
                "brevhode.ukjent" to "uendret",
            ),
        ),
        // miks av tomme felt og null
        TestCase(
            adresse = Adresse(
                navn = "Test Testersen",
                adresselinje1 = "Testveien 1",
                adresselinje2 = "",
                adresselinje3 = null,
                adresselinje4 = "",
                postnr = "1337",
                poststed = "Sandvika",
                land = null,
            ),
            expectedFlettefelt = mapOf(
                "brevhode.adresselinje1" to "Test Testersen",
                "brevhode.adresselinje2" to "Testveien 1",
                "brevhode.adresselinje3" to "1337 Sandvika",
                "brevhode.adresselinje4" to "",
                "brevhode.adresselinje5" to "",
                "brevhode.ukjent" to "uendret",
            ),
        ),
    ).map { testCase ->
        dynamicTest(testCase.toString()) {
            val flettefeltUtenAdresse = mutableMapOf<String, Any?>(
                "brevhode.ukjent" to "uendret",
            )
            val flettefelt = flettefeltResolver.populerFlettefeltMedAdresse(flettefeltUtenAdresse, testCase.adresse)
            flettefelt shouldBe testCase.expectedFlettefelt
        }
    }
}
