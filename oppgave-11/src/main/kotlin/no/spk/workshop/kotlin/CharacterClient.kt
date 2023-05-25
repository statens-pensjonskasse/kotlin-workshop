package no.spk.workshop.kotlin

import no.spk.workshop.kotlin.dto.Character

interface CharacterClient {

    fun getCharacter(universe: String): Character?
}