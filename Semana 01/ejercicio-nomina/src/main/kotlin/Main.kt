@file:Suppress("UNCHECKED_CAST")

/*
######################################################################
 Game rule:
 No try / catch
######################################################################
*/
fun main() {
    Empleado(
            Pair(ValidarCargo(leerTipoDeEmpleado()).validar(),
                ValidarNombre(leerNombreEmpleado()).validar()))
            .imprimirColillaDePago()
}

fun leerTipoDeEmpleado(): String? {
        println("\nhola!\n" +
                "Cual tipo de empleado que desea calcular nomina:\n" +
                "1.Gerente\n" +
                "2.Operador\n" +
                "3.Contador\n" +
                "Por favor ingresa el numero correspondiente:")
        return readLine()
}

fun leerNombreEmpleado(): String? {
    println("¿Cual es el nombre del empleado?")
    return readLine()
}
