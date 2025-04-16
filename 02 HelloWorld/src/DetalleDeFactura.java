import java.util.Scanner;

public class DetalleDeFactura {
    public static void main(String[] args) {
        Scanner Prod = new Scanner(System.in);

        String Nombre;
        double Precio;
        int Cantidad;
        double SubTotal;
        double total;
        double total2;
        double Impuesto;
        double IVA=0.19;
        double Descuento = 0.1;

        System.out.println("Que producto desea comprar?");
        Nombre = Prod.next();
        System.out.println("Cual es el precio por unidad del producto: "+Nombre+ "?");
        Precio = Prod.nextDouble();
        System.out.println("Cuantas unidades del producto: " +Nombre+ " Desea llevar?");
        Cantidad = Prod.nextInt();
        SubTotal = Precio*Cantidad;
        Impuesto = SubTotal*IVA;
        total = SubTotal+Impuesto;

        if(total < 10.00){
            total2=total+Descuento+(total);
            System.out.println("--------\n" +
                    "------------    ------    ------------ ------------ ----    ---- -----------     ------    \n" +
                    "************   ********   ************ ************ ****    **** ***********    ********   \n" +
                    "----          ----------  ---          ------------ ----    ---- ----    ---   ----------  \n" +
                    "************ ****    **** ***              ****     ****    **** *********    ****    **** \n" +
                    "------------ ------------ ---              ----     ----    ---- ---------    ------------ \n" +
                    "****         ************ ***              ****     ************ ****  ****   ************ \n" +
                    "----         ----    ---- ------------     ----     ------------ ----   ----  ----    ---- \n" +
                    "****         ****    **** ************     ****     ************ ****    **** ****    **** \n" +
                    "                                                                                           \n--------"
                    +"\nProducto: "+Nombre
                    +"\nPrecio: "+Precio
                    +"\nCantidad comprada: "+Cantidad
                    +"\nSubtotal: "+SubTotal
                    +"\nImpuesto: "+Impuesto
                    +"\ntotal: "+total
                    +"\nDescuento: "+(total*Descuento)
                    +"\nTotal a Pagar: "+total2);
        }else{
            System.out.println("--------\n" +
                    "______               _                       \n" +
                    "|  ___|             | |                      \n" +
                    "| |_     __ _   ___ | |_  _   _  _ __   __ _ \n" +
                    "|  _|   / _` | / __|| __|| | | || '__| / _` |\n" +
                    "| |    | (_| || (__ | |_ | |_| || |   | (_| |\n" +
                    "\\_|     \\__,_| \\___| \\__| \\__,_||_|    \\__,_|\n" +
                    "                                             \n" +
                    "                                             \n--------"
                    +"\nProducto: "+Nombre
                    +"\nPrecio: "+Precio
                    +"\nCantidad comprada: "+Cantidad
                    +"\nSubtotal: "+SubTotal
                    +"\nImpuesto: "+Impuesto
                    +"\ntotal: "+total);
        }
    }
}
