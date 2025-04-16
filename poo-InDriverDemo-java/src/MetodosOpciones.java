import java.util.Scanner;

public class MetodosOpciones {
    Scanner sc = new Scanner(System.in);

    String call;
    String ave;
    String opComentario;
    String com;
    int cal;
    int numCalle;

    String ref;
    public void ObtenerCalle() {
        System.out.println("calle: ");
        call = sc.nextLine();
    }
    public void ObtenerAvenida() {
        System.out.println("Avenida: ");
        ave = sc.nextLine();
    }

    public void ObtenerReferencia() {
        System.out.println("Dicte una referencia: ");
        ref = sc.nextLine();
    }

    public void ObtenerDireccion() {
        System.out.println("\n"
                +"La direccion que ingreso es.....\n"
        + "calle: " + call + "\n"
        + "con numero: " + numCalle + "\n"
        + "Avenida: " + ave + "\n"
        + "y con referencia: " + ref + "\n"
        + "");
    }
    public void ObtenerCalificacion() {
        System.out.println("Califica el servicio " + "\n"
                +" 1 al 5: " + "\n"
                + "[1] Pesimo servicio. " + "\n"
                + "[2] Inconforme " + "\n"
                + "[3] Puede mejorar " + "\n"
                + "[4] Satisfecho " + "\n"
                + "[5] Muy satisfecho " + "\n"
                + "");
        cal = sc.nextInt();
    }

    public void ObtenerComentario() {
        System.out.println("Deseas dejar un comentario Si o NO ");
        opComentario = sc.next();
        if (opComentario.equals("si")) {
            System.out.println("Comenta que te parecio el servicio: ");
            com = sc.next();
            System.out.println("gracias.....");
        } else {
            System.out.println("correcto, gracias de todas formas..");
        }
    }
}
