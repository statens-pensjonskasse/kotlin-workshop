package no.spk.workshop.kotlin

class HumanResourcesKotlin(
    val dagligLeder: Ansatt,
) {

    // a) Ikke bruk if/else! Hint:  ?.
    fun hentSjefenTil(ansatt: Ansatt): String? {
        return ansatt.avdeling?.sjef?.navn
    }


    // b) Ikke bruk if/else! Hint:  ?:
    fun hentNaermesteKontaktpunkt(ansatt: Ansatt): Ansatt {
        return ansatt.avdeling?.sjef ?: dagligLeder
    }
}