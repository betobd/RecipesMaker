import Model.*
import java.util.*
import kotlin.collections.ArrayList

val listaAgua = mutableMapOf(1 to "Fria", 2 to "Caliente")
val listaAceites = mutableMapOf(1 to "Oliva", 2 to "Girasol", 3 to "Coco")
val listaFrutas =
    mutableMapOf(1 to "Fresa", 2 to "Plátano", 3 to "Uvas", 4 to "Manzana", 5 to "Naranja", 6 to "Pera", 7 to "Cereza")
val listaCereales = mutableMapOf(1 to "Avena", 2 to "Trigo", 3 to "Arroz", 4 to "Maiz")
var listaRecetas: MutableList<Receta> = mutableListOf()
var scan: Scanner = Scanner(System.`in`)


val ingredientesDisponibles = """
        
        1- Agua
        2- Leche
        3- Carne
        4- Verduras
        5- Frutas
        6- Cereal
        7- Huevos
        8- Aceite
    """.trimIndent()

fun main(arg: Array<String>) {

    pantallaInicio()
    Thread.sleep(3000)
}

fun mostrarIngredientes() {

    println(" \n \n Los ingredientes disponibles son: $ingredientesDisponibles")
}

fun pantallaInicio() {
    val mensajeBienvenida = """
        
       Selecciona la opción deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
        
    """.trimIndent()

    println(mensajeBienvenida)
    leerOpcion()
}

fun leerOpcion() {
    println(" \n Ingrese opcion deseada:")
    val response: String? = readLine()

    when (response) {
        "1" -> nuevaReceta()
        "2" -> {
            verReceta()
            Read()
            pantallaInicio()

        }
        "3" -> salir()
        else -> {
            println("La opción ingresada no es valida ")
            leerOpcion()
        }

    }
}

fun nuevaReceta() {

    println("Ingrese un título para su receta: ")
    val tituloReceta: String = readLine().toString()
    mostrarIngredientes()

    agregarIngrediente(tituloReceta)

}

fun verReceta() {
    println("Tiene ${listaRecetas.size} recetas guardadas: \n")
    // println(listaRecetas)
    for ((pos, receta) in listaRecetas.withIndex()) {
        println("\n Receta #${pos + 1} - '${receta.verNombre()}' ")
        println("   Ingredientes:")
        receta.verIngredientes()
    }
}

fun agregarIngrediente(titulo: String) {
    //  val listaIngredientes: ArrayList<String>  = ArrayList()
    val listaIngredientes: ArrayList<Ingrediente> = ArrayList()

    do {
        println(" \n \n Ingrese número de ingrediente que desea agregar(Presione 0 para salir): ")
        val ingredienteDeseado: String? = readLine()

        when (ingredienteDeseado) {
            "1" -> agua(listaIngredientes, titulo)
            "2" -> leche(listaIngredientes, titulo)
            "3" -> carne(listaIngredientes, titulo)
            "4" -> verdura(listaIngredientes, titulo)
            "5" -> fruta(listaIngredientes, titulo)
            "6" -> cereal(listaIngredientes, titulo)
            "7" -> huevos(listaIngredientes, titulo)
            "8" -> aceite(listaIngredientes, titulo)
            else -> {
                println("Ingrediente no existe")

            }

        }
    } while (ingredienteDeseado != "0")

    val nuevaReceta = Receta(titulo, listaIngredientes)
    listaRecetas.add(nuevaReceta)
    println("Su receta $titulo fue guardada")

    pantallaInicio()


}

fun salir() {

    println("Programa finalizado")
}

fun agua(listaIngredientes: ArrayList<Ingrediente>, titulo: String) {

    try {
        println("Elija el tipo de agua que desea:")
        for (ing in listaAgua) {
            println("${ing.key}  - ${ing.value}  ")
        }

        val aguaDeseada: String? = readLine()

        if (aguaDeseada == "1" || aguaDeseada == "2") {

            println("Escriba la cantidad de Agua deseada en mililitros:")

            val cantidadDeseada: Int = readLine()!!.toInt()

            when (aguaDeseada) {
                "1" -> {
                    val agua = Agua("Agua Fria", cantidadDeseada)
                    listaIngredientes.add(agua)
                    println("Ingrediente: ${agua.nombre},  agregado a la receta '$titulo ' ")

                }
                "2" -> {
                    val agua = Agua("Agua Caliente", cantidadDeseada)
                    listaIngredientes.add(agua)
                    println("Ingrediente: ${agua.nombre},  agregado a la receta '$titulo ' ")

                }

            }

        } else {
            println("Opcion no valida")
            agua(listaIngredientes, titulo)
        }

    } catch (e: Exception) {
        println("Cantidad ingresada no válida")
        agua(listaIngredientes, titulo)
    }


}

