public class main {

    public static void main(String[] args) {
        notasUPSE objEstudiante = new notasUPSE();

        //Método cálculos
        objEstudiante.calcularNotaACD();
        objEstudiante.calcularNotaAA();
        objEstudiante.calcularNotaAPE();
        objEstudiante.calcularPromedio();
        objEstudiante.calcularNotaExamenRecuperacion();
        objEstudiante.calcularPromedioFinal();
        objEstudiante.calcularCalificacionFinal();

        //llamar a los métodos obtener e imprimir
        System.out.println("\n" +
                " /$$   /$$  /$$$$$$  /$$$$$$$$ /$$$$$$   /$$$$$$        /$$   /$$ /$$$$$$$   /$$$$$$  /$$$$$$$$\n" +
                "| $$$ | $$ /$$__  $$|__  $$__//$$__  $$ /$$__  $$      | $$  | $$| $$__  $$ /$$__  $$| $$_____/\n" +
                "| $$$$| $$| $$  \\ $$   | $$  | $$  \\ $$| $$  \\__/      | $$  | $$| $$  \\ $$| $$  \\__/| $$      \n" +
                "| $$ $$ $$| $$  | $$   | $$  | $$$$$$$$|  $$$$$$       | $$  | $$| $$$$$$$/|  $$$$$$ | $$$$$   \n" +
                "| $$  $$$$| $$  | $$   | $$  | $$__  $$ \\____  $$      | $$  | $$| $$____/  \\____  $$| $$__/   \n" +
                "| $$\\  $$$| $$  | $$   | $$  | $$  | $$ /$$  \\ $$      | $$  | $$| $$       /$$  \\ $$| $$      \n" +
                "| $$ \\  $$|  $$$$$$/   | $$  | $$  | $$|  $$$$$$/      |  $$$$$$/| $$      |  $$$$$$/| $$$$$$$$\n" +
                "|__/  \\__/ \\______/    |__/  |__/  |__/ \\______/        \\______/ |__/       \\______/ |________/\n" +
                "                                                                                               \n" +
                "                                                                                               \n" +
                "                                                                                               \n");


        System.out.println("Su nota ACD es: " + objEstudiante.obtenerNotaACD());
        System.out.println("Su nota APE es: " + objEstudiante.obtenerAPE());
        System.out.println("Su nota AA es:  " + objEstudiante.obtenerAA());
        System.out.println("Su promedio es:  " + objEstudiante.obtenerPromedio());
        System.out.println("Usted esta: " + objEstudiante.notasUPSE);
        System.out.println("Su calificacion final es: " + objEstudiante.obtenerCalificacionFinal());

    }
}
