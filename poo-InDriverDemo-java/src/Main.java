import java.util.Scanner;
public class Main extends MetodosOpciones {
    public static void main(String[] args) {
        int op;
        int opPago;
        Scanner teclado = new Scanner(System.in);

        MetodosConductores choferes = new MetodosConductores();
        MetodosOpciones ops = new MetodosOpciones();
        MetodosUsuario persona = new MetodosUsuario();

        do {
            System.out.println("\n"
                    +"Bienvenido al servicio de transporte.  ");
            System.out.println(" [1] Insertar datos.");
            System.out.println(" [2] Pagar.");
            System.out.println(" [3] Pedir un Taxi. ");
            System.out.println(" [4] Terminar y calificar.");
            op = teclado.nextInt();
            switch (op) {
                case 1:
                    persona.ObtenerNumeroTelefono();
                    persona.ObtenerNombreUsuario();
                    System.out.println("Registro realizado con exito.....");
                    break;
                case 2:
                    System.out.println("como desea pagar...  " + "\n"
                            + "[1] Efectivo" + "\n"
                            + "[2] Tarjeta de Debito" + "\n"
                            + "[3] Tarjeta de Credito" + "\n"
                            + "");
                    System.out.println("Ingrese una opcion: ");
                    opPago = teclado.nextInt();
                    switch (opPago){
                        case 1:
                            persona.ObtenerEfectivo();
                            break;
                        case 2:
                            persona.ObtenerDebito();
                            break;
                        case 3:
                            persona.ObtenerCredito();
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Ingrese su direccion...");
                    ops.ObtenerCalle();
                    ops.ObtenerAvenida();
                    ops.ObtenerReferencia();
                    ops.ObtenerDireccion();

                    System.out.println("Conductores disponibles:"
                    +"");
                    choferes.ObtenerConductores();
                    System.out.println("Una unidad esta en camino...");
                    break;
                case 4:
                    ops.ObtenerCalificacion();
                    ops.ObtenerComentario();
                    System.out.println("Vuelve pronto. ");
                    break;
                default:
                    break;
            }
        }while (op != 4);
    }
}
