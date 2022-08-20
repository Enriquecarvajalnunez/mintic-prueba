
public class MotoCicleta {
    private int moto_id;
    private String nombre_fabricante;
    private float precio_unitario;
    private int autonomia;
    private int proveedor;

    public MotoCicleta(String nombre_fabricante) {
        this.nombre_fabricante = nombre_fabricante;
    }

    public MotoCicleta(int moto_id,String nombre_fabricante, float precio_unitario, int autonomia, int proveedor) {
        this.moto_id=moto_id;
        this.nombre_fabricante = nombre_fabricante;
        this.precio_unitario = precio_unitario;
        this.autonomia = autonomia;
        this.proveedor = proveedor;
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

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public int getMoto_id() {
        return moto_id;
    }

    public void setMoto_id(int moto_id) {
        this.moto_id = moto_id;
    }

    @Override
    public String toString() {
        return "MotoCicleta: "+"\n" + "moto_id= " + moto_id+"\n" + " nombre fabricante=" + nombre_fabricante+"\n"  + " precio unitario=" + precio_unitario+"\n"  + " autonomia=" + autonomia+"\n"  + " proveedor=" + proveedor+"\n";
    }
    

   
    
    
}
