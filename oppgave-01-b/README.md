# Oppgave 1B

Denne oppgaven handler om hvordan et typisk Java-prosjekt ser ut, og dere
ønsker å ta i bruk Kotlin gradvis. Det vil si, hvor både Java og Kotlin skal
kunne kalles fra hverandre sømløst i samme prosjekt.

Denne modulen har et bygg som feiler fordi kotlin-maven-plugin ikke
finner Java-klassen `LegacyGreetingProvider` på classpath.

```shell
mvn clean install
```

1. Gjør endringer i [Maven](pom.xml) slik at maven-compiler-plugin kompilerer
   Java-klassene som mangler.

Hint: Ser maven-compiler-plugin etter Java-filene på riktig sted?

Når Kotlin finner Java-klassen over, feiler bygget med en ny feil fordi
maven-compiler-plugin ikke finner Kotlin-klassen `NameProvider` på classpath.

2. Gjør flere endringer slik at bygget blir grønt.

Hint: Kompileres Java- og Kotlin-filene i riktig rekkefølge? (Kotlin må bygges sist.)

Oppgaven er løst når modulen bygger.

(Om du synes denne oppgaven er vanskelig, er det lov å hoppe til neste oppgave.)
