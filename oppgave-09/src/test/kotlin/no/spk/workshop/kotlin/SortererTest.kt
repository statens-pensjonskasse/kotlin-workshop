package no.spk.workshop.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SortererTest {
    val sorterer = Sorterer()

    val ordlisteGruppering = listOf("okay", "hi", "hey", "hello", "no", "maybe", "hiya", "yes", "bye")
    val gruppertEtterLengde = mapOf(
        Pair(5, listOf("hello", "maybe")),
        Pair(4, listOf("okay", "hiya")),
        Pair(3, listOf("hey", "yes", "bye")),
        Pair(2, listOf("hi", "no")),
    )

    val unikeOrd = listOf("Aaa", "Bbb", "Ccc")
    val assosiertTilHashkode = mapOf(
        Pair(65569, "Aaa"),
        Pair(66562, "Bbb"),
        Pair(67555, "Ccc"),

    )

    @Test
    fun `a) En liste med ord skal grupperes etter lengden paa ordet`() {
        val resultat = sorterer.grupperEtterLengde(ordlisteGruppering)
        assertThat(resultat).containsExactlyInAnyOrderEntriesOf(gruppertEtterLengde)
    }

    @Test
    fun `b) En liste med ord skal assosieres med hashkoden sin`() {
        val resultat = sorterer.kobleSammenOrdOgHashkode(unikeOrd)
        assertThat(resultat).containsExactlyInAnyOrderEntriesOf(assosiertTilHashkode)
    }
}