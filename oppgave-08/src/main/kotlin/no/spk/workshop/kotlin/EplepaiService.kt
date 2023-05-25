package no.spk.workshop.kotlin

class EplepaiService {

    fun bakEplePai(epler: List<Eple>): List<Eplepai> {
        return epler.map { Eplepai(it.moden) }
    }

    fun plukkOgBakEplePai(traer: List<Epletre>): List<Eplepai> {
        val modneEpler =  traer
            .flatMap { it.epler }
            .filter { it.moden }

        return bakEplePai(modneEpler)
    }
}