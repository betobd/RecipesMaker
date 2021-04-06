import java.sql.Array
//val listaIngredientes: ArrayList<String> = ArrayList()
class Receta {

    //val listaRecetas = arrayListOf<ArrayList<String>>()
    private var titulo: String = ""
    private var ingredientes: ArrayList<String> = ArrayList()

    constructor(titulo: String, ingredientes: ArrayList<String>){
        this.titulo = titulo
        this.ingredientes = ingredientes
    }



    fun verNombre(): String{
        return this.titulo
    }

    fun verIngredientes() : List<String> {
        return this.ingredientes
    }

}

