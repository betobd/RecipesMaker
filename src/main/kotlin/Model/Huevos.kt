package Model

class Huevos(nombre :String, cantidad :Int?) :Ingrediente(nombre,cantidad) {

    override val categoria = "Huevos"
}