
public class Fabricante {
    
    private String nombre_fabricante;
    private String direccion;
     private String telefono;

    public Fabricante() {
    }
    
    public Fabricante(String nombre_fabricante) {
        this.nombre_fabricante = nombre_fabricante;
    }

    public Fabricante(String nombre_fabricante, String direccion, String telefono) {
        this.nombre_fabricante = nombre_fabricante;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre_fabricante() {
        return nombre_fabricante;
    }

    public void setNombre_fabricante(String nombre_fabricante) {
        this.nombre_fabricante = nombre_fabricante;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "fabricante: " + nombre_fabricante + ",\n direccion=" + direccion + ",\n telefono=" + telefono+"\n\n";
    }    
     
}
