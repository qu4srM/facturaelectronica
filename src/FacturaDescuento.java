public class FacturaDescuento implements IFacturable {

    private Factura facturaBase;
    private double descuento;

    public FacturaDescuento(Factura facturaBase, double descuento) {
        this.facturaBase = facturaBase;
        setDescuento(descuento);
    }

    public void setDescuento(double descuento) {

        if (descuento < 0 || descuento > 100) {
            throw new IllegalArgumentException("Descuento inválido");
        }

        this.descuento = descuento;
    }

    @Override
    public double calcularTotal() {

        double total = facturaBase.calcularTotal();

        return total - (total * descuento / 100);
    }

    @Override
    public void mostrarFactura() {

        facturaBase.mostrarFactura();

        System.out.println("Descuento: " + descuento + "%");
        System.out.println("TOTAL CON DESCUENTO: $" + calcularTotal());
    }
}