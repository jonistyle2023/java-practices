public class consultor extends Trabajador {
    private int horas;
    private double tarifa;


    public consultor(String nombre, int horas, double tarifa) {
        super(nombre);
        this.horas = horas;
        this.tarifa = tarifa;
    }

    public double calcularPaga(){
        return (horas*tarifa);
    }

    public String toString(){
        return "consultor: " + super.toString();
    }
}
