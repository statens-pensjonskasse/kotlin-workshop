package no.spk.workshop.kotlin

class EpletreService {

    fun hentModneEpler(epler: List<Eple>): List<Eple> {
        return epler.filter { it.moden }
    }

    fun filtrerEtterLengde(epletraer: List<Epletre>, minLengde: Int, maxLengde: Int): List<Epletre> {
        return epletraer.filter { it.lengdeCm in minLengde until maxLengde }
    }
}