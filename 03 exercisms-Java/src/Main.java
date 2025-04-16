import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Pseudocódigo para determinar el área de un rectángulo");
        System.out.println("Digita la base del rectángulo: ");
        int base = sc.nextInt();
        System.out.println("Digita la altura del rectángulo: ");
        int altura = sc.nextInt();
        System.out.println("Digita la area del rectángulo: ");
        System.out.println("El área del rectángulo es: " + base * altura);
    }
}