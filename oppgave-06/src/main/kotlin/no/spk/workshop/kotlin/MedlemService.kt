package no.spk.workshop.kotlin

class MedlemService {
    fun genererJavaMedlem(navn: String): MedlemDto {
        return MedlemDto(navn, true)
    }

    fun genererKotlinMedlem(navn: String): Medlem {
        return Medlem(navn, true)
    }
}
