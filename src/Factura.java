import java.util.ArrayList;

public class Factura implements IFacturable {

    private Reserva reserva;
    private ArrayList<Comida> productos = new ArrayList<>();

    public Factura(Reserva reserva) {
        this.reserva = reserva;
    }

    public void agregarProducto(Comida comida) {
        productos.add(comida);
    }

    @Override
    public double calcularTotal() {

        double total = 0;

        for (Comida c : productos) {
            total += c.getPrecio();
        }

        return total;
    }

    @Override
    public void mostrarFactura() {

        System.out.println("\n----- FACTURA -----");
        System.out.println("Cliente: " + reserva.getCliente().getNombre());
        System.out.println("Mesa: " + reserva.getMesa());

        for (Comida c : productos) {
            System.out.println(c.getNombre() + " - $" + c.getPrecio());
        }

        System.out.println("TOTAL: $" + calcularTotal());
    }
}