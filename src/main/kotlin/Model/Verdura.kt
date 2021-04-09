package Model

class Verdura(nombre :String, cantidad :Int?) :Ingrediente(nombre,cantidad)  {

    override val categoria = "Verdura"
}