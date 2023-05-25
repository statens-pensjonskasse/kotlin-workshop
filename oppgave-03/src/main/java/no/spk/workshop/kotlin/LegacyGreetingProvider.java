package no.spk.workshop.kotlin;

public class LegacyGreetingProvider implements GreetingProvider {

    private final String name;

    LegacyGreetingProvider(final String name) {
        this.name = name;
    }

    @Override
    public String greeting() {
        return String.format("Hello, %s!", name);
    }
}
