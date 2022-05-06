@file:Suppress("UNCHECKED_CAST")
/*
######################################################################
 Game rule:
 No try / catch
######################################################################
*/
fun main() {
    LiquidacionNomina(leerDatos() as Triple<Int, String, Double>).imprimirColillaDePago()
}


fun leerDatos(): Triple<Int, String, Any> {
    val cargoEmpleado = leerTipoDeEmpleado() //par
    val horasTrabajadas = leerHorasTrabajadas()
    return Triple(cargoEmpleado.first, cargoEmpleado.second, horasTrabajadas)
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
    // este regex busca todos los simbolos (teclas fisicas normales).
    // Menos el punto "." que este dentro de cadena.
    // o que empieze y finalize en punto
    simbolos: Regex = Regex("[|¬°\"\'!#\$%&/()=?¿¡+¨´*~{}\\[\\]^`\\-,;:_<>]|^\\.|\\.\$")
): String? {
    if (valor == null) {
        print("Campo no puede quedar vacio (desde validador).")
        reiniciar()
    } else if (letters.containsMatchIn(valor.toString())) {
        print("No debe contener letras, ingrese un numero valido.")
        reiniciar()
    } else if (simbolos.containsMatchIn(valor.toString())) {
        print("No puede llevar simbolos, solo el punto para valores con decimas.\n" +
                "no puede comenzar o terminar en punto.")
        reiniciar()
    } else if ( valor.count{ ".".contains(it)} > 1) {
        print("Solo debe llevar un punto para ser double.")
        reiniciar()
    } else if ( " " in valor) {
        print("No puede contener espacios, ingresar un numero valido")
        reiniciar()
    }
    return valor
}

fun validaCargoEmpleado(validadorMissInput: String?): Pair<Int, String> {
    var cargoEmpleado : Pair<Int, String> = 0 to ""
    if (validadorMissInput!!.toInt() == 1) cargoEmpleado = 0 to "Gerente"
    else if (validadorMissInput.toInt() == 2) cargoEmpleado = 1 to "Operador"
    else if (validadorMissInput.toInt() == 3) cargoEmpleado = 2 to "Contador"
    else {println("Debe ser un numero del 1 al 3").toString(); reiniciar().toString()}
    return cargoEmpleado
}

fun leerHorasTrabajadas(): Any {
    println("Ingresa la cantidad de horas que trabajo el empleado:")
    return validarHorasTrabajadas(validadorMissInput(readLine())!!.toDouble())
}

fun validarHorasTrabajadas(validadorMissInput: Double): Double {
    var temp = 0.0
    when (validadorMissInput) {
        in 0.0 .. 99.9 -> {
            temp = validadorMissInput
            println("Muy pocas horas, validar alguna novedad con recursos humanos")
        }
        in 100.0 .. 300.0 -> {
            temp = validadorMissInput
        }
        else -> {
            println("No esta permitido trabajar mas de 300 horas al mes.").toString()
            leerHorasTrabajadas().toString()
        }
    }
    return temp
}


fun reiniciar() {
    print(" Reiniciando.")
    repeat(2){
        Thread.sleep(1000)
        print(" .")
    }
    Thread.sleep(400)
    leerDatos()
}

