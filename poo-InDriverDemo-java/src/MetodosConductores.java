public class MetodosConductores {
    public void ObtenerConductores() {
        String[] choferes = new String[5];
        choferes[0] = "Marco (TAXI)";
        choferes[1] = "Michael (TAXI) - En camino a su ubicacion. ";
        choferes[2] = "Ener (van)";
        choferes[3] = "Estuar (Ocupado)";
        choferes[4] = "Jhon (Camioneta)";

        System.out.println("\n"
                +"Choferes cercanos. " + choferes.length);
        System.out.println("Choferes..");
        for (int i = 0; i<choferes.length;i++) {
            System.out.println(choferes[i]);
        }
    }
}
