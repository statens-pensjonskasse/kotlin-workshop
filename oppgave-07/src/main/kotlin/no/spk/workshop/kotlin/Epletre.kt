package no.spk.workshop.kotlin

data class Epletre (
    val lengdeCm: Int = 0,
    val alderAar: Int = 0,
    val epler: MutableList<Eple> = mutableListOf()
)