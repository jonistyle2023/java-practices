import java.util.Scanner;

public class MetodosAula {

    Scanner sc;
    Estudiante head;

    public MetodosAula() {
        this.sc = new Scanner(System.in);
        this.head = null;
    }

    public boolean listaVacia() {
        if (head == null)
            return true;
        else
            return false;
    }

    public int menu() {
        int op;
        System.out.println(" ---------- Menu de opciones: -------");
        System.out.println("------ [1] Insertar Estudiante ------");
        System.out.println("------ [2] Recorrer Lista -----------");
        System.out.println("------ [3] Eliminar Estudiante ------");
        System.out.println("------ [4] Buscar Estudiante --------");
        System.out.println("------ [5] Salir --------------------");
        op = sc.nextInt();
        return op;
    }

    public void insertar (int _id, String _nombre){
        Estudiante nuevo = new Estudiante(_id, _nombre);
        if (listaVacia())
            head = nuevo;
         else {
            if (_id < head.getId()){
                nuevo.setSig(head);
                head = nuevo;
            } else {
                Estudiante actual = head;
                while ((actual.getSig() !=null) && (_id > actual.getSig().getId()));
                actual = actual.getSig();
                nuevo.setSig(actual.getSig());
                actual.setSig(nuevo);
            }
        }
    }

    public void recorrer() {
        if (listaVacia()) {
            System.out.println("No se encuentra el estudiante... ");
        } else {
            Estudiante actual = this.head;
            while(actual != null) {
                System.out.println("Id: " +actual.getId() + "Nombre del estudiante:  " + actual.getNombre() + " ==>> ");
                actual = actual.getSig();
            }
        }
        System.out.println("\n");
    }

    public void eliminar (int _id) {
      Estudiante actual = this.head;
      Estudiante anterior = null;

      while ((actual != null) && (actual.getId() != _id)); {
          anterior = actual;
          actual = actual.getSig();
        } if (actual == null) {
            if (head == null) {
                System.out.println("La lista esta vacia...");
            } else {
                System.out.println("El estudiante no esta en la lista...");
            }
        }else {
              if (head == actual) {
                  head = actual.getSig();
              } else {
                  anterior.Sig = actual.getSig();
              }
            }
            System.out.println("Estudiante eliminado");
        }

    public void buscar (int _id) {
        if (listaVacia())
            System.out.println("Lista de estudiantes vacia. requiere el ingreso de datos previamente..");
        else {
            Estudiante actual = this.head;
            while (actual != null);
            if (_id == actual.getId()) {
                System.out.println("Id del estudiante: " +actual.getId() + "Nombre del estudiante: " +actual.getNombre());

            }
        }
    }
}