fun fruta(listaIngredientes: ArrayList<Ingrediente>, titulo: String) {

    try {
        println("Elija el la fruta que desea:")
        for (fru in listaFrutas) {
            println("${fru.key}  - ${fru.value}  ")
        }
        val frutaDeseada: String? = readLine()

        if (frutaDeseada == "1" || frutaDeseada == "2" || frutaDeseada == "3" || frutaDeseada == "4" || frutaDeseada == "5" || frutaDeseada == "6" || frutaDeseada == "7") {
            println("Escriba la cantidad de fruta deseada en unidades:")
            val cantidadDeseada: Int? = readLine()?.toInt()
            when (frutaDeseada) {
                "1" -> {
                    val fruta = Fruta("Fresas", cantidadDeseada)
                    listaIngredientes.add(fruta)
                    println("Ingrediente: ${fruta.nombre},  agregado a la receta '$titulo ' ")

                }
                "2" -> {
                    val fruta = Fruta("Platano", cantidadDeseada)
                    listaIngredientes.add(fruta)
                    println("Ingrediente: ${fruta.nombre},  agregado a la receta '$titulo ' ")

                }

                "3" -> {
                    val fruta = Fruta("Uvas", cantidadDeseada)
                    listaIngredientes.add(fruta)
                    println("Ingrediente: ${fruta.nombre},  agregado a la receta '$titulo ' ")

                }

                "4" -> {
                    val fruta = Fruta("Manzana", cantidadDeseada)
                    listaIngredientes.add(fruta)
                    println("Ingrediente: ${fruta.nombre},  agregado a la receta '$titulo ' ")

                }

                "5" -> {
                    val fruta = Fruta("Naranja", cantidadDeseada)
                    listaIngredientes.add(fruta)
                    println("Ingrediente: ${fruta.nombre},  agregado a la receta '$titulo ' ")

                }

                "6" -> {
                    val fruta = Fruta("Pera", cantidadDeseada)
                    listaIngredientes.add(fruta)
                    println("Ingrediente: ${fruta.nombre},  agregado a la receta '$titulo ' ")

                }

                "7" -> {
                    val fruta = Fruta("Cerezas", cantidadDeseada)
                    listaIngredientes.add(fruta)
                    println("Ingrediente: ${fruta.nombre},  agregado a la receta '$titulo ' ")

                }
            }
        } else {
            println("Opcion no valida")
            fruta(listaIngredientes, titulo)
        }

    } catch (e: Exception) {
        println("Cantidad ingresada no válida")
        fruta(listaIngredientes, titulo)
    }


}

fun aceite(listaIngredientes: ArrayList<Ingrediente>, titulo: String) {

    try {
        println("Elija el tipo de aceite que desea:")
        for (ace in listaAceites) {
            println("${ace.key}  - ${ace.value}  ")
        }
        val aceiteDeseado: String? = readLine()

        if (aceiteDeseado == "1" || aceiteDeseado == "2" || aceiteDeseado == "3") {
            println("Escriba la cantidad de aceite deseada en mililitros:")
            val cantidadDeseada: Int? = readLine()?.toInt()
            when (aceiteDeseado) {
                "1" -> {
                    val aceite = Aceite("Oliva", cantidadDeseada)
                    listaIngredientes.add(aceite)
                    println("Ingrediente: ${aceite.nombre},  agregado a la receta '$titulo ' ")

                }
                "2" -> {
                    val aceite = Aceite("Girasol", cantidadDeseada)
                    listaIngredientes.add(aceite)
                    println("Ingrediente: ${aceite.nombre},  agregado a la receta '$titulo ' ")

                }

                "3" -> {
                    val aceite = Aceite("Coco", cantidadDeseada)
                    listaIngredientes.add(aceite)
                    println("Ingrediente: ${aceite.nombre},  agregado a la receta '$titulo ' ")

                }


            }

        } else {
            println("Opcion no valida")
            aceite(listaIngredientes, titulo)
        }
    } catch (e: NumberFormatException) {
        println("Cantidad ingresada no válida")
        aceite(listaIngredientes, titulo)
    }


}

