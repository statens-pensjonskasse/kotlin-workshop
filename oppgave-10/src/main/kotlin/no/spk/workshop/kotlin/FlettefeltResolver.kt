package no.spk.workshop.kotlin

class FlettefeltResolver {

    fun populerFlettefeltMedAdresse(flettefelt: MutableMap<String, Any?>, adresse: Adresse): MutableMap<String, Any?> {

        val adresselinjer = listOf(
            listOf(
                adresse.navn,
                adresse.adresselinje1,
            ),
            if (adresse.land != null) {
                listOf(
                    listOfNotNull(
                        adresse.adresselinje2,
                        adresse.adresselinje3,
                        adresse.adresselinje4,
                    ).joinToString(separator = ", "),
                    "${adresse.postnr} ${adresse.poststed}",
                    adresse.land,
                )
            } else {
                listOf(
                    adresse.adresselinje2,
                    listOfNotNull(
                        adresse.adresselinje3,
                        adresse.adresselinje4
                    ).joinToString(separator = ", "),
                    "${adresse.postnr} ${adresse.poststed}"
                )
            }
        ).flatten().filter { !it.isNullOrEmpty() }

        flettefelt["brevhode.adresselinje1"] = adresselinjer.getOrElse(0) { "" }
        flettefelt["brevhode.adresselinje2"] = adresselinjer.getOrElse(1) { "" }
        flettefelt["brevhode.adresselinje3"] = adresselinjer.getOrElse(2) { "" }
        flettefelt["brevhode.adresselinje4"] = adresselinjer.getOrElse(3) { "" }
        flettefelt["brevhode.adresselinje5"] = adresselinjer.getOrElse(4) { "" }

        return flettefelt
    }
}
