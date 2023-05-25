package no.spk.workshop.kotlin

import com.github.benmanes.caffeine.cache.CacheLoader
import com.github.benmanes.caffeine.cache.Caffeine
import no.spk.workshop.kotlin.dto.Character
import java.time.Duration

class CachingCharacterClient(
    private val source: CharacterClient,
) : CharacterClient {

    private val cache = Caffeine.newBuilder()
        .maximumSize(1)
        .refreshAfterWrite(Duration.ofSeconds(5))
        .build(object : CacheLoader<String, Character> {
            override fun load(key: String): Character? {
                return source.getCharacter(key)
            }
        })

    override fun getCharacter(universe: String): Character? {
        return cache.get(universe)
    }
}
