class ControlGastosTelefonicos { // Variables privadas para llevar el registro de las llamadas y sus costos
    private var locales = 0 // Contador para las llamadas locales
    private var LargaDistancia = 0 // Contador para las llamadas a larga distancia
    private var celular = 0 // Contador para las llamadas a celulares
    private var duracionTotal = 0 // Duración total de todas las llamadas en minutos
    private var costoTotal = 0.0 // Costo total acumulado de las llamadas

    fun registrarLlamada(tipoLlamada: Int, tiempo: Int) { // Función para registrar una llamada según su tipo y duración
        when (tipoLlamada) { // Se utiliza una expresión 'when' para manejar diferentes tipos de llamadas
            1 -> {
                locales++ // Incrementa el contador de llamadas locales
                costoTotal += (tiempo * 50).toDouble() // Suma el costo de la llamada local al costo total
            }

            2 -> {
                LargaDistancia++ // Incrementa el contador de llamadas a larga distancia
                costoTotal += (tiempo * 350).toDouble()// Suma el costo de la llamada a larga distancia al costo total
            }

            3 -> {
                celular++ // Incrementa el contador de llamadas a celulares
                costoTotal += (tiempo * 150).toDouble()
            }

            else -> println("Error llamada no valida")
        }
        duracionTotal += tiempo // Agrega la duración de la llamada al tiempo total
    }

    fun mostrarInformacionDetallada() { // Función para mostrar información detallada sobre las llamadas registradas
        println("Cantidad de llamadas locales: $locales")
        println("Cantidad de llamadas a larga distancia: $LargaDistancia")
        println("Cantidad de llamadas a celular: $celular")
        println("Tiempo total de llamadas en minutos: $duracionTotal")
        println("Costo total de las llamadas: $costoTotal")
    }

    var costoPromedio: Double = 0.0 // Variable para almacenar el costo promedio por minuto de las llamadas

    init { // Bloque 'init' que inicializa las variables al crear una instancia de la clase
        this.locales = 0
        this.LargaDistancia = 0
        this.celular = 0
        this.duracionTotal = 0
        this.costoTotal = 0.0
    }

    fun mostrarConsolidadoTotal() {
        val totalLlamadas = locales + LargaDistancia + celular // Calcula el número total de llamadas

        costoPromedio = if (duracionTotal > 0) costoTotal / duracionTotal else 0.0 // Calcula el costo promedio por minuto si hay alguna duración total


        println("Costo total de la línea: $costoTotal")
        println("Cantidad total de llamadas realizadas: $totalLlamadas")
        println("Tiempo total de llamadas en minutos: $duracionTotal")
        println("Promedio del costo por minuto: $costoPromedio")
    }

    fun reiniciarUsoLinea() {
        locales = 0
        LargaDistancia = 0
        celular = 0
        duracionTotal = 0
        costoTotal = 0.0
        println("Uso de la línea telefónica reiniciado.")
    }
}