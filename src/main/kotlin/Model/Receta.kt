import Model.Ingrediente

class Receta(titulo: String, ingredientes: ArrayList<Ingrediente>) {

    //val listaRecetas = arrayListOf<ArrayList<String>>()
    private var titulo: String = ""
    private var ingredientes: ArrayList<Ingrediente> = ArrayList()

    init {
        this.titulo = titulo
        this.ingredientes = ingredientes
    }

    fun verNombre(): String {
        return this.titulo
    }

    fun verIngredientes() {
        for (ing in this.ingredientes) {
            // if(ing.categoria.equals("Agua") ||ing.categoria.equals("Aceite"))
            //  println("      ${ing.nombre}  - ${ing.cantidad} mililitros  ")
            // else println("      ${ing.nombre}  - ${ing.cantidad} gramos  ")

            when (ing.categoria) {
                "Agua" -> println("      ${ing.nombre} - ${ing.cantidad} mililitros")
                "Aceite" -> println("      ${ing.nombre} - ${ing.cantidad} mililitros")
                "Fruta" -> println("      ${ing.nombre} - ${ing.cantidad} unidades")
                "Cereal" -> println("      ${ing.nombre} - ${ing.cantidad} gramos")
                "Carne" -> println("      ${ing.nombre} - ${ing.cantidad} gramos")
                "Huevos" -> println("      ${ing.nombre} - ${ing.cantidad} unidades")
                "Leche" -> println("      ${ing.nombre} - ${ing.cantidad} mililitros")
                "Verdura" -> println("      ${ing.nombre} - ${ing.cantidad} gramos")

            }
        }


    }


}

