public class InventarioProducto {

    // 1. Define un 'record' para Producto con los campos:
    //    idProducto (String), nombre (String), precio (double), y cantidadStock (int).
    public record Producto(String idProducto, String nombre, double precio, int cantidadStock) {}
    
    // --- TAREAS ---

    // 2. Implementa el método estático `venderUnidades`.
    //    Debe tomar un objeto `Producto` y un número de `unidadesAVender`.
    //    Debe devolver un NUEVO objeto `Producto` con la `cantidadStock` reducida.
    //    Añade una validación: si se intentan vender más unidades de las que hay
    //    en stock, debe lanzar una excepción `IllegalArgumentException`.
    public static Producto venderUnidades(Producto producto, int unidadesAVender) {
        if (unidadesAVender > producto.cantidadStock()) {
            throw new IllegalArgumentException("Stock insuficiente para la venta de " + unidadesAVender + " unidades.");
        }
        return new Producto(
            producto.idProducto(),
            producto.nombre(),
            producto.precio(),
            producto.cantidadStock() - unidadesAVender
        );
    }

    // 3. Implementa el método estático `ajustarPrecio`.
    //    Debe tomar un objeto `Producto` y un `nuevoPrecio`.
    //    Debe devolver un NUEVO objeto `Producto` con el `precio` actualizado.
    //    Añade una validación: el nuevo precio no puede ser negativo. Si lo es,
    //    lanza una excepción `IllegalArgumentException`.
    public static Producto ajustarPrecio(Producto producto, double nuevoPrecio) {
        if (nuevoPrecio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        return new Producto(
            producto.idProducto(),
            producto.nombre(),
            nuevoPrecio,
            producto.cantidadStock()
        );
    }

    // --- Pruebas ---
    public static void main(String[] args) {
        try {
            Producto productoInicial = new Producto(
                "LAP-001",
                "Laptop Pro 15",
                1500.00,
                50
            );
            System.out.println("Estado Inicial: " + productoInicial);

            Producto productoDespuesDeVenta = venderUnidades(productoInicial, 5);
            System.out.println("Después de vender 5: " + productoDespuesDeVenta);
            System.out.println("El producto original no cambió: " + productoInicial);
            assert productoInicial.cantidadStock() == 50;
            assert productoDespuesDeVenta.cantidadStock() == 45;

            Producto productoConNuevoPrecio = ajustarPrecio(productoDespuesDeVenta, 1450.50);
            System.out.println("Después de ajustar precio: " + productoConNuevoPrecio);
            System.out.println("El producto después de la venta no cambió: " + productoDespuesDeVenta);
            assert productoDespuesDeVenta.precio() == 1500.00;
            assert productoConNuevoPrecio.precio() == 1450.50;
            
            // Probar validación
            // venderUnidades(productoInicial, 100); // Debería lanzar IllegalArgumentException

        } catch (Exception e) {
            System.out.println("\nError durante la prueba: " + e.getMessage());
        }
    }
}