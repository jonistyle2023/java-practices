import java.util.HashSet;
import java.util.Set;

public record ConfiguracionInmutable(String nombreApp, String version, Set<String> modosActivos) {

    // Constructor compacto: garantiza que la colección interna sea verdaderamente inmutable
    public ConfiguracionInmutable {
        modosActivos = Set.copyOf(modosActivos);
    }

    // Lógica que "actualiza" la configuración devolviendo una nueva instancia (sin mutar la original)
    public static ConfiguracionInmutable activarModoDebug(ConfiguracionInmutable config) {
        Set<String> nuevosModos = new HashSet<>(config.modosActivos());
        nuevosModos.add("DEBUG");
        
        ConfiguracionInmutable nuevaConfig = new ConfiguracionInmutable(
            config.nombreApp(), 
            config.version(), 
            nuevosModos
        );
        System.out.println("Modo DEBUG activado en " + nuevaConfig);
        return nuevaConfig;
    }

    // --- Uso ---
    public static void main(String[] args) {
        Set<String> modos = new HashSet<>(Set.of("LOGGING", "CACHE"));
        ConfiguracionInmutable configInicial = new ConfiguracionInmutable("Mi Servidor", "1.0.1", modos);
        System.out.println("Configuración inicial: " + configInicial);

        // Capturamos el nuevo estado devuelto por el método
        ConfiguracionInmutable configFinal = activarModoDebug(configInicial);

        // Verificamos que el estado original permanece intacto
        System.out.println("Configuración inicial (sin modificar): " + configInicial);
        System.out.println("Configuración final: " + configFinal);
    }
}
