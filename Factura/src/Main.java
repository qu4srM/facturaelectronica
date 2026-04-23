import java.util.ArrayList;

interface IFacturable {
    void mostrarFactura();
}

class Persona {
    protected String nombre;
    protected String fechaNacimiento;
    protected int id;

    public Persona(String nombre, String fechaNacimiento, int id) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.id = id;
    }

    public void agregarPersona() {
        System.out.println("Persona agregada: " + nombre);
    }

    public void editarPersona() {
        System.out.println("Datos de persona editados.");
    }
}

class Cliente extends Persona {
    private int puntosFidelidad;

    public Cliente(String nombre, String fechaNacimiento, int id, int puntosFidelidad) {
        super(nombre, fechaNacimiento, id);
        this.puntosFidelidad = puntosFidelidad;
    }

    public void consultarPuntos() {
        System.out.println("Puntos actuales: " + puntosFidelidad);
    }
    @Override
    public void agregarPersona () {
        System.out.println("Cliente agregada: " + nombre);
    }

    public void agregarPuntos(int puntos) {
        puntosFidelidad += puntos;
        System.out.println("Puntos agregados.");
    }

    public void eliminarPuntos(int puntos) {
        puntosFidelidad -= puntos;
        System.out.println("Puntos eliminados.");
    }
}

class Empleado extends Persona {
    private String tipoContrato;
    private String fechaIngreso;
    private double salario;

    public Empleado(String nombre, String fechaNacimiento, int id,
                    String tipoContrato, String fechaIngreso, double salario) {
        super(nombre, fechaNacimiento, id);
        this.tipoContrato = tipoContrato;
        this.fechaIngreso = fechaIngreso;
        this.salario = salario;
    }
}

class Comida {
    public String nombre;
    public double precio;

    public Comida(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}

class Reserva {
    protected int mesa;
    protected String fecha;
    protected int numeroPersonas;
    protected Cliente cliente;
    protected boolean disponibilidad;

    public Reserva(int mesa, String fecha, int numeroPersonas, Cliente cliente, boolean disponibilidad) {
        this.mesa = mesa;
        this.fecha = fecha;
        this.numeroPersonas = numeroPersonas;
        this.cliente = cliente;
        this.disponibilidad = disponibilidad;
    }

    public void crearReserva() {
        if (disponibilidad) {
            System.out.println("Reserva creada para " + cliente.nombre + " en mesa " + mesa);
        } else {
            System.out.println("Mesa no disponible.");
        }
    }
}

class Factura implements IFacturable {
    private Reserva reserva;
    private ArrayList<Comida> productos = new ArrayList<>();

    public Factura(Reserva reserva) {
        this.reserva = reserva;
    }

    public void agregarProducto(Comida comida) {
        productos.add(comida);
    }

    public double calcularTotal() {
        double total = 0;
        for (Comida c : productos) {
            total += c.precio;
        }
        return total;
    }

    @Override
    public void mostrarFactura() {
        System.out.println("\n----- FACTURA -----");
        System.out.println("Cliente: " + reserva.cliente.nombre);
        System.out.println("Mesa: " + reserva.mesa);

        for (Comida c : productos) {
            System.out.println(c.nombre + " - $" + c.precio);
        }

        System.out.println("TOTAL: $" + calcularTotal());
    }
}

public class Main {
    public static void main(String[] args) {


        Cliente cliente1 = new Cliente("Cristian", "10/05/2000", 1, 20);
        cliente1.agregarPersona();
        cliente1.consultarPuntos();

        Reserva reserva1 = new Reserva(5, "21/04/2026", 3, cliente1, true);
        reserva1.crearReserva();

        // Productos
        Comida comida1 = new Comida("Hamburguesa", 18.500);
        Comida comida2 = new Comida("Gaseosa", 5.000);

        // Factura
        Factura factura1 = new Factura(reserva1);
        factura1.agregarProducto(comida1);
        factura1.agregarProducto(comida2);

        factura1.mostrarFactura();
    }
}
