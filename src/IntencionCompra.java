public class IntencionCompra {
    private String fk_alias_cliente;
    private String fk_nombre_fabricante;
    private String fecha_visita;

    public IntencionCompra(String fk_nombre_fabricante) {
        this.fk_nombre_fabricante = fk_nombre_fabricante;
    }
    
    public IntencionCompra() {
    }

    public IntencionCompra(String fk_alias_cliente, String fk_nombre_fabricante, String fecha_visita) {
        this.fk_alias_cliente = fk_alias_cliente;
        this.fk_nombre_fabricante = fk_nombre_fabricante;
        this.fecha_visita = fecha_visita;
    }
    
    

    public String getFk_alias_cliente() {
        return fk_alias_cliente;
    }

    public void setFk_alias_cliente(String fk_alias_cliente) {
        this.fk_alias_cliente = fk_alias_cliente;
    }

    public String getFk_nombre_fabricante() {
        return fk_nombre_fabricante;
    }

    public void setFk_nombre_fabricante(String fk_nombre_fabricante) {
        this.fk_nombre_fabricante = fk_nombre_fabricante;
    }

    public String getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(String fecha_visita) {
        this.fecha_visita = fecha_visita;
    }

    @Override
    public String toString() {
        return "Intencion de Compra: \n" + "alias cliente: " + fk_alias_cliente+"\n" + " nombre fabricante: " + fk_nombre_fabricante+"\n" + " fecha visita: " + fecha_visita+"\n\n";
    }
    
}
