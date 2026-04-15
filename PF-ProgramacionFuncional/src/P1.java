import java.util.function.Supplier;

public class P1 {

    // TAREA: Implementar la fábrica de generadores de secuencias.
    //
    // El método estático `crearGenerador` debe:
    // 1. Aceptar dos argumentos: `inicio` y `paso`.
    // 2. Devolver un objeto que implemente la interfaz funcional `Supplier<Integer>`.
    //    (Supplier<T> representa una función que no toma argumentos y devuelve un valor de tipo T).
    //
    // Para manejar el estado mutable dentro de una lambda, que requiere que
    // las variables capturadas sean 'efectivamente finales', se puede usar un
    // truco común: utilizar un array de un solo elemento o un objeto mutable
    // como `AtomicInteger`.
    //
    // 3. Declara una variable para el estado actual. Un array `int[]` de tamaño 1
    //    es una buena opción. Decláralo como `final`.
    // 4. La lambda que implementa `Supplier` debe:
    //    a. Obtener el valor actual del estado.
    //    b. Actualizar el estado en el array sumándole el `paso`.
    //    c. Devolver el valor que se obtuvo antes de la actualización.

    public static Supplier<Integer> crearGenerador(int inicio, int paso) {
        final int[] estado = new int[]{inicio};
        
        return () -> {
            int actual = estado[0];
            estado[0] += paso;
            return actual;
        };
    }

    public static void main(String[] args) {
        // --- Pruebas ---
        Supplier<Integer> generadorDePares = crearGenerador(0, 2);
        System.out.println("Generador de pares:");
        System.out.println(generadorDePares.get()); // Esperado: 0
        System.out.println(generadorDePares.get()); // Esperado: 2
        System.out.println(generadorDePares.get()); // Esperado: 4

        Supplier<Integer> generadorDeCincos = crearGenerador(100, 5);
        System.out.println("\nGenerador de cincos:");
        System.out.println(generadorDeCincos.get()); // Esperado: 100
        System.out.println(generadorDeCincos.get()); // Esperado: 105
    }
}
