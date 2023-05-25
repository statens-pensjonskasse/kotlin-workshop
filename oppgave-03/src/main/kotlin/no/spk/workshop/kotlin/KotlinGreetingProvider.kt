package no.spk.workshop.kotlin

class KotlinGreetingProvider(private val name: String) : GreetingProvider {

    override fun greeting() = "Hello, $name!"
}
