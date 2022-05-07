@file:Suppress("UNCHECKED_CAST")
/*
######################################################################
 Game rule:
 No try / catch
######################################################################
*/
fun main() {
    LiquidacionNomina(leerTipoDeEmpleado()).imprimirColillaDePago()
}

fun leerTipoDeEmpleado(): Pair<Int, String> {
        println("\nhola!\n" +
                "Cual tipo de empleado que desea calcular nomina:\n" +
                "1.Gerente\n" +
                "2.Operador\n" +
                "3.Contador\n" +
                "Por favor ingresa el numero correspondiente:")
        val numTipoDeEmpleado : String? = readLine()
        return validaCargoEmpleado(validadorMissInput(numTipoDeEmpleado))
}

fun validadorMissInput (
    valor: String?,
    letters: Regex = Regex("[a-zA-Z]"),
    simbolos: Regex = Regex("[|¬°\"\'!#\$%&/().=?¿¡+¨´*~{}\\[\\]^`\\-,;:_<>]|\\s")
): String? {
    when {
        valor == null -> {
            print("Campo no puede quedar vacio (desde validador).")
            reiniciar()
        }
        letters.containsMatchIn(valor.toString()) -> {
            print("No debe contener letras, ingrese un numero valido.")
            reiniciar()
        }
        simbolos.containsMatchIn(valor.toString()) -> {
            print("No puede llevar simbolos ni espacios!")
            reiniciar()
        }
    }
    return valor
}

fun validaCargoEmpleado(validadorMissInput: String?): Pair<Int, String> {
    var cargoEmpleado : Pair<Int, String> = 0 to ""
    when(validadorMissInput!!.toInt()) {
        1 -> cargoEmpleado = 0 to "Gerente"
        2 -> cargoEmpleado = 1 to "Operador"
        3 -> cargoEmpleado = 2 to "Contador"
        else -> {
            println("Debe ser un numero del 1 al 3")
            reiniciar()
        }
    }
    return cargoEmpleado
}


fun reiniciar() {
    print(" Reiniciando.")
    repeat(2){
        Thread.sleep(1000)
        print(" .")
    }
    Thread.sleep(400)
    main()
}

