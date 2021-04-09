package Model

abstract class Ingrediente(nombre: String, cantidad: Int?){

    open val categoria = ""
    var nombre: String =""
    var cantidad: Int? = 0

    init {
        this.nombre=nombre
        this.cantidad=cantidad
    }

}