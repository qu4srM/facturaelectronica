class Cliente extends Persona {
    private int puntosFidelidad;

    public Cliente(String nombre, String fechaNacimiento, int id, int puntosFidelidad) {
        super(nombre, fechaNacimiento, id);
        setPuntosFidelidad(puntosFidelidad);
    }

    public void setPuntosFidelidad(int puntos) {
        if (puntos < 0) {
            throw new IllegalArgumentException("Puntos inválidos");
        }
        this.puntosFidelidad = puntos;
    }
}