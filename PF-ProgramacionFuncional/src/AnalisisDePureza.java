import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

class AnalisisDePureza {

    // --- Función 1 ---
    // [Pura] - Depende únicamente de sus parámetros de entrada, no altera el estado externo y siempre devuelve el mismo resultado para las mismas entradas.
    public String formatearNombre(String nombre, String apellido) {
        if (nombre == null || apellido == null) {
            return "";
        }
        return apellido.toUpperCase() + ", " + nombre;
    }


    // --- Función 2 ---
    private static int visitas_servidor = 0;
    // [Impura] - Modifica una variable de estado global estática (`visitas_servidor`) y realiza operaciones de entrada/salida (System.out.println), lo que son efectos secundarios.
    public void registrarVisita() {
        visitas_servidor++;
        System.out.println("Visitas totales: " + visitas_servidor);
    }


    // --- Función 3 ---
    // [Impura] - No es determinista. Depende de factores externos (UUID.randomUUID()) y devuelve un resultado diferente en cada invocación, incluso sin parámetros.
    public String generarTokenUnico() {
        // UUID.randomUUID() depende de factores externos como la MAC o números aleatorios
        return UUID.randomUUID().toString();
    }


    // --- Función 4 ---
    // [Impura] - Tiene efectos secundarios sobre los argumentos de entrada. `Collections.sort()` modifica la lista original `numeros` in-place.
    public List<Integer> duplicarYOrdenar(List<Integer> numeros) {
        // Collections.sort() modifica la lista original
        Collections.sort(numeros);
        return numeros.stream().map(n -> n * 2).collect(Collectors.toList());
    }


    // --- Función 5 ---
    // [Pura] - No modifica la lista original de entrada. Utiliza streams para crear y devolver una lista nueva. Siempre da el mismo resultado para la misma lista de entrada.
    public List<Integer> obtenerPares(List<Integer> numeros) {
        return numeros.stream()
                      .filter(n -> n % 2 == 0)
                      .collect(Collectors.toList());
    }


    // --- Función 6 ---
    // [Impura] - No es determinista, su valor de retorno depende del reloj del sistema y cambiará con el paso del tiempo.
    public long segundosDesdeEpoca() {
        // System.currentTimeMillis() depende del reloj del sistema
        return System.currentTimeMillis() / 1000L;
    }
}