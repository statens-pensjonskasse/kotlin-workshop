package no.spk.workshop.kotlin

class Sorterer {

    // a)
    fun grupperEtterLengde(ordliste: List<String>): Map<Int, List<String>> {
        return ordliste.groupBy { it.length }
    }

    //b)
    fun kobleSammenOrdOgHashkode(ordliste: List<String>): Map<Int, String> {
        return ordliste.associateBy { it.hashCode() }
    }
}