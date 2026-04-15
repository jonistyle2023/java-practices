import java.util.Base64;
//import org.json.JSONObject; // Asume que tienes una librería de JSON, ej: org.json
//import org.json.JSONException;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

// Mocking JSONObject and JSONException since they might not be present in the user's setup out of the box
class JSONObject {
    public JSONObject(String source) throws JSONException {
        if (!source.trim().startsWith("{")) {
            throw new JSONException("Invalid JSON");
        }
    }
    @Override
    public String toString() { return "JSONObject{...}"; }
}

class JSONException extends Exception {
    public JSONException(String msg) { super(msg); }
}

sealed interface ResultMonad<T, E> permits ResultMonad.Success, ResultMonad.Failure {
    record Success<T, E>(T value) implements ResultMonad<T, E> {}
    record Failure<T, E>(E error) implements ResultMonad<T, E> {}

    // --- TAREA 1: Implementa el método flatMap en la interfaz Result ---
    default <U> ResultMonad<U, E> flatMap(Function<T, ResultMonad<U, E>> func) {
        if (this instanceof Success<T, E> success) {
            return func.apply(success.value());
        } else if (this instanceof Failure<T, E> failure) {
            return new Failure<>(failure.error());
        }
        return new Failure<>((E)"Unexpected state");
    }
}

public class PatronMonada {
    // --- Funciones de procesamiento (NO MODIFICAR) ---
    public static ResultMonad<byte[], String> decodificarBase64(String s) {
        try {
            return new ResultMonad.Success<>(Base64.getDecoder().decode(s));
        } catch (IllegalArgumentException e) {
            return new ResultMonad.Failure<>("Entrada no es un base64 válido");
        }
    }
    
    public static ResultMonad<String, String> decodificarUtf8(byte[] b) {
        try {
            return new ResultMonad.Success<>(new String(b, StandardCharsets.UTF_8));
        } catch (Exception e) {
            return new ResultMonad.Failure<>("Bytes no son un string utf-8 válido");
        }
    }

    public static ResultMonad<JSONObject, String> parsearJson(String s) {
        try {
            return new ResultMonad.Success<>(new JSONObject(s));
        } catch (JSONException e) {
            return new ResultMonad.Failure<>("String no es un JSON válido");
        }
    }

    // --- TAREA 2: Implementa la tubería de procesamiento ---
    public static ResultMonad<JSONObject, String> procesarEntrada(String entrada) {
        return decodificarBase64(entrada)
                .flatMap(PatronMonada::decodificarUtf8)
                .flatMap(PatronMonada::parsearJson);
    }
    
    // --- Pruebas ---
    public static void main(String[] args) {
        String entradaValida = "eyJ1c2VybmFtZSI6ICJhbGljZSIsICJpZCI6IDF9";
        String entradaInvalidaB64 = "esto no es base64";
        String entradaNoJson = "SG9sYSBXb3JsZCE=";

        System.out.println("Entrada válida: " + procesarEntrada(entradaValida));
        System.out.println("Entrada inválida b64: " + procesarEntrada(entradaInvalidaB64));
        System.out.println("Entrada no JSON: " + procesarEntrada(entradaNoJson));
    }
}