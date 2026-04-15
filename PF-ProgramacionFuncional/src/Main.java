import java.util.Map;
import java.util.Optional;

class Usuario {
    private int id;
    private String email;
    private String nombre;
    public Usuario(int id, String email, String nombre) {
        this.id = id; this.email = email; this.nombre = nombre;
    }
    public String getNombre() { return nombre; }
}

class RepositorioUsuarios {
    private Map<String, Usuario> usuarios = Map.of(
        "alice@example.com", new Usuario(1, "alice@example.com", "Alice"),
        "bob@example.com", new Usuario(2, "bob@example.com", "Bob")
    );

    // --- TAREA 1: Refactoriza este método ---
    // Cambia el método para que devuelva un Optional<Usuario>.
    // Usa Optional.ofNullable() para envolver el resultado de map.get().
    public Optional<Usuario> buscarPorEmail(String email) { // <- Modifica esta línea
        return Optional.ofNullable(usuarios.get(email));
    }
}

public class Main {
    // --- TAREA 2: Refactoriza el código de consumo ---
    // Este código es inseguro. Modifícalo para que use los métodos
    // de Optional y devuelva un mensaje predeterminado si el usuario no se encuentra.
    public static String obtenerNombreCapitalizado(RepositorioUsuarios repo, String email) {
        return repo.buscarPorEmail(email)
                   .map(usuario -> "Nombre: " + usuario.getNombre().toUpperCase())
                   .orElse("Nombre: Usuario no encontrado"); // Añadí "Nombre: " para mantener el formato si se desea, o sólo el mensaje
    }

    // --- Pruebas (no modificar el interior del main) ---
    public static void main(String[] args) {
        RepositorioUsuarios repo = new RepositorioUsuarios();

        // Caso 1: Usuario encontrado
        System.out.println(obtenerNombreCapitalizado(repo, "alice@example.com"));

        // Caso 2: Usuario no encontrado (esto causa NullPointerException)
        System.out.println(obtenerNombreCapitalizado(repo, "charlie@example.com"));
    }
}
