# Oppgave 12

Denne modulen er inspirert fra en problemstilling i Team Brev og Arkiv, hvor vi
hadde behov for å mappe mellom to adressetyper.

Det vi skal mappe fra, er en sterkt typet dataklasse, med felter for navn,
poststed, land, osv. Dette kan ligne på adressen vi får fra personalia-tjenesten
i SPK, hvis du er kjent med den.

Det vi skal mappe til, er flettefelter i et brev, hvor adressen skal legges inn
sammen med det som ligger der fra før. Flettefeltene er en key/value-struktur,
eller en `map<String, Any?>` i Kotlin. `Any?` fordi flettefelter kan nestes og
være `null`.

Utfordringen er at dataklassen vi skal mappe fra og flettefeltene vi skal mappe
til har ulikt antall adresselinjer tilgjengelig. Flettefeltene har maksimalt fem
adresselinjer til disposisjon. Felter som ikke får plass, skal derfor kombineres
med komma. Postnr og -sted skal kombineres til ett felt.

I koden finner du en test som bruker dynamiske/parametriserte tester fra JUnit 5
til å dekke en hel rekke forskjellige kombinasjoner av adresser. Testen feiler.

Skriv en god implementasjon i Kotlin som gjør at testene blir grønne. Du skal
ikke gjøre endringer i testene. :-)

Hint: Det kan være ukjente flettefelt som ikke skal endres på.
Hint 2: Tomme flettefelt er tom string, og ikke `null`.
