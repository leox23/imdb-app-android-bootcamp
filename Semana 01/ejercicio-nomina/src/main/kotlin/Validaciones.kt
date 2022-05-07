import kotlin.system.exitProcess

abstract class Validaciones(val input: String?) {
    val numeros: Regex = Regex("[0-9]")
    val letters: Regex = Regex("[a-zA-Z]")
    val simbolos: Regex = Regex("\\W+|_")

    open fun validarAbs(): String {
        return input?.validarSiNulo()?.validarSiSimbolos().toString()
    }
    private fun Any.validarSiNulo(): String? {
        if (this == "") {
            print("Campo no puede quedar vacio.")
            exitProcess(-1)
        }
        return input
    }

    private fun Any.validarSiSimbolos(): String? {
        if (simbolos.containsMatchIn(input.toString())) {
            print("No puede llevar simbolos ni espacios!")
            exitProcess(-1)
        }
        return input
    }
}

class ValidarCargo(input: String?) : Validaciones(input) {
    fun validar(): Int {
       return validarAbs()!!.validarSiLetras().validaCargoEmpleado().toInt()
    }
    private fun Any.validarSiLetras(): Any {
        if (letters.containsMatchIn(input.toString())) {
            print("No debe contener letras, ingrese un numero valido.")
            exitProcess(-1)
        }
        return input!!
    }
    private fun Any.validaCargoEmpleado(): String {
        if (input!!.toInt() !in (1..3)){
            print("El numero debe ser 1,2 o 3!")
            exitProcess(-1)
        }
        return input
    }
}

class ValidarNombre(input: String?) : Validaciones(input.toString()) {
    fun validar(): String {
        return validarAbs()!!.validarSiNumeros() as String
    }
    private fun Any.validarSiNumeros(): Any {
        if (numeros.containsMatchIn(input.toString())) {
            print("No puede contener números!")
            exitProcess(-1)
        }
        return input!!
    }
}