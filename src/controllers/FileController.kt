package controllers

import utils.*
import utils.readSentence
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.file.Path
import kotlin.io.path.*

fun llegirFitxer(arxiu: String){
    try {
        val fitxer: File = File(arxiu)

        println("Contingut fitxer:")
        fitxer.forEachLine { println("\t$it") }

    }catch (fnfe: FileNotFoundException) {
        print(fnfe.message)
    }catch (ioe: IOException){
        print(ioe.message)
    }catch(e: Exception){
        print("ERROR: Fatal ERROR. Error no tractat")
    }
}

fun escriureFitxer(arxiu: String){
    try {
        val fitxer: File = File(arxiu)

        var contingut = readSentence("Escriu el nou contingut: ",
                                "Valor no acceptat")
        fitxer.appendText(contingut)

    }catch (fnfe: FileNotFoundException) {
        print(fnfe.message)
    }catch (ioe: IOException){
        print(ioe.message)
    }catch(e: Exception){
        print(RED + "ERROR: Fatal ERROR. Error no tractat" + RESET)
    }

}

fun consultarRuta(): String{
    var ruta: String
    ruta = readSentence("Escriu la ruta del fitxer: ",
                    "Valor no acceptat")
    return ruta
}

fun comprovarRuta(rutaArxiu: String): Boolean {
    var existeix: Boolean = Path(rutaArxiu).exists()
    return existeix
}

fun comprovarDirectori(rutaArxiu: String): Boolean {
    var esDirectori: Boolean = Path(rutaArxiu).isDirectory()
    return esDirectori
}

fun llistarContingut(ruta: String) {
    var directori: Path = Path(ruta)
    val fitxers: List<Path> = directori.listDirectoryEntries()

    for (fitxer in fitxers) {
        println("\t$fitxer")
    }
}
