package Model

class Carne (nombre :String, cantidad :Int?) :Ingrediente(nombre,cantidad) {

    override val categoria = "Carne"
}