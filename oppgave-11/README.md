# Oppgave 11

I denne modulen skal du skrive tester.

Denne modulen har en `CharacterClient` som henter karakterer fra forskjellige
tegneserieunivers, og en cachende variant av denne.

`CachingCharacterClient` bruker en annen `CharacterClient` som kilde for sine
data, og oppdaterer cachen sin herfra hvert femte sekund. Du skal IKKE skrive en
implementasjon av dette interfacet, men den skal i stedet mockes ut i testene
dine. Du kan se for deg at det typisk ville vært en HTTP-klient som gjorde
faktiske kall mot en webservice eller lignende.

Din oppgave er å sørge for at `CachingCharacterClient` oppfører seg som
forventet ved å skrive test-cases som bruker MockK og Kotest til å verifisere
følgende:

1. At cachen faktisk svarer med verdien fra kilden.
2. At cachen returnerer `null` dersom det ikke finnes noen tegneseriefigurer i kilden.
3. At riktig tegneseriefigur returneres for riktig univers.
4. At cachen ikke oppdateres før det har gått fem sekunder (selv om kilden endrer seg).
5. At cachen oppdateres etter fem sekunder (når kilden har endret seg).

De tre første testene gir deg litt hjelp til å komme i gang, men de to siste må
du skrive fra scratch. :-)

Hint: Du kan bruke `every { ... } returnsMany listOf(...)` for å få mocken til å svare forskjellig i påfølgende kall.
Hint: Du kan bruke `verify(exactly = 1) { ... }` for å sjekke antall kall til mocken.
