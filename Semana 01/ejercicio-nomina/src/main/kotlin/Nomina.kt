data class ValoresNominasSegunContratos(
                                       // gerente, operador, contador
     val valorDeHoraEmpleados: List<Int> = listOf(200, 10, 50),
     val horasQueTrabajanAlMes: List<Int> = listOf(200, 230, 200),
     val horasParaPoderGanarBono: List<Int> = listOf(250, 230, 240),
     val horasPagadasPorBono : Int = 10
)

open class LiquidacionNomina(
    infoParaCalculoDeNomina : Triple<Int, String, Double>
) {
    // ni idea de porque no funciona la desestructuración aqui  D:
    //var (tipoDeCargo, _, horasTrabajadas) = infoParaCalculoDeNomina
    private var tipoDeCargo = infoParaCalculoDeNomina.first
    private var nombreCargo = infoParaCalculoDeNomina.second
    private var horasTrabajadas = infoParaCalculoDeNomina.third
    private val valorDeLaHora = ValoresNominasSegunContratos().valorDeHoraEmpleados[tipoDeCargo]
    private val bono = Bono(tipoDeCargo,horasTrabajadas).calcular()

    private fun salarioBruto(): Double {
        return valorDeLaHora.toDouble() * horasTrabajadas
    }

    private fun salarioNeto(): Double {
        return salarioBruto() + bono
    }
    fun imprimirColillaDePago(){
        return println("---------------------------------------------------------------\n" +
                "Cargo del empleado: $nombreCargo\n" +
                "Horas Trabajadas | Valor por hora | Salario Bruto | Bono\n" +
                "$horasTrabajadas            | $valorDeLaHora             | ${salarioBruto()} y bono de: $bono \n" +
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
class Bono(tipoDeCargo : Int, private var horasTrabajadas : Double){
    private val horasPagadasPorBono = ValoresNominasSegunContratos().horasPagadasPorBono
    private val horasParaPoderGanarBono = ValoresNominasSegunContratos().horasParaPoderGanarBono[tipoDeCargo]
    private val valorDeLaHora = ValoresNominasSegunContratos().valorDeHoraEmpleados[tipoDeCargo]
    fun calcular(): Double {
        return if (horasTrabajadas >= horasParaPoderGanarBono) {
                    horasPagadasPorBono.toDouble() * valorDeLaHora
                } else {
                    0.0
                }
        }
    }
