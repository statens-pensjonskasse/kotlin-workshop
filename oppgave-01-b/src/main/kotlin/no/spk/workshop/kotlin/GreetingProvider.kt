package no.spk.workshop.kotlin

class GreetingProvider {

    fun greeting(): String {
        val javaClass = LegacyGreetingProvider()
        return javaClass.greeting()
    }
}
