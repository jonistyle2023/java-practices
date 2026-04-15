import java.util.Optional;

class PeticionHttp {
    private String cabeceraAuth; // Puede ser null

    public PeticionHttp(String cabeceraAuth) {
        this.cabeceraAuth = cabeceraAuth;
    }

    public Optional<String> getCabeceraAuth() {
        return Optional.ofNullable(cabeceraAuth);
    }
}

class Main {

    // --- TAREA ---
    // Completa el método `extraerBearerToken`.
    // Debes usar la API de Optional (map, filter) para implementar la lógica de forma segura.
    // La lógica es:
    // 1. Obtener la cabecera de autenticación opcional de la petición.
    // 2. Filtrar la cabecera para asegurarse de que empieza con "Bearer " (con espacio).
    // 3. Mapear la cabecera para extraer solo la parte del token (lo que viene después de "Bearer ").
    //
    // El método debe devolver un Optional<String> con el token.
    public static Optional<String> extraerBearerToken(PeticionHttp peticion) {
        return peticion.getCabeceraAuth()
                .filter(cabecera -> cabecera.startsWith("Bearer "))
                .map(cabecera -> cabecera.substring("Bearer ".length()));
    }

    // --- Pruebas ---
    public static void main(String[] args) {
        PeticionHttp peticionConToken = new PeticionHttp("Bearer a1b2c3d4e5");
        PeticionHttp peticionConTokenInvalido = new PeticionHttp("Basic xyz");
        PeticionHttp peticionSinToken = new PeticionHttp(null);

        System.out.println("Petición 1: " + extraerBearerToken(peticionConToken));
        System.out.println("Petición 2: " + extraerBearerToken(peticionConTokenInvalido));
        System.out.println("Petición 3: " + extraerBearerToken(peticionSinToken));
    }
}
