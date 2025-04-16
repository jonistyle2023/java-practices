import java.util.Scanner;

public class MetodosUsuario {
    Scanner sc = new Scanner(System.in);

    //Declaración de variables
    int numTelefono;
    String nombreUsuario;
    int cvcDeb, cvcCred;
    long debito, credito;


    public void ObtenerNumeroTelefono() {
        System.out.println("Inserte su numero ");
        numTelefono = Integer.parseInt(sc.next());
    }

    public void ObtenerNombreUsuario() {
        System.out.println("Inserte su nombre: ");
        nombreUsuario = sc.next();
    }

    public void ObtenerDebito() {
        System.out.println("Ingrese los datos de su tarjeta ");
        debito = sc.nextLong();
        System.out.println("Ingrese el CVC... ");
        cvcDeb = sc.nextInt();
        System.out.println("\n"
                +"Registrado correctamente");
    }

    public void ObtenerCredito() {
        System.out.println("Ingrese los datos de su tarjeta ");
        credito = sc.nextLong();
        System.out.println("Ingrese el CVC... ");
        cvcCred = sc.nextInt();
        System.out.println("\n"
                +"Registrado ");
    }

    public void ObtenerEfectivo() {
        System.out.println("Exelente...");
    }
}
