# Oppgave 1

Denne modulen har en Kotlin-test som egentlig feiler, men siden Maven-
konfigurasjonen er feil, bygges aldri Kotlin-koden, og bygget kjører derfor
feilaktig grønt.

1. Konfigurer [Maven](pom.xml) slik at bygget feiler.
2. Rett feilen slik at bygget går grønt igjen.

Hint: Må det legges inn en Kotlin-plugin?

Du har klart oppgaven når du bygger med

```shell
mvn clean install
```

og ser følgende i loggen

```shell
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ oppgave-01-a ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running no.spk.workshop.kotlin.GreetingProviderTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.013 s - in no.spk.workshop.kotlin.GreetingProviderTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
```
