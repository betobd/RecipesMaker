import Model.*

val listaAgua = mutableMapOf(1 to "Fria", 2 to "Caliente")
val listaAceites = mutableMapOf(1 to "Oliva",2 to "Girasol",3 to "Coco")
val listaFrutas = mutableMapOf(1 to "Fresa",2 to "Plátano", 3 to "Uvas", 4 to "Manzana",5 to "Naranja",6 to "Pera",7 to "Cereza")
val listaCereales = mutableMapOf(1 to "Avena",2 to "Trigo", 3 to "Arroz", 4 to "Maiz")
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
   // println(listaRecetas)
    for ((pos, receta) in listaRecetas.withIndex()){
        println("Receta #${pos +1 } - '${receta.verNombre()}' ")
        println("   Ingredientes:")
        receta.verIngredientes()
    }
}

fun agregarIngrediente(titulo :String){
  //  val listaIngredientes: ArrayList<String>  = ArrayList()
    val listaIngredientes: ArrayList<Ingrediente>  = ArrayList()

    do{
        println("Ingrese número de ingrediente (Presione 0 para salir): ")
        val ingredienteDeseado:String? = readLine()

        when(ingredienteDeseado){
            "1" -> agua(listaIngredientes,titulo)
            "2" -> leche(listaIngredientes,titulo)
            "3" -> carne(listaIngredientes,titulo)
            "4" -> verdura(listaIngredientes,titulo)
            "5" -> fruta(listaIngredientes,titulo)
            "6" -> cereal(listaIngredientes,titulo)
            "7" -> huevos(listaIngredientes,titulo)
            "8" -> aceite(listaIngredientes,titulo)
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

fun agua(listaIngredientes: ArrayList<Ingrediente>, titulo: String){


        println("Elija el tipo de agua que desea:")
        for(ing in listaAgua){
            println("${ing.key}  - ${ing.value}  ")
        }
        val aguaDeseada:String? = readLine()
        println("Escriba la cantidad deseada en mililitros:")
        val cantidadDeseada:Int? = readLine()?.toInt()
        when(aguaDeseada){
            "1" -> {
                var agua :Agua =Agua("Agua Fria", cantidadDeseada)
                listaIngredientes.add(agua)
                println("Ingrediente: ${agua.nombre},  agregado a la receta '$titulo ' ")

            }
            "2" -> {
                var agua :Agua =Agua("Agua Caliente", cantidadDeseada)
                listaIngredientes.add(agua)
                println("Ingrediente: ${agua.nombre},  agregado a la receta '$titulo ' ")

            }
        }

    }

fun fruta(listaIngredientes: ArrayList<Ingrediente>, titulo: String){

    println("Elija el la fruta que desea:")
    for(fru in listaFrutas){
        println("${fru.key}  - ${fru.value}  ")
    }
    val frutaDeseada:String? = readLine()
    println("Escriba la cantidad deseada en unidades:")
    val cantidadDeseada:Int? = readLine()?.toInt()
    when(frutaDeseada){
        "1" -> {
            var fruta :Fruta =Fruta("Fresas", cantidadDeseada)
            listaIngredientes.add(fruta)
            println("Ingrediente: ${fruta.nombre},  agregado a la receta '$titulo ' ")

        }
        "2" -> {
            var fruta :Fruta =Fruta("Platano", cantidadDeseada)
            listaIngredientes.add(fruta)
            println("Ingrediente: ${fruta.nombre},  agregado a la receta '$titulo ' ")

        }

        "3" -> {
            var fruta :Fruta =Fruta("Uvas", cantidadDeseada)
            listaIngredientes.add(fruta)
            println("Ingrediente: ${fruta.nombre},  agregado a la receta '$titulo ' ")

        }

        "4" -> {
            var fruta :Fruta =Fruta("Manzana", cantidadDeseada)
            listaIngredientes.add(fruta)
            println("Ingrediente: ${fruta.nombre},  agregado a la receta '$titulo ' ")

        }

        "5" -> {
            var fruta :Fruta =Fruta("Naranja", cantidadDeseada)
            listaIngredientes.add(fruta)
            println("Ingrediente: ${fruta.nombre},  agregado a la receta '$titulo ' ")

        }

        "6" -> {
            var fruta :Fruta =Fruta("Pera", cantidadDeseada)
            listaIngredientes.add(fruta)
            println("Ingrediente: ${fruta.nombre},  agregado a la receta '$titulo ' ")

        }

        "7" -> {
            var fruta :Fruta =Fruta("Cerezas", cantidadDeseada)
            listaIngredientes.add(fruta)
            println("Ingrediente: ${fruta.nombre},  agregado a la receta '$titulo ' ")

        }
    }

}

fun aceite(listaIngredientes: ArrayList<Ingrediente>, titulo: String){

    println("Elija el la fruta que desea:")
    for(ace in listaAceites){
        println("${ace.key}  - ${ace.value}  ")
    }
    val aceiteDeseado:String? = readLine()
    println("Escriba la cantidad deseada en mililitros:")
    val cantidadDeseada:Int? = readLine()?.toInt()
    when(aceiteDeseado){
        "1" -> {
            var aceite : Aceite =Aceite("Oliva", cantidadDeseada)
            listaIngredientes.add(aceite)
            println("Ingrediente: ${aceite.nombre},  agregado a la receta '$titulo ' ")

        }
        "2" -> {
            var aceite :Aceite =Aceite("Girasol", cantidadDeseada)
            listaIngredientes.add(aceite)
            println("Ingrediente: ${aceite.nombre},  agregado a la receta '$titulo ' ")

        }

        "3" -> {
            var aceite :Aceite =Aceite("Coco", cantidadDeseada)
            listaIngredientes.add(aceite)
            println("Ingrediente: ${aceite.nombre},  agregado a la receta '$titulo ' ")

        }


    }

}

fun cereal(listaIngredientes: ArrayList<Ingrediente>, titulo: String){
    println("Elija el la fruta que desea:")

    for(cer in listaCereales){
        println("${cer.key}  - ${cer.value}  ")
    }
    val cerealDeseado:String? = readLine()
    println("Escriba la cantidad deseada en gramos:")
    val cantidadDeseada:Int? = readLine()?.toInt()
    when(cerealDeseado){
        "1" -> {
            var cereal : Cereal = Cereal("Avena", cantidadDeseada)
            listaIngredientes.add(cereal)
            println("Ingrediente: ${cereal.nombre},  agregado a la receta '$titulo ' ")

        }
        "2" -> {
            var cereal : Cereal = Cereal("Trigo", cantidadDeseada)
            listaIngredientes.add(cereal)
            println("Ingrediente: ${cereal.nombre},  agregado a la receta '$titulo ' ")

        }

        "3" -> {
            var cereal : Cereal = Cereal("Arroz", cantidadDeseada)
            listaIngredientes.add(cereal)
            println("Ingrediente: ${cereal.nombre},  agregado a la receta '$titulo ' ")

        }

        "4" -> {
            var cereal :Cereal =Cereal("Maiz", cantidadDeseada)
            listaIngredientes.add(cereal)
            println("Ingrediente: ${cereal.nombre},  agregado a la receta '$titulo ' ")

        }

    }
}

fun leche(listaIngredientes: ArrayList<Ingrediente>, titulo: String) {
    println("Escriba la cantidad deseada en mililitros:")
    val cantidadDeseada:Int? = readLine()?.toInt()

    var leche :Leche = Leche("Leche", cantidadDeseada)
    listaIngredientes.add(leche)
    println("Ingrediente: ${leche.nombre},  agregado a la receta '$titulo ' ")
}

fun huevos(listaIngredientes: ArrayList<Ingrediente>, titulo: String) {
    println("Escriba la cantidad deseada en unidades:")
    val cantidadDeseada:Int? = readLine()?.toInt()

    var huevos :Huevos = Huevos("Huevos", cantidadDeseada)
    listaIngredientes.add(huevos)
    println("Ingrediente: ${huevos.nombre},  agregado a la receta '$titulo ' ")
}

fun carne(listaIngredientes: ArrayList<Ingrediente>, titulo: String) {
    println("Escriba la cantidad deseada en gramos:")
    val cantidadDeseada:Int? = readLine()?.toInt()

    var carne :Carne = Carne("Leche", cantidadDeseada)
    listaIngredientes.add(carne)
    println("Ingrediente: ${carne.nombre},  agregado a la receta '$titulo ' ")
}

fun verdura(listaIngredientes: ArrayList<Ingrediente>, titulo: String) {

    println("Escriba la cantidad deseada en gramos:")
    val cantidadDeseada:Int? = readLine()?.toInt()

    var verdura :Verdura =Verdura("Leche", cantidadDeseada)
    listaIngredientes.add(verdura)
    println("Ingrediente: ${verdura.nombre},  agregado a la receta '$titulo ' ")

}