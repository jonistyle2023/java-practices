import java.util.Map;

// Contexto: Se tiene un metodo que realiza una transferencia bancaria. El metodo puede fallar si la cuenta
// de origen no existe o si no tiene fondos suficientes. Actualmente, lanza IllegalArgumentException.

// --- TAREA 1: Define el tipo Result ---
// Define la sealed interface Result<T, E> con sus records Success y Failure.
// El tipo de error será un String.
sealed interface Result<T, E> permits Success, Failure {}

record Success<T, E>(T value) implements Result<T, E> {}
record Failure<T, E>(E error) implements Result<T, E> {}

class CuentaBancaria {
    private String id;
    private double balance;
    
    public CuentaBancaria(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() { return id; }
    public double getBalance() { return balance; }

    public void depositar(double monto) { this.balance += monto; }
    public void retirar(double monto) { this.balance -= monto; }
}

class Banco {
    private Map<String, CuentaBancaria> cuentas;

    public Banco(Map<String, CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    // --- TAREA 2: Refactoriza el siguiente método ---
    public void transferirInseguro(String idOrigen, String idDestino, double monto) {
        CuentaBancaria origen = cuentas.get(idOrigen);
        if (origen == null) {
            throw new IllegalArgumentException("La cuenta de origen no existe.");
        }
        if (origen.getBalance() < monto) {
            throw new IllegalArgumentException("Fondos insuficientes.");
        }
        // ... Lógica para encontrar destino y realizar transferencia ...
        CuentaBancaria destino = cuentas.get(idDestino);
        if (destino == null) {
            throw new IllegalArgumentException("La cuenta de destino no existe.");
        }
        origen.retirar(monto);
        destino.depositar(monto);
    }

    // Refactoriza para que devuelva un Result<String, String>.
    // Si es exitoso, devuelve Success("Transferencia completada").
    // Si falla, devuelve un Failure con el mensaje de error apropiado.
    public Result<String, String> transferirSeguro(String idOrigen, String idDestino, double monto) {
        CuentaBancaria origen = cuentas.get(idOrigen);
        if (origen == null) {
            return new Failure<>("La cuenta de origen no existe.");
        }
        if (origen.getBalance() < monto) {
            return new Failure<>("Fondos insuficientes.");
        }
        
        CuentaBancaria destino = cuentas.get(idDestino);
        if (destino == null) {
            return new Failure<>("La cuenta de destino no existe.");
        }

        origen.retirar(monto);
        destino.depositar(monto);

        return new Success<>("Transferencia completada");
    }
}

public class PatronResult {
    public static void main(String[] args) {
        Banco banco = new Banco(Map.of(
            "C1", new CuentaBancaria("C1", 1000.0),
            "C2", new CuentaBancaria("C2", 500.0)
        ));

        // Prueba de transferencia segura exitosa
        Result<String, String> resultado1 = banco.transferirSeguro("C1", "C2", 200.0);
        System.out.println("Transferencia C1 -> C2 (200.0): " + resultado1);

        // Prueba de cuenta origen inexistente
        Result<String, String> resultado2 = banco.transferirSeguro("C3", "C2", 200.0);
        System.out.println("Transferencia C3 -> C2 (200.0): " + resultado2);

        // Prueba de fondos insuficientes
        Result<String, String> resultado3 = banco.transferirSeguro("C2", "C1", 1000.0);
        System.out.println("Transferencia C2 -> C1 (1000.0): " + resultado3);
        
        // Prueba de cuenta destino inexistente
        Result<String, String> resultado4 = banco.transferirSeguro("C1", "C3", 200.0);
        System.out.println("Transferencia C1 -> C3 (200.0): " + resultado4);
    }
}
