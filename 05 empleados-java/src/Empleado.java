public class Empleado extends Trabajador {
    private double sueldo;
    private double iess;

    public Empleado(String nombre, double sueldo) {
        super(nombre);
        this.sueldo = sueldo;
        this.iess = 0.09 * sueldo;
    }

    public double calcularPaga(){
        return  (sueldo - iess);
    }

    public String toString() {
        return "Empleado: " + super.toString();
    }
}
