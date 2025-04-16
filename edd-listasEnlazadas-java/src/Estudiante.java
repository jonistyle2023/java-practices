public class Estudiante {
    int id;
    String Nombre;
    Estudiante Sig;

    public Estudiante(int _id, String _nombre) {
        this.id = _id;
        this.Nombre = _nombre;
        this.Sig = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String _nombre) {
        this.Nombre = _nombre;
    }

    public Estudiante getSig() {
        return Sig;
    }

    public void setSig(Estudiante sig) {
        this.Sig = sig;
    }
}
