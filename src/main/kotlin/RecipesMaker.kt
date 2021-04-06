
var listaRecetas: MutableList<Receta> = mutableListOf()

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

fun main(arg: Array<String> ) {

   pantallaInicio()

}

fun mostrarIngredientes(){

    println("Los ingredientes disponibles son: $ingredientesDisponibles")
}

fun pantallaInicio(){
    val mensajeBienvenida = """
       Selecciona la opción deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
    """.trimIndent()

    println(mensajeBienvenida)
    leerOpcion()
}

fun leerOpcion(){
    println("Ingrese opcion deseada:")
    var response:String? = readLine()

    when(response){
        "1" -> nuevaReceta()
        "2" -> verReceta()
        "3" -> salir()
        else -> {
            println("La opción ingresada no es valida ")
            leerOpcion()
        }

        }
    }

fun nuevaReceta(){

    println("Ingrese un título para su receta: ")
    val tituloReceta:String = readLine().toString()
    mostrarIngredientes()

    agregarIngrediente(tituloReceta)

}

fun verReceta() {
    println("Tiene ${listaRecetas.size} recetas guardadas:")
    for (receta in listaRecetas){
        println("${receta.verNombre()}")
        println("Ingredientes:")
        for (ingrediente in receta.verIngredientes()){
            println("\t${ingrediente}")
        }
    }
}

fun agregarIngrediente(titulo :String){
    val listaIngredientes: ArrayList<String>  = ArrayList()

    do{
        println("Ingrese número de ingrediente (Presione 0 para salir): ")
        val ingredienteDeseado:String? = readLine()
        //val listaIngredientes: ArrayList<String>  = ArrayList()


        when(ingredienteDeseado){
            "1" -> listaIngredientes.add("Agua")
            "2" -> listaIngredientes.add("Leche")
            "3" -> listaIngredientes.add("Carne")
            "4" -> listaIngredientes.add("Verduras")
            "5" -> listaIngredientes.add("Frutas")
            "6" -> listaIngredientes.add("Cereal")
            "7" -> listaIngredientes.add("Huevos")
            "8" -> listaIngredientes.add("Aceite")
            else -> {
                println("Ingrediente no existe")

            }

        }
    }while(ingredienteDeseado != "0")

        val nuevaReceta = Receta(titulo,listaIngredientes)
        listaRecetas.add(nuevaReceta)
        println("Su receta $titulo fue guardada")
        pantallaInicio()


}

fun salir(){

    println("Programa finalizado")
}
