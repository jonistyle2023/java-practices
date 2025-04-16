import java.util.Scanner;
public class MetodosClaseCola {

    Scanner teclado = new Scanner(System.in);

    //Implementación de los Nodos
    private Nodo firstCola, endCola;

    //Declaración de variables
    String Cola = "";
    public MetodosClaseCola(){
        firstCola = null;
        endCola = null;
    }

    //Método para saber si la cola está vacía
    public boolean ColaVacia() {
        if (firstCola == null) {
            return true;
        } else {
            return false;
        }
    }

    //Método Push
    public void Push(){
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.elementos = teclado.nextInt();
        nuevo_nodo.siguiente = null;

        if (ColaVacia()) {
            firstCola = nuevo_nodo;
        } else {
            endCola.siguiente = nuevo_nodo;
        }
        endCola = nuevo_nodo;
    }

    //Método Pop
    public int Pop(){
        if (!ColaVacia()) {
            int elementos = firstCola.elementos;

            if (firstCola == endCola) {
                firstCola = null;
                endCola = null;
            } else {
                firstCola = firstCola.siguiente;
            }
            return elementos;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    //Método para mostrar el contenido de la cola
    public void MostrarCola(){
        Nodo recorrido = firstCola;
        String ColaInvertida = "";

        while(recorrido != null){
            Cola += recorrido.elementos + " ";
            recorrido = recorrido.siguiente;
        }

        //Implementación del arreglo.
        String[] cadena = Cola.split(" ");


        for (int i = cadena.length - 1; i >= 0; i--) {
            ColaInvertida += " " +cadena[i];
        }

        System.out.println(ColaInvertida);
        Cola = "";
    }
    //Método para saber si la cola está llena
}
