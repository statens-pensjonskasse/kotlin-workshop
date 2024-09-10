package no.spk.workshop.kotlin

import kotlin.math.sqrt

class PrimtallService {

    fun kalkulerPrimtall(max: Int): List<Int> {
        val maxFaktor = sqrt(max.toFloat()).toInt() // Noe større enn roten vil måtte ganges med en faktor mindre enn roten
        val muligePrimtall = lagListeFra2TilOgMed(max)
        return filtrerVekkDelbareRekursivt(muligePrimtall, 2, maxFaktor)
    }

    private fun lagListeFra2TilOgMed(max: Int): List<Int> {
        val startArray = IntArray(max+1)
        startArray.forEachIndexed { index, _ ->
            startArray[index] = index
        }
        return startArray.toList().minus(0).minus(1)
    }

    private fun filtrerVekkDelbareRekursivt(muligePrimtall: List<Int>, iterasjonFaktor: Int, maxFaktor: Int): List<Int> {
        if (iterasjonFaktor > maxFaktor) {
            return muligePrimtall
        }
        val ikkeDelbare = muligePrimtall.filter { it%iterasjonFaktor != 0 || it==iterasjonFaktor }
        val nesteIterasjonFaktor = ikkeDelbare[ikkeDelbare.indexOf(iterasjonFaktor) + 1]
        return filtrerVekkDelbareRekursivt(ikkeDelbare, nesteIterasjonFaktor, maxFaktor)
    }
}