fun cereal(listaIngredientes: ArrayList<Ingrediente>, titulo: String) {
    try {
        println("Elija el el cereal que desea:")

        for (cer in listaCereales) {
            println("${cer.key}  - ${cer.value}  ")
        }
        val cerealDeseado: String? = readLine()

        if (cerealDeseado == "1" || cerealDeseado == "2" || cerealDeseado == "3" || cerealDeseado == "4") {
            println("Escriba la cantidad de cereal deseada en gramos:")
            val cantidadDeseada: Int? = readLine()?.toInt()
            when (cerealDeseado) {
                "1" -> {
                    val cereal = Cereal("Avena", cantidadDeseada)
                    listaIngredientes.add(cereal)
                    println("Ingrediente: ${cereal.nombre},  agregado a la receta '$titulo ' ")

                }
                "2" -> {
                    val cereal = Cereal("Trigo", cantidadDeseada)
                    listaIngredientes.add(cereal)
                    println("Ingrediente: ${cereal.nombre},  agregado a la receta '$titulo ' ")

                }

                "3" -> {
                    val cereal = Cereal("Arroz", cantidadDeseada)
                    listaIngredientes.add(cereal)
                    println("Ingrediente: ${cereal.nombre},  agregado a la receta '$titulo ' ")

                }

                "4" -> {
                    val cereal = Cereal("Maiz", cantidadDeseada)
                    listaIngredientes.add(cereal)
                    println("Ingrediente: ${cereal.nombre},  agregado a la receta '$titulo ' ")

                }

            }

        } else {
            println("Opcion no valida")
            cereal(listaIngredientes, titulo)
        }
    } catch (e: Exception) {
        println("Cantidad ingresada no válida")
        cereal(listaIngredientes, titulo)
    }


}

fun leche(listaIngredientes: ArrayList<Ingrediente>, titulo: String) {

    try {
        println("Escriba la cantidad de leche deseada en mililitros:")
        val cantidadDeseada: Int? = readLine()?.toInt()

        val leche = Leche("Leche", cantidadDeseada)
        listaIngredientes.add(leche)
        println("Ingrediente: ${leche.nombre},  agregado a la receta '$titulo ' ")
    } catch (e: Exception) {
        println("Cantidad ingresada no válida")
        leche(listaIngredientes, titulo)
    }

}

fun huevos(listaIngredientes: ArrayList<Ingrediente>, titulo: String) {

    try {
        println("Escriba la cantidad de huevos deseada en unidades:")
        val cantidadDeseada: Int? = readLine()?.toInt()

        val huevos = Huevos("Huevos", cantidadDeseada)
        listaIngredientes.add(huevos)
        println("Ingrediente: ${huevos.nombre},  agregado a la receta '$titulo ' ")

    } catch (e: Exception) {
        println("Cantidad ingresada no válida")
        huevos(listaIngredientes, titulo)
    }

}

fun carne(listaIngredientes: ArrayList<Ingrediente>, titulo: String) {

    try {
        println("Escriba la cantidad de carne deseada en gramos:")
        val cantidadDeseada: Int? = readLine()?.toInt()

        val carne = Carne("Carne", cantidadDeseada)
        listaIngredientes.add(carne)
        println("Ingrediente: ${carne.nombre},  agregado a la receta '$titulo ' ")

    } catch (ex: Exception) {
        println("Cantidad ingresada no válida")
        carne(listaIngredientes, titulo)
    }

}

fun verdura(listaIngredientes: ArrayList<Ingrediente>, titulo: String) {

    try {
        println("Escriba la cantidad de verdura deseada en gramos:")
        val cantidadDeseada: Int? = readLine()?.toInt()

        val verdura = Verdura("Verdura", cantidadDeseada)
        listaIngredientes.add(verdura)
        println("Ingrediente: ${verdura.nombre},  agregado a la receta '$titulo ' ")
    } catch (ex: Exception) {
        println("Cantidad ingresada no válida")
        verdura(listaIngredientes, titulo)
    }

}


fun Read() {
    print("Presione cualquier tecla para continuar . . . ")
    scan.nextLine()
}