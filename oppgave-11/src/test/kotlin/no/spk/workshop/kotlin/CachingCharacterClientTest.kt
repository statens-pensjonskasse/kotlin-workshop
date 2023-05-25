package no.spk.workshop.kotlin

import io.kotest.assertions.timing.eventually
import io.kotest.common.runBlocking
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import no.spk.workshop.kotlin.dto.Character
import org.junit.jupiter.api.Test

internal class CachingCharacterClientTest {

    @Test
    fun `Test 1, Donald returneres for Disney-universet`() {

        val sourceMock = mockk<CharacterClient>()
        every { sourceMock.getCharacter(any()) } returns Character("Donald Duck")

        val characterClient = CachingCharacterClient(sourceMock)
        val firstCharacter = characterClient.getCharacter("Disney")
        firstCharacter shouldBe Character("Donald Duck")

        verify { sourceMock.getCharacter("Disney") }
    }

    @Test
    fun `Test 2, Henter tomt resultat dersom tegneseriefiguren ikke finnes`() {

        val sourceMock = mockk<CharacterClient>()
        every { sourceMock.getCharacter(any()) } returns null

        val characterClient = CachingCharacterClient(sourceMock)
        val firstCharacter = characterClient.getCharacter("Pondus")
        firstCharacter shouldBe null

        verify { sourceMock.getCharacter("Pondus") }
    }

    @Test
    fun `Test 3, Henter to tegneseriefigurer fra hvert sitt univers`() {

        val sourceMock = mockk<CharacterClient>()
        every { sourceMock.getCharacter("Disney") } returns Character("Donald Duck")
        every { sourceMock.getCharacter("Marvel") } returns Character("Iron Man")

        val characterClient = CachingCharacterClient(sourceMock)
        val firstCharacter = characterClient.getCharacter("Disney")
        firstCharacter shouldBe Character("Donald Duck")

        val secondCharacter = characterClient.getCharacter("Marvel")
        secondCharacter shouldBe Character("Iron Man")

        verify { sourceMock.getCharacter("Disney") }
        verify { sourceMock.getCharacter("Marvel") }
    }

    @Test
    fun `Test 4, Cachen oppdateres ikke før det har gått fem sekunder`() {

        val sourceMock = mockk<CharacterClient>()
        every { sourceMock.getCharacter("Disney") } returnsMany listOf(
            Character("Donald Duck"),
            Character("Onkel Skrue"),
        )

        val characterClient = CachingCharacterClient(sourceMock)
        val firstCharacter = characterClient.getCharacter("Disney")
        firstCharacter shouldBe Character("Donald Duck")

        val secondCharacter = characterClient.getCharacter("Disney")
        secondCharacter shouldBe firstCharacter

        verify(exactly = 1) { sourceMock.getCharacter("Disney") }
    }

    @Test
    fun `Test 5, Cachen oppdateres etter fem sekunder`() = runBlocking {

        val sourceMock = mockk<CharacterClient>()
        every { sourceMock.getCharacter("Disney") } returnsMany listOf(
            Character("Donald Duck"),
            Character("Onkel Skrue"),
        )

        val characterClient = CachingCharacterClient(sourceMock)
        val firstCharacter = characterClient.getCharacter("Disney")
        firstCharacter shouldBe Character("Donald Duck")

        eventually {
            val secondCharacter = characterClient.getCharacter("Disney")
            secondCharacter shouldBe Character("Onkel Skrue")
        }

        verify(exactly = 2) { sourceMock.getCharacter("Disney") }
    }
}
