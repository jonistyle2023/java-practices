import java.util.Scanner;

public class OperadoresLogicosLogin {
    public static void main(String[] args) {

        /*String[] usernames = new String[3];
        String[] passwords = new String[3];
        usernames[0] = "jonathan";
        passwords[0] = "12345";

        usernames[1] = "admin";
        passwords[1] = "12345";

        usernames[2] = "pepe";
        passwords[2] = "12345";*/
        String[] usernames = {"jonathan", "admin", "pepe"};
        String[] passwords = {"123", "1235", "12345"};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el username");
        String u = scanner.next();

        System.out.println("Ingrese el password");
        String p = scanner.next();

        boolean esAutentico = false;

        for (int i = 0; i < usernames.length; i++){
            if( (usernames[i].equals(u) && passwords[i].equals(p)) ){
                esAutentico = true;
                break;
            }
        }

        if(esAutentico){
            System.out.println("Bienvenido usuario ".concat(u).concat("!"));
        }else {
            System.out.println("Username o contraseña incorrectos!");
            System.out.println("Lo siento, requiere autenticación");
        }
    }
}
