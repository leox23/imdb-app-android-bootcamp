/*
Luego de terminar los codelabs, por favor solucionen este ejercicio
aplicando los conceptos de POO y principios de diseño que prendieron esta semana.
No hagan nada sobre este ejercicio hasta no terminar los codelabs por completo.
A continuación el enunciado:

Escribir un programa que calcule el salario para estos tres roles:
* Gerente se gana 200 por hora y trabaja 200 horas al mes
* Operador se gana 10 por hora y trabaja 230 horas al mes
* Contador se gana 50 por hora y trabaja 200 horas al mes

Cada puesto puede tener un bonus que se calcula con base al valor de 10 horas
adicionales de trabajo de acuerdo con el valor de la hora de cada puesto, para este caso,
Solo el operador se ha ganado el bono y el gerente y el contador no.
*/
// Gran rule:
// No try catch, No NullPointerException

fun main(args: Array<String>) {
    leerDatos()
}

fun leerDatos() {
    var cargoEmpleado = leerTipoDeEmpleado()
    println("desde dentro de leerDatos, soy empleado $cargoEmpleado")
    var horasTrabajadas = leerHorasTrabajadas()
    println("Y trabajo $horasTrabajadas horas este mes que paso")
}

fun leerTipoDeEmpleado(): String? {
        println("\nhola!\n" +
                "Cual tipo de empleado que desea calcular nomina:\n" +
                "1.Gerente\n" +
                "2.Operador\n" +
                "3.Contador\n" +
                "Por favor ingresa el numero correspondiente:")
        var numTipoDeEmpleado : String? = readLine()
        return validaCargoEmpleado(validadorMissInput(numTipoDeEmpleado))
}

fun validadorMissInput (
    valor: String?,
    letters: Regex = Regex("[a-zA-Z]"),
    // este siguiente busca todos los simbolos menos el punto "." que este dentro de cadena
    simbolos: Regex = Regex("[|¬°\\\"\\'!#\$%&/\\(\\)=?¿¡+¨´*~\\{\\}\\[\\]\\^\\`\\-,;:_\\<\\>]|^\\.|\\.")
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
    } else if ( " " in valor) {
        print("No puede contener espacios, ingresar un numero valido")
        reiniciar()
    }
    return valor
}

fun validaCargoEmpleado(validadorMissInput: String?): String? {
    return when(validadorMissInput!!.toInt()) {
        1 -> "Gerente"
        2 -> "Operador"
        3 -> "Contador"
        else -> {println("Debe ser un numero del 1 al 3").toString(); reiniciar().toString()}
    }
}

fun leerHorasTrabajadas() {
    println("Ingresa la cantidad de horas que trabajo el empleado:")
    var horastrabajadas : String? = readLine()
    validarHorasTrabajadas(validadorMissInput(horastrabajadas))
}

fun validarHorasTrabajadas(validadorMissInput: String?): Any {
    return when(validadorMissInput!!.toInt()) {
        in 100..300 -> validadorMissInput.toDouble()
        in 1..99 -> {validadorMissInput.toDouble(); println("Muy pocas horas, validar alguna novedad con recursos humanos")}
        else -> {print("No esta permitido trabajar mas de 300 horas al mes.").toString(); reiniciar().toString()}
    }
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

