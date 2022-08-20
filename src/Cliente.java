
public class Cliente {
    private String alias;
    private String cliente_nombres;
    private String cliente_apellidos;
    private String cliente_email;
    private String cliente_celular;
    private String cliente_contrasena;
    private String cliente_fecha_nacimiento;

    public Cliente() {
    }

    public Cliente(String alias, String cliente_nombres, String cliente_apellidos, String cliente_email, String cliente_celular, String cliente_contrasena, String cliente_fecha_nacimiento) {
        this.alias = alias;
        this.cliente_nombres = cliente_nombres;
        this.cliente_apellidos = cliente_apellidos;
        this.cliente_email = cliente_email;
        this.cliente_celular = cliente_celular;
        this.cliente_contrasena = cliente_contrasena;
        this.cliente_fecha_nacimiento = cliente_fecha_nacimiento;
    }
    
    

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCliente_nombres() {
        return cliente_nombres;
    }

    public void setCliente_nombres(String cliente_nombres) {
        this.cliente_nombres = cliente_nombres;
    }

    public String getCliente_apellidos() {
        return cliente_apellidos;
    }

    public void setCliente_apellidos(String cliente_apellidos) {
        this.cliente_apellidos = cliente_apellidos;
    }

    public String getCliente_email() {
        return cliente_email;
    }

    public void setCliente_email(String cliente_email) {
        this.cliente_email = cliente_email;
    }

    public String getCliente_celular() {
        return cliente_celular;
    }

    public void setCliente_celular(String cliente_celular) {
        this.cliente_celular = cliente_celular;
    }

    public String getCliente_contrasena() {
        return cliente_contrasena;
    }

    public void setCliente_contrasena(String cliente_contrasena) {
        this.cliente_contrasena = cliente_contrasena;
    }

    public String getCliente_fecha_nacimiento() {
        return cliente_fecha_nacimiento;
    }

    public void setCliente_fecha_nacimiento(String cliente_fecha_nacimiento) {
        this.cliente_fecha_nacimiento = cliente_fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "Cliente: \n" + "alias=" + alias+"\n" + " cliente_nombres=" + cliente_nombres+"\n" + " cliente_apellidos=" + cliente_apellidos+"\n" + " cliente_email=" + cliente_email+"\n" + " cliente_celular=" + cliente_celular+"\n" + " cliente_contrasena=" + cliente_contrasena+"\n" + " cliente_fecha_nacimiento=" + cliente_fecha_nacimiento+"\n\n";
    }
    
    
    
}
