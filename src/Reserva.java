class Reserva {
    private int mesa;
    private String fecha;
    private int numeroPersonas;
    private Cliente cliente;
    private boolean disponibilidad;

    public Reserva(int mesa, String fecha, int numeroPersonas, Cliente cliente, boolean disponibilidad) {
        this.mesa = mesa;
        this.fecha = fecha;
        this.numeroPersonas = numeroPersonas;
        this.cliente = cliente;
        this.disponibilidad = disponibilidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getMesa() {
        return mesa;
    }
}
