public class Main {
    public static void main(String[] args) {
        MetodosAula listaEstudiantes = new MetodosAula();

        int op, _id;
        String _nombre;
        do {
            op = listaEstudiantes.menu();
            switch (op) {
                case 1: {
                    System.out.println("Inserte el Id del estudiante: ");
                    _id = listaEstudiantes.sc.nextInt();
                    listaEstudiantes.sc.nextLine();
                    System.out.println("Nombre del estudiante: ");
                    _nombre = listaEstudiantes.sc.nextLine();
                    listaEstudiantes.insertar(_id,
                            _nombre);
                    break;
                }
                case 2: listaEstudiantes.recorrer();
                    break;
                case 3: {
                    System.out.println("Ingrese el id del estudiante a eliminar: ");
                    _id = listaEstudiantes.sc.nextInt();
                    listaEstudiantes.eliminar(_id);
                }
                    break;
                case 4: {
                    System.out.println("Ingrese el id del estudiante que desea buscar: ");
                    _id = listaEstudiantes.sc.nextInt();
                    listaEstudiantes.buscar(_id);
                }
                    break;
                case 5:
                    break;
                default: break;
            }
        } while (op != 5);
    }
}
