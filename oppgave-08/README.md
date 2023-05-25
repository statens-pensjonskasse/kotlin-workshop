# Oppgave 8

I denne oppgaven skal vi se på map-metoder i Kotlin, som lar oss endre eller utføre oppgaver på en gruppe objekter.
Kodeendringer skal kun gjøres innenfor EplepaiService for å løse denne oppgaven.

A: Implementer metoden bakEplepai i EplepaiService ved å bruke Map. Den skal returnere en liste over Eplepai-objekter. Feltet smakerGodt
skal være true dersom eplet er modent, og false om det ikke er modent.

B: Implementer metoden plukkOgBakEplepai i EplepaiService ved å bruke både filter og flatmap. Den skal filtrere ut modne
epler fra trærne, og omgjøre dem til pai med map.

Tips: Hvis du er usikker på resultatene gjennom flere steg med mapping, kan du teste det i flere steg med breakpoints
og bruke debugger til å overvåke hva som har skjedd med listen.

Dokumentasjon for map:
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/