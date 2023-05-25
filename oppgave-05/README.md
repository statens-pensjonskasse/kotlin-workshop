# Oppgave 5
Denne oppgaven handler om null safety i kotlin.

Du har fått utdelt to klasser: Ansatt og Avdeling.
En ansatt kan tilhøre en avdeling - eller ikke. En avdeling kan ha ansatt en sjef - eller ikke.
Sjefen til en ansatt er sjefen i den avdelingen de tilhører
   -> har de ingen avdeling, så har de ingen sjef
   -> har de avdeling men avdelingen mangler sjef, så har de ingen sjef

I tillegg har du fått to varianter av HumanResources, en i Java og en i Kotlin, og en test-klasse.

Oppgaver:
a) Skriv en Kotlin-variant av metoden hentSjefenTil i HumanResourcesJava.
   Metoden skal hente navnet til sjefen til en ansatt, gitt at de har en.
   Du skal ikke bruke if eller else! Hint:   ?.
   Sjekk at de to første testene går grønt

b) Skriv en Kotlin-variant av metoden hentNaermesteKontaktpunkt i HumanResourcesJava.
   Metoden skal hente sjefen til en ansatt, eller daglig leder dersom vedkommede ikke har noen sjef.
   Du skal ikke bruke if eller else! Hint:   ?:
   Sjekk at alle testene går grønt



Her kan du lese mer om null safety: https://kotlinlang.org/docs/null-safety.html#safe-calls