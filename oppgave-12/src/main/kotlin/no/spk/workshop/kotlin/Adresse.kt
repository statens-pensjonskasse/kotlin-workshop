package no.spk.workshop.kotlin

data class Adresse(
    val navn: String,
    val adresselinje1: String,
    val adresselinje2: String?,
    val adresselinje3: String?,
    val adresselinje4: String?,
    val postnr: String,
    val poststed: String,
    val land: String?,
)
