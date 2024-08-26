import java.util.*

fun main(args: Array<String>) { // Función principal que ejecuta el programa

        val tiemposA = Random() // Generador de números aleatorios para simular la duración de las llamadas

        val controlGastos: ControlGastosTelefonicos = ControlGastosTelefonicos() // Creación de una instancia de la clase ControlGastosTelefonicos
        val scanner = Scanner(System.`in`) // Creación de un objeto Scanner para leer la entrada del usuario

        var opcion: Int // Variable para almacenar la opción seleccionada por el usuario


    do { // Menú principal que muestra las opciones al usuario
            println("\nMenú principal:")
            println("1. Registrar llamada")
            println("2. Mostrar información detallada")
            println("3. Mostrar consolidado total")
            println("4. Reiniciar uso de la línea")
            println("0. Salir")
            print("Selecciona una opción:\n ")
            opcion = scanner.nextInt()  // Lee la opción seleccionada por el usuario

            when (opcion) { // Ejecuta una acción según la opción seleccionada
                1 -> {
                    println("Que tipo de llamada deseas realizar elije una opcion:\n")
                    println("1: Local, 2: Larga Distancia, 3: Celular ")
                    val tipoLlamada = scanner.nextInt()

                    val duracionLlamada = (Math.random() * 60 + 1).toInt()
                    print("Duración de la llamada en minutos: $duracionLlamada")
                    controlGastos.registrarLlamada(tipoLlamada, duracionLlamada)
                }

                2 -> controlGastos.mostrarInformacionDetallada() // Muestra la información detallada de todas las llamadas registradas
                3 -> controlGastos.mostrarConsolidadoTotal() // Muestra el consolidado total de todas las llamadas
                4 -> controlGastos.reiniciarUsoLinea()// Reinicia el uso de la línea, restableciendo los contadores y costos
                0 -> println("Gracias por usar nuestros servicios.") // Si el usuario selecciona salir del programa
                else -> {
                    println("Opción no válida. Inténtalo de nuevo.")

                }
            }
        } while (opcion != 0) // El programa se repite hasta que el usuario selecciona salir (opción 0)

        scanner.close()
}