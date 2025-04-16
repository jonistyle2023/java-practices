public class Main {
    public static void main(String[] args) {

        //Declaracion de variables
        Trabajador trabajador;
        Empleado emmpleado;
        consultor consultor;

        trabajador = new Trabajador("Jonathan");
        emmpleado = new Empleado("David", 1000);
        consultor =new consultor("Alex", 20, 60.00);

        System.out.println(trabajador);
        System.out.println(emmpleado);
        System.out.println(consultor);
    }
}
