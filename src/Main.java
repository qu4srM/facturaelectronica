import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// MAIN
public class Main {

    // VALIDAR ENTEROS
    public static int removeErrors(Scanner sc, int min, int max) {

        while (true) {

            if (sc.hasNextInt()) {

                int opcion = sc.nextInt();

                if (opcion >= min && opcion <= max) {
                    return opcion;
                } else {
                    System.out.print("Ingrese un número entre " + min + " y " + max + ": ");
                }

            } else {
                System.out.print("Debe ingresar un número entero" + min + " y " + max + ": ");
                sc.next();
            }
        }
    }

    // VALIDAR DOUBLE
    public static double readDouble(Scanner sc, double min, double max) {

        while (true) {

            if (sc.hasNextDouble()) {

                double num = sc.nextDouble();

                if (num >= min && num <= max) {
                    return num;
                } else {
                    System.out.print("Ingrese un valor entre " + min + " y " + max + ": ");
                }

            } else {
                System.out.print("Debe ingresar un número válido entre " + min + " y " + max + ": ");
                sc.next();
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<IFacturable> listaFacturas = new ArrayList<>();

        Cliente cliente = new Cliente(
                "Cristian",
                "10/05/2000",
                1,
                10
        );

        Reserva reserva = new Reserva(
                1,
                "Hoy",
                2,
                cliente,
                true
        );

        while (true) {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Crear factura");
            System.out.println("2. Mostrar facturas");
            System.out.println("3. Salir");
            System.out.print("Opción: ");

            int opcion = removeErrors(sc, 1, 3);

            switch (opcion) {

                case 1:

                    Factura factura = new Factura(reserva);

                    System.out.print("¿Cuántos productos desea agregar?: ");

                    int n = removeErrors(sc, 1, 20);

                    for (int i = 0; i < n; i++) {

                        System.out.println("\n--- COMIDAS ---");
                        System.out.println("1. Hamburguesa ($10000)");
                        System.out.println("2. Pasta ($9000)");
                        System.out.println("3. Carne ($15000)");
                        System.out.println("4. Pizza ($20000)");
                        System.out.print("Seleccione una opción: ");

                        int numComida = removeErrors(sc, 1, 4);

                        String nombre = "";
                        double precio = 0;

                        switch (numComida) {

                            case 1:
                                nombre = "Hamburguesa";
                                precio = 10000;
                                break;

                            case 2:
                                nombre = "Pasta";
                                precio = 9000;
                                break;

                            case 3:
                                nombre = "Carne";
                                precio = 15000;
                                break;

                            case 4:
                                nombre = "Pizza";
                                precio = 20000;
                                break;
                        }

                        factura.agregarProducto(new Comida(nombre, precio));
                    }

                    sc.nextLine();

                    String resp;

                    while (true) {

                        System.out.print("¿Aplicar descuento? (s/n): ");

                        resp = sc.nextLine();

                        if (resp.equalsIgnoreCase("s") || resp.equalsIgnoreCase("n")) {
                            break;
                        }

                        System.out.println("Ingrese solamente 's' o 'n'");
                    }

                    if (resp.equalsIgnoreCase("s")) {

                        System.out.print("Ingrese % de descuento: ");

                        double desc = readDouble(sc, 0, 10);

                        listaFacturas.add(
                                new FacturaDescuento(factura, desc)
                        );

                    } else {

                        listaFacturas.add(factura);
                    }

                    System.out.println("Factura creada.");
                    break;

                case 2:

                    if (listaFacturas.isEmpty()) {

                        System.out.println("No hay facturas.");

                    } else {

                        for (IFacturable f : listaFacturas) {
                            f.mostrarFactura();
                        }
                    }

                    break;

                case 3:

                    System.out.println("Saliendo...");
                    sc.close();
                    return;
            }
        }
    }
}