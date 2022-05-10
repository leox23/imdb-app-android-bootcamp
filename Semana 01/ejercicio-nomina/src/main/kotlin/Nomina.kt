class Empleado(
    private var infoEmpleado: Pair<Int, String>
) {
                                                     // nada, gerente, operador, contador
    private val valorDeHoraEmpleados: List<Int> = listOf(0, 200, 10, 50)
    private val horasQueTrabajanAlMes: List<Int> = listOf(0, 200, 230, 200)
    var tipoDeCargo = infoEmpleado.first
    private var nombreEmpleado = infoEmpleado.second
    private val nombreCargo = listOf( "", "Gerente", "Operador", "Contador")
    val valorDeLaHora: Int = valorDeHoraEmpleados[tipoDeCargo]
    private val horasAlMes: Int = horasQueTrabajanAlMes[tipoDeCargo]
    private val bono = Bono(tipoDeCargo,valorDeLaHora).calcular()

    private fun salarioBruto(): Int {
        return valorDeLaHora * horasAlMes
    }

    private fun salarioNeto(): Double {
        return salarioBruto() + bono.toDouble()
    }
    fun imprimirColillaDePago(){
        return println("---------------------------------------------------------------\n" +
                "Nombre Empleado: $nombreEmpleado.\n" +
                "Cargo: ${nombreCargo[tipoDeCargo]}.\n" +
                "---------------------------------------------------------------\n" +
                "Horas que Trabaja | Valor por hora | Salario Bruto | Bono\n" +
                "$horasAlMes            | $valorDeLaHora             | ${salarioBruto()} y bono de: $bono \n" +
                "---------------------------------------------------------------\n" +
                "Salario Neto a pagar: | \uD83D\uDCB8\$${salarioNeto()} |\n" +
                "---------------------------------------------------------------\n")

    }

}

class Bono(private val tipoDeCargo: Int, private val valorDeLaHora : Int,
           private val horasPagadasPorBono: Int = 10
) {
    fun calcular(): Int {
                  // si es un operador
        return if ( tipoDeCargo == 2) {
                    horasPagadasPorBono * valorDeLaHora
                } else {
                    0
                }
    }
}

