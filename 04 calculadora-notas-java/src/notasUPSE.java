public class notasUPSE {

    //Declaración de variables.
    String notasUPSE;
    double promedio;

    // ACD (35%).
    //Actividad 1 20%.
    //Actividad 2 15%.
    double notaACD;
    double actividadAcd1 = 6.50;
    double actividadAcd2 = 5.00;

    //APE (35%).
    //Actividad 1 10%.
    //Actividad 2 25%.
    double notaAPE;
    double actividadApe1 = 7.20;
    double actividadApe2 = 7.50;

    //AA (30%).
    //Actividad 1 15%.
    //Actividad 2 15%.
    double notaAA;
    double actividadAa1 = 6.50;
    double actividadAa2 = 6.50;

    //Variables para obtener la nota del examen de recuperación.
    double notaFinalExamenRecuperacion;
    double notaExamenRecuperacion = 9.50;

    //Nota final con Examen de Recuperación.
    double calificacionFinal;

    //Métodos Calcular
    public void calcularNotaACD() {
        notaACD = (actividadAcd1*20)/100 + (actividadAcd2*15)/100;
    }

    public void calcularNotaAPE() {
        notaAPE = (actividadApe1*10)/100 + (actividadApe2*25)/100;
    }

    public void calcularNotaAA() {
        notaAA = (actividadAa1*15)/100 + (actividadAa2*15)/100;
    }

    public void calcularPromedio() {
        promedio = (notaACD) + (notaAA) + (notaAPE);
    }
    public void calcularPromedioFinal() {
        if (promedio >= 7) {
            notasUPSE = "\n" +
                    "   db    88\"\"Yb 88\"\"Yb  dP\"Yb  88\"\"Yb    db    8888b.   dP\"Yb      \n" +
                    "  dPYb   88__dP 88__dP dP   Yb 88__dP   dPYb    8I  Yb dP   Yb     \n" +
                    " dP__Yb  88\"\"\"  88\"Yb  Yb   dP 88\"\"Yb  dP__Yb   8I  dY Yb   dP .o. \n" +
                    "dP\"\"\"\"Yb 88     88  Yb  YbodP  88oodP dP\"\"\"\"Yb 8888Y\"   YbodP  `\"' \n";
        } else {
            if (calificacionFinal < 7){
                notasUPSE ="\n" +
                        "  ____                                  _                   _             \n" +
                        " |  _ \\    ___   _ __    _ __    ___   | |__     __ _    __| |   ___      \n" +
                        " | |_) |  / _ \\ | '_ \\  | '__|  / _ \\  | '_ \\   / _` |  / _` |  / _ \\     \n" +
                        " |  _ <  |  __/ | |_) | | |    | (_) | | |_) | | (_| | | (_| | | (_) |  _ \n" +
                        " |_| \\_\\  \\___| | .__/  |_|     \\___/  |_.__/   \\__,_|  \\__,_|  \\___/  (_)\n" +
                        "                |_|                                                       \nRecuerde que debe rendir el examen de recuperacion sobre el 35%, es decir 3.5 pts. La calificacion de su examen de recuperacion es: " + notaFinalExamenRecuperacion;
            }
        }
    }
    public void calcularNotaExamenRecuperacion() {
            notaFinalExamenRecuperacion = (notaExamenRecuperacion*35)/100;
    }
    public void calcularCalificacionFinal() {
        if (promedio < 7) {
            calificacionFinal = (promedio*60)/100 + notaFinalExamenRecuperacion;
        }else{
            calificacionFinal = promedio;
        }
    }

    //Métodos obtener
    public double obtenerNotaACD() {
        return notaACD;
    }

    public double obtenerAPE() {
        return notaAPE;
    }

    public double obtenerAA() {
        return notaAA;
    }

    public double obtenerPromedio() {
        return promedio;
    }
    public double obtenerCalificacionFinal() {
         if (calificacionFinal < 7.00) {
         System.out.println("no alcanza el puntaje requerido, recuerde que nesecita una calificacion de 7 en adelanta para aprobar ");
         } else {
           System.out.println("Felicitaciones, Usted ha aprobado la Asignatura, por lo que no requiere presentarse al examen de recuperacion.");
        }
        return calificacionFinal;
    }
}



