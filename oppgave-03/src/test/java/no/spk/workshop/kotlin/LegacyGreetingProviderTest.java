package no.spk.workshop.kotlin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LegacyGreetingProviderTest {

    @Test
    @DisplayName("Provides correct greeting")
    void providesCorrectGreeting() {
        final GreetingProvider greetingProvider = new LegacyGreetingProvider("Java");
        final String greeting = greetingProvider.greeting();
        assertThat(greeting).isEqualTo("Hello, Java!");
    }
}
