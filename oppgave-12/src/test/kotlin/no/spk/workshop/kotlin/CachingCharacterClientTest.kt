package no.spk.workshop.kotlin

import io.kotest.matchers.shouldBe
import io.mockk.mockk
import no.spk.workshop.kotlin.dto.Character
import org.junit.jupiter.api.Test

internal class CachingCharacterClientTest {

    @Test
    fun `Test 1, Donald returneres for Disney-universet`() {

        val sourceMock = mockk<CharacterClient>()

        val characterClient = CachingCharacterClient(sourceMock)
        val firstCharacter = characterClient.getCharacter("Disney")
        firstCharacter shouldBe Character("Donald Duck")
    }

    @Test
    fun `Test 2, Henter tomt resultat dersom tegneseriefiguren ikke finnes`() {

        val sourceMock = mockk<CharacterClient>()

        val characterClient = CachingCharacterClient(sourceMock)
        val firstCharacter = characterClient.getCharacter("Pondus")
        firstCharacter shouldBe null
    }

    @Test
    fun `Test 3, Henter to tegneseriefigurer fra hvert sitt univers`() {

        val sourceMock = mockk<CharacterClient>()

        val characterClient = CachingCharacterClient(sourceMock)
        val firstCharacter = characterClient.getCharacter("Disney")
        firstCharacter shouldBe Character("Donald Duck")

        val secondCharacter = characterClient.getCharacter("Marvel")
        secondCharacter shouldBe Character("Iron Man")
    }

    @Test
    fun `Test 4, Cachen oppdateres ikke før det har gått fem sekunder`() {
        // TODO her skal du teste at cachen returnerer samme verdi, selv om
        //  verdien fra kilden (mocken) endrer seg
    }

    @Test
    fun `Test 5, Cachen oppdateres etter fem sekunder`() {
        // TODO her skal du teste at cachen returnerer en oppdatert verdi etter
        //  fem sekunder, dersom verdien fra kilden (mocken) endrer seg
    }
}
