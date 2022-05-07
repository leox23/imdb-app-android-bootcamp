data class ValoresNominasSegunContratos(
                                       // gerente, operador, contador
     val valorDeHoraEmpleados: List<Int> = listOf(200, 10, 50),
     val horasQueTrabajanAlMes: List<Int> = listOf(200, 230, 200),
     val horasPagadasPorBono : Int = 10
)

open class LiquidacionNomina(
    infoParaCalculoDeNomina: Pair<Int, String>
) {
    // ni idea de porque no funciona la desestructuración aqui  D:
    //var (tipoDeCargo, _) = infoParaCalculoDeNomina
    private var tipoDeCargo = infoParaCalculoDeNomina.first
    private var nombreCargo = infoParaCalculoDeNomina.second
    private val valorDeLaHora: Int = ValoresNominasSegunContratos().valorDeHoraEmpleados[tipoDeCargo]
    private val horasAlMes: Int = ValoresNominasSegunContratos().horasQueTrabajanAlMes[tipoDeCargo]
    private val bono = Bono(tipoDeCargo).calcular(tipoDeCargo)

    private fun salarioBruto(): Int {
        return valorDeLaHora * horasAlMes
    }

    private fun salarioNeto(): Double {
        return salarioBruto() + bono.toDouble()
    }
    fun imprimirColillaDePago(){
        return println("---------------------------------------------------------------\n" +
                "Cargo del empleado: $nombreCargo\n" +
                "Horas que Trabaja | Valor por hora | Salario Bruto | Bono\n" +
                "$horasAlMes            | $valorDeLaHora             | ${salarioBruto()} y bono de: $bono \n" +
                "---------------------------------------------------------------\n" +
                "Salario Neto a pagar: | \uD83D\uDCB8\$${salarioNeto()} |\n" +
                "---------------------------------------------------------------\n")

    }

}

// en lo largo de una empresa las mecanicas de los bonos
// cambian mucho, aqui esta resuelto muy directo y sencillo,
// pero se que hay muchos casos de revisiones
// de muchos tipos de metricas
// por eso conviene tenerlo aparte
class Bono(tipoDeCargo: Int) {
    private val horasPagadasPorBono = ValoresNominasSegunContratos().horasPagadasPorBono
    private val valorDeLaHora = ValoresNominasSegunContratos().valorDeHoraEmpleados[tipoDeCargo]
    fun calcular(tipoDeCargo : Int): Int {
        return if ( tipoDeCargo == 1) {
                    horasPagadasPorBono * valorDeLaHora
                } else {
                    0
                }
    }
}
