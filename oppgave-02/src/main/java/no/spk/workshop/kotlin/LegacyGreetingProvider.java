package no.spk.workshop.kotlin;

public class LegacyGreetingProvider {

    public String greeting() {
        final String name = new NameProvider().name();
        return "Hello, " + name + "!";
    }
}
