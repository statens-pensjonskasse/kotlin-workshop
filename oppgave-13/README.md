# Oppgave 13

I denne modulen skal du skrive en funksjon som beregner primtall.

Algoritmen du skal bruke heter _Sieve of Erastothenes_, oppfunnet av en gresk filosof som levde 300 år f.kr. 
Den fungerer slik:
* Input er det høyeste primtallet du vil beregne deg til
* Start med en liste fra 2 til det høyeste primtallet du vil beregne (2,3,4,5,6... max)
* Fra 2, marker alle høyere tall som er delbare på 2 (2,3,~~4~~,5,~~6~~... max)
* Gjenta markeringen fra neste tall som ikke er markert, frem til det ikke er noen høyere tall som er umarkerte
* Returner alle umarkerte tall - de skal være primtall!

Oppgaver:

A: Implementer funksjonen i PrimtallService slik at testene i PrimtallServiceTest går grønt. Dette er ment som en grubleoppgave, og kan løses på
mange ulike måter.

B: Forsøk å optimalisere funksjonen, for å minke kjøretiden i `Tidstest for store verdier`.

Hint 1: Du kan bruke modulo-funksjonen (%) til å finne ut om et tall er delbart på et annet. Den returnerer 0 om delingen går opp, f.eks 4%2 = 0.

Hint 2: Du kan lese mer om algoritmen, og en java-implementasjon for å komme i gang her: https://www.geeksforgeeks.org/sieve-of-eratosthenes/
