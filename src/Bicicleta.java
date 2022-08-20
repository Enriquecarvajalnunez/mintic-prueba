
public class Bicicleta {
    private int id_bicicleta;
    private String nombre_fabricante;
    private float precio_unitario;
    private String anio;

    public Bicicleta() {
    }
    
    public Bicicleta(String nombre_fabricante,float precio_unitario,String anio) {
        this.nombre_fabricante=nombre_fabricante;
        this.precio_unitario=precio_unitario;
        this.anio=anio;
    }

    public Bicicleta(int id_bicicleta,String nombre_fabricante, float precio_unitario, String anio) {
        this.id_bicicleta = id_bicicleta;
        this.nombre_fabricante = nombre_fabricante;
        this.precio_unitario = precio_unitario;
        this.anio = anio;
    }

    public String getNombre_fabricante() {
        return nombre_fabricante;
    }

    public void setNombre_fabricante(String nombre_fabricante) {
        this.nombre_fabricante = nombre_fabricante;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public int getId_bicicleta() {
        return id_bicicleta;
    }

    public void setId_bicicleta(int id_bicicleta) {
        this.id_bicicleta = id_bicicleta;
    }

    @Override
    public String toString() {
        return "Bicicleta: \n" + "id_bicicleta=" + id_bicicleta+"\n" + " nombre fabricante=" + nombre_fabricante+"\n" + " precio unitario=" + precio_unitario+"\n" + " año=" + anio+"\n";
    }
    
    
    
}
