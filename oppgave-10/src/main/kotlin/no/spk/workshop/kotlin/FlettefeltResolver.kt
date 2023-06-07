package no.spk.workshop.kotlin

class FlettefeltResolver {

    fun populerFlettefeltMedAdresse(flettefelt: MutableMap<String, Any?>, adresse: Adresse): MutableMap<String, Any?> {
        // TODO dine endringer i denne metoden :-)
        flettefelt["brevhode.adresselinje1"] = "Test Testersen"
        flettefelt["brevhode.adresselinje2"] = "Testveien 1"
        flettefelt["brevhode.adresselinje3"] = "1337 Sandvika"
        flettefelt["brevhode.adresselinje4"] = ""
        flettefelt["brevhode.adresselinje5"] = ""
        return flettefelt
    }
}
