import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ReporteImpuro {

    /**
     * Método impuro que formatea nombres y escribe el resultado en un archivo.
     */
    public void generarReporteBienvenida(List<String> nuevosUsuarios) {
        try (FileWriter writer = new FileWriter("bienvenida.txt")) {
            // 1. Lógica de negocio
            String cabecera = "--- Reporte de Bienvenida ---\n";
            String cuerpo = nuevosUsuarios.stream()
                .filter(u -> u != null && !u.isBlank())
                .map(u -> "- ¡Bienvenido, " + u.trim().toUpperCase() + "!")
                .collect(Collectors.joining("\n"));
            
            String reporteCompleto = cabecera + cuerpo;

            // 2. Efecto: Escritura en archivo
            writer.write(reporteCompleto);

        } catch (IOException e) {
            System.err.println("Error al escribir el reporte: " + e.getMessage());
        }
    }
}

// --- TAREA ---
// Refactoriza el código anterior en una nueva clase `ReporteFuncional`.
// Debes crear:
// 1. Un método estático y PURO llamado `generarContenidoReporte` que tome la lista
//    de usuarios y devuelva el contenido del reporte como un String.
// 2. Un método IMPURO (no estático) llamado `escribirReporte` que tome la lista
//    de usuarios, llame a `generarContenidoReporte` para obtener el contenido,
//    y luego se encargue de escribir ese contenido en el archivo.

class ReporteFuncional {

    /**
     * 1. Método estático y PURO que toma la lista de usuarios y devuelve el contenido del reporte como un String.
     * No tiene efectos secundarios, solo transforma los datos de entrada en una salida predecible.
     */
    public static String generarContenidoReporte(List<String> nuevosUsuarios) {
        String cabecera = "--- Reporte de Bienvenida ---\n";
        String cuerpo = nuevosUsuarios.stream()
            .filter(u -> u != null && !u.isBlank())
            .map(u -> "- ¡Bienvenido, " + u.trim().toUpperCase() + "!")
            .collect(Collectors.joining("\n"));
        
        return cabecera + cuerpo;
    }

    /**
     * 2. Método IMPURO que coordina la generación del reporte y la escritura en disco.
     * Es impuro porque realiza operaciones de entrada/salida (I/O).
     */
    public void escribirReporte(List<String> nuevosUsuarios) {
        // Separamos la lógica pura (generar string) del efecto secundario (escribir archivo)
        String reporteCompleto = generarContenidoReporte(nuevosUsuarios);

        // Efecto secundario: Escritura en archivo
        try (FileWriter writer = new FileWriter("bienvenida.txt")) {
            writer.write(reporteCompleto);
            System.out.println("Reporte generado exitosamente en bienvenida.txt");
        } catch (IOException e) {
            System.err.println("Error al escribir el reporte: " + e.getMessage());
        }
    }
}