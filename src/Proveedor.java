
public class Proveedor {
     private int id_proveedor;
     private String nombre;
     private String direccion;
     private String telefono;

    public Proveedor() {
    }

    public Proveedor(int id_proveedor, String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.id_proveedor = id_proveedor;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    @Override
    public String toString() {
        return "Proveedor: " + "id_proveedor=" + id_proveedor+"\n" + " nombre=" + nombre+"\n" + " direccion=" + direccion+"\n" + " telefono=" + telefono+"\n\n";
    }
    
}
