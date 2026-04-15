import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P2 {

    // Método genérico para limpiar una línea de log.
    public static String limpiarLineaLog(
        String linea,
        String quitarPrefijo,
        boolean aMayusculas,
        boolean aMinusculas
    ) {
        String lineaLimpia = linea;
        if (linea.startsWith(quitarPrefijo)) {
            lineaLimpia = linea.substring(quitarPrefijo.length()).strip();
        }
        
        if (aMayusculas) {
            return lineaLimpia.toUpperCase();
        } else if (aMinusculas) {
            return lineaLimpia.toLowerCase();
        } else {
            return lineaLimpia;
        }
    }

    public static void main(String[] args) {
        // --- TAREAS ---

        // 1. Crear un limpiador para logs de Apache.
        //    Define una lambda `Function<String, String>` que llame a `limpiarLineaLog`
        //    con los argumentos para prefijo y minúsculas fijados.
        Function<String, String> limpiarApache = linea -> limpiarLineaLog(linea, "[apache]", false, true);

        // 2. Crear un limpiador para logs del sistema (syslog).
        Function<String, String> limpiarSyslog = linea -> limpiarLineaLog(linea, "", false, false);
        
        // 3. Crear un limpiador para logs de errores críticos de una aplicación.
        Function<String, String> limpiarErrorCritico = linea -> limpiarLineaLog(linea, "CRITICAL:", true, false);
        
        // --- Pruebas ---
        List<String> logsApache = List.of(
            "[apache] 200 OK: /index.html",
            "[apache] 404 Not Found: /missing.jpg"
        );
        List<String> logsSyslog = List.of(
            "Aug 29 04:13:01 my-pc CRON[1234]: session opened",
            "Aug 29 04:13:02 my-pc systemd[1]: Started session 1."
        );
        List<String> logsCriticos = List.of(
            "CRITICAL: Database connection lost",
            "CRITICAL: User authentication service failed"
        );

        try {
            List<String> logsApacheLimpios = logsApache.stream().map(limpiarApache).collect(Collectors.toList());
            System.out.println("Logs de Apache Limpios: " + logsApacheLimpios);

            List<String> logsSyslogLimpios = logsSyslog.stream().map(limpiarSyslog).collect(Collectors.toList());
            System.out.println("\nLogs de Syslog Limpios: " + logsSyslogLimpios);

            List<String> logsCriticosLimpios = logsCriticos.stream().map(limpiarErrorCritico).collect(Collectors.toList());
            System.out.println("\nLogs Críticos Limpios: " + logsCriticosLimpios);
        } catch (Exception e) {
            // Evita error si las funciones no están definidas todavía
            e.printStackTrace();
        }
    }
}