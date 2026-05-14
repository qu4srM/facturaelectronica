class Persona {
    private String nombre;
    private String fechaNacimiento;
    private int id;

    public Persona(String nombre, String fechaNacimiento, int id) {
        setNombre(nombre);
        setFechaNacimiento(fechaNacimiento);
        setId(id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        this.nombre = nombre;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        if (fechaNacimiento == null || fechaNacimiento.isEmpty()) {
            throw new IllegalArgumentException("Fecha inválida");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        this.id = id;
    }
}