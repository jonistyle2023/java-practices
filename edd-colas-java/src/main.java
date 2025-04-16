import java.util.Scanner;
public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Declaración de Variable opción
        int opcion;
        MetodosClaseCola cola = new MetodosClaseCola();

        //Switch casé y la invocación de los métodos
        do {
            System.out.println(" Que metodo desea implementar:  ");
            System.out.println(" -------- Opcion [1] Ingresar elementos (Push)---------");
            System.out.println(" -------- Opcion [2] Eliminar elementos (Pop)----------");
            System.out.println(" -------- Opcion [3] Mostrar la cola completa ---------");
            System.out.println(" -------- Opcion [4] Salir. ---------------------------");
            System.out.println("Ingrese una opcion: ");
            opcion=sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el elemento que sumara a la cola: ");
                        cola.Push();
                        break;
                    case 2:
                        if (!cola.ColaVacia()) {
                            System.out.println("Se ha eliminado el siguiente elemento de la cola: " + cola.Pop());
                        } else {
                            System.out.println("La cola esta vacía");
                        }
                        break;
                    case 3:
                        System.out.println("Datos de la cola: ");
                        cola.MostrarCola();
                        break;
                    case 4:
                        System.out.println("Gracias...");
                        break;
                    default:
                        System.out.println("\\nIngrese una opcion valida.");
                        break;
                }
            } while (opcion != 4);
        }
    }




