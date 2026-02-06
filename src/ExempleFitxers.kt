
import controllers.*
import utils.readBoolean
import utils.readWord

fun main() {
    var continuar: Boolean = false

    do {
        var ruta: String = consultarRuta()
        var existeix: Boolean = comprovarRuta(ruta)

        if (existeix) {
            var esDirectori: Boolean = comprovarDirectori(ruta)
            if (esDirectori) {
                println("La ruta especificada apunta a un directori")
                println("A continuació pots veure el seu contingut:")
                llistarContingut(ruta)
            } else {
                println("La ruta especificada apunta a un fitxer.")
                println("A continuació pots veure el seu contingut:")
                llegirFitxer(ruta)
                escriureFitxer(ruta)
            }
        } else {
            println("ERROR: El fitxer o ruta especificat, no existeix!")
        }

        continuar = readBoolean("Vols tornar al menú principal? (true/false)",
                    "Opció no acceptada")
    }while (continuar)
}