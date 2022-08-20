
import java.util.Scanner;


public class main {

   
    public static void main(String[] args) {
        
        crudFabricante cf = new crudFabricante();
        ConsultaJoin cj = new ConsultaJoin();
        crudProveedor cp = new crudProveedor();
        crudBicicletas cb = new crudBicicletas();
        crudMoto cm = new crudMoto();
        crudCliente cc = new crudCliente();
        crudIntencionCompra cic = new crudIntencionCompra();
        Scanner x = new Scanner(System.in);
        System.err.println("1. Consultar Fabricantes\n2. Buscar fabricante por nombre.\n3.Actualizar fabricante \n4. Insertar fabricante. .\n5. Eliminar fabricante."
                + "       \n6.  Listar proveedores .\n7.buscar proveedor por id \n8. modificar proveedor \n9. crear proveedor \n10. elimar proveedor"
                + "\n11. Listar Bicicletas. \n12. Buscar bicileta por id .\n13.Modificar Bicicleta \n14. Crear Bicicleta \n15. eliminar Bicicleta \n16. listar Motos"
                + "\n17. Buscar Moto por id. \n18. modificar Moto .\n19.Crear Moto \n20. Eliminar Moto \n21. listar compras  \n22. buscar posible compra por por alias de cliente"
                + "\n23. modificar intencion de compra. \n24. crear intencion de compra .\n25.eliminar intencion de compra\n26. listar clientes \n27. buscar cliente por alias \n28. actualizar cliente"
                + "\n29. crear cliente \n30. eliminar cliente. \n31. consultar y ordenar fabricants por nombre (consulta 1) .\n32 consulta bicicletas del año mayor o igual a 2019 (consulta 2)"
                + "\n33. seleccionar motocicleta por id del proveedor (consulta 3) \n34. consultar intencion de compra por alias de cliente y ordenado por nombre(consulta 4) \n35. consulta 5 traer de intencion de compra el alias, nombre y appelido del cliente donde el nombre del fabricante sea yeti"
                + "\n36. cantidad de bibicletas donde el año es mayor o igual a 2019 \n37.SALIR");
        int opcion = x.nextInt();
        
        while (opcion!=40) {
            switch (opcion) {
                case 1:
                    for (Fabricante f : cf.ConsultarTodosLosFabricantes()) {
                    System.out.println(f.toString());
                    }
                    break;
                case 2:
                    System.out.println("Digite el nombre del fabricante a buscar ");
                    String dato = x.next();
                    if (cf.BuscarFabricante(dato).size() > 0) {
                    for (Fabricante f : cf.BuscarFabricante(dato)) {
                        System.out.println(f.toString());
                    }
                } else {
                    System.err.println("La busqueda no arrojo resultados");
                }
                    break;
                case 3:
                   System.err.println("ingrese nombre del fabricante al cual desea realizarle cambios");
                    x.nextLine();
                    String f =x.nextLine();
                    if(cf.modificarFabricante(f)){
                        System.out.println("modificación de fabricante exitosa");
                    }else{
                        System.err.println("Error al editar fabricante");
                    }
                    break;
                case 4:
                    System.err.println("ingrese nombre del fabricante a crear");
                    x.nextLine();
                    String fabricante =x.nextLine();
                    if(cf.crearFabricante(fabricante)){
                        System.out.println("creacion de fabricante exitosa");
                    }else{
                        System.err.println("Error al crear fabricante");
                    }
                    break;
                case 5:
                    System.err.println("ingrese nombre del fabricante que desea eliminar");
                    x.nextLine();
                    String nom_f =x.nextLine();
                    if(cf.EliminarFabricante(nom_f)){
                        System.out.println("El fabricante fue eliminado");
                    }else{
                        System.err.println("Error al eliminar fabricante");
                    }
                    break;
                case 6:
                    for (Proveedor p : cp.ConsultarTodosLosProveedores()) {
                    System.out.println(p.toString());
                    }
                    break;
                case 7:
                    System.out.println("Digite el id del proveedor a buscar ");
                    int datop = x.nextInt();
                    if (cp.buscarProveedor(datop).size() > 0) {
                    for (Proveedor p : cp.buscarProveedor(datop)) {
                        System.out.println(p.toString());
                    }
                } else {
                    System.err.println("La busqueda no arrojo resultados");
                }
                    break;
                case 8:
                   System.err.println("ingrese id del proveedor al cual desea realizarle cambios");
                    int id =x.nextInt();
                    if(cp.modificarProveedor(id)){
                        System.out.println("modificación de proveedor exitosa");
                    }else{
                        System.err.println("Error al editar proveedor");
                    }
                    break;
                case 9:
                    System.err.println("ingrese id del proveedor a crear");
                    int id_p =x.nextInt();
                    if(cp.crearProveedor(id_p)){
                        System.out.println("creacion de proveedor exitosa");
                    }else{
                        System.err.println("Error al crear proveedor");
                    }
                    break;
                case 10:
                    System.err.println("ingrese id del proveedor que desea eliminar");
                    int id_pr =x.nextInt();
                    if(cp.eliminarProveedor(id_pr)){
                        System.out.println("El proveedor fue eliminado");
                    }else{
                        System.err.println("Error al eliminar proveedor");
                    }
                    break;
                case 11:
                    for (Bicicleta b : cb.ConsultarTodosLasBicicletas()) {
                    System.out.println(b.toString());
                    }
                    break;
                case 12:
                    System.out.println("Digite id de la bicicleta a buscar ");
                    int id_b = x.nextInt();
                    if (cb.buscarbicicleta(id_b).size() > 0) {
                    for (Bicicleta b : cb.buscarbicicleta(id_b)) {
                        System.out.println(b.toString());
                    }
                } else {
                    System.err.println("La busqueda no arrojo resultados");
                }
                    break;
                case 13:
                   System.err.println("ingrese id de la bicicleta que desea actualizar");
                    x.nextLine();
                    int b_id =x.nextInt();
                    if(cb.modificarBicicleta(b_id)){
                        System.out.println("modificación de bicicleta exitosa");
                    }else{
                        System.err.println("Error al editar bibicleta");
                    }
                    break;
                case 14:
                    if(cb.crearBicicleta()){
                        System.out.println("creacion de bicicleta exitosa");
                    }else{
                        System.err.println("Error al crear bicicleta");
                    }
                    break;
                case 15:
                    System.err.println("ingrese id de la bicicleta que desea eliminar");
                    int bicicleta_id =x.nextInt();
                    if(cb.eliminarBicicleta(bicicleta_id)){
                        System.out.println("la bicicleta fue eliminado");
                    }else{
                        System.err.println("Error al eliminar bicicleta");
                    }
                    break;
                case 16:
                    for (MotoCicleta m : cm.ConsultarTodosLasMotos()) {
                    System.out.println(m.toString());
                    }
                    break;
                case 17:
                    System.out.println("Digite id de la moto a buscar ");
                    int dato_m = x.nextInt();
                    if (cm.buscarMoto(dato_m).size() > 0) {
                    for (MotoCicleta mt : cm.buscarMoto(dato_m)) {
                        System.out.println(mt.toString());
                    }
                } else {
                    System.err.println("La busqueda no arrojo resultados");
                }
                    break;
                case 18:
                   System.err.println("ingrese id de la moto al cual desea realizarle cambios");
                    int moto =x.nextInt();
                    if(cm.modificarMoto(moto)){
                        System.out.println("modificación de moto exitosa");
                    }else{
                        System.err.println("Error al editar moto");
                    }
                    break;
                case 19:
                    if(cm.crearMoto()){
                        System.out.println("creacion de moto exitosa");
                    }else{
                        System.err.println("Error al crear moto");
                    }
                    break;
                case 20:
                    System.err.println("ingrese id de la moto a eliminarar");
                    int mtt_id =x.nextInt();
                    if(cm.eliminarMoto(mtt_id)){
                        System.out.println("El fabricante fue eliminado");
                    }else{
                        System.err.println("Error al eliminar fabricante");
                    }
                    break;
                case 21:
                    for (IntencionCompra ic : cic.ConsultarTodosLasIntencionesCompra()) {
                    System.out.println(ic.toString());
                    }
                    break;
                case 22:
                    System.out.println("Digite el alias del cliente para encontrar la intencion de compra");
                    String alias_ic = x.next();
                    if (cic.buscarCompras(alias_ic).size() > 0) {
                    for (IntencionCompra icc : cic.buscarCompras(alias_ic)) {
                        System.out.println(icc.toString());
                    }
                } else {
                    System.err.println("La busqueda no arrojo resultados");
                }
                    break;
                case 23:
                   System.err.println("ingrese alias del cliente para modificar intencion de compra");
                    x.nextLine();
                    String f_compra =x.nextLine();
                    if(cic.modificarIntencionCompra(f_compra)){
                        System.out.println("modificación de compra exitosa");
                    }else{
                        System.err.println("Error al editar compra");
                    }
                    break;
                case 24:
                    if(cic.crearIntencionCompra()){
                        System.out.println("creacion de intención de compra exitosa");
                    }else{
                        System.err.println("Error al crear intención de compra");
                    }
                    break;
                case 25:
                    System.err.println("ingrese alias del cliente para eliminar intencion de compra en la que se encuentre asociado");
                    x.nextLine();
                    String nom_cliente =x.nextLine();
                    if(cic.eliminarIntencionCompra(nom_cliente)){
                        System.out.println("La intencion de compra fue eliminada");
                    }else{
                        System.err.println("Error al eliminar intencion de compra");
                    }
                    break;
                case 26:
                    for (Cliente c : cc.consultarTodosLosClientes()) {
                    System.out.println(c.toString());
                    }
                    break;
                case 27:
                    System.out.println("Digite el alias del cliente a buscar");
                    String alias_cliente = x.next();
                    if (cc.buscarCliente(alias_cliente).size() > 0) {
                    for (Cliente icc : cc.buscarCliente(alias_cliente)) {
                        System.out.println(icc.toString());
                    }
                    } else {
                        System.err.println("La busqueda no arrojo resultados");
                    }
                    break;
                case 28:
                    System.err.println("ingrese alias del cliente a modificar");
                    x.nextLine();
                    String alias_client =x.nextLine();
                    if(cc.modificarCliente(alias_client)){
                        System.out.println("modificación de cliente exitosa");
                    }else{
                        System.err.println("Error al editar cliente");
                    }
                    break;
                case 29:
                    System.err.println("ingrese alias del cliente que desea crear");
                    x.nextLine();
                    String all_client =x.nextLine();
                    if(cc.crearCliente(all_client)){
                        System.out.println("creacion de intención de compra exitosa");
                    }else{
                        System.err.println("Error al crear intención de compra");
                    }
                    break;
                case 30:
                    System.err.println("ingrese alias del cliente a eliminar");
                    x.nextLine();
                    String delete_client = x.nextLine();
                    if(cc.eliminarCliente(delete_client)){
                        System.out.println("El cliente fue eliminado");
                    }else{
                        System.err.println("Error al eliminar el cliente");
                    }
                    break;
                case 31:
                    System.out.println("consulta 1 traer de fabricantes el nombre del fabricante ordenado por nombre--->>>");
                    for (Fabricante f1 : cf.consulta1()) {
                    System.out.println(f1.getNombre_fabricante());
                    }
                     System.out.println("consulta 1 traer de fabricantes el nombre del fabricante ordenado por nombre--->>>");
                    break;
                case 32:
                    for (Bicicleta b1 : cb.Consulta2()) {
                    System.out.println("fabricante: "+b1.getNombre_fabricante()+"  año: "+ b1.getAnio() +"  precio unt bicicleta:"+ b1.getPrecio_unitario()+"\n\n");
                    }
                    break;
                case 33:
                    System.out.println("consulta 3 traer de motocicletas el nombre del fabricante donde el proveedor tenga el id = 101--->>>");
                    for (MotoCicleta mc : cm.consulta3()) {
                    System.out.println("fabricante: "+mc.getNombre_fabricante());
                    }
                    System.out.println("------------------------------------------------------------------------------------------------->>>");
                    break;
                case 34:
                    System.out.println("consulta 4 traer de intencion de compra el nombre del fabricante donde el alias del cliente sea lucky--->>>");
                    for (IntencionCompra icc : cic.consulta4()) {
                    System.out.println("fabricante: "+icc.getFk_nombre_fabricante());
                    }
                    System.out.println("------------------------------------------------------------------------------------------------->>>");
                    break;
                case 35:
                    System.out.println("consulta 5 traer de intencion de compra el alias, nombre y appelido del cliente donde el nombre del fabricante sea yeti--->>>");
                    for (ConsultaJoin cjj : cj.datosCliente()) {
                    System.out.println("alias cliente: "+cjj.getAlias()+ " nombre de cliente: "+cjj.getNombre() +" apellido del cliente: "+cjj.getApellidos());
                    }
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------->>>");
                    break;
                case 36:
                    System.out.println("consulta 6 traer de bicicletas la cantidad de fabricantes donde el año de la bicicleta sea mayor o igual a 2019--->>>");
                    int valor = cb.Consulta6();
                    System.err.println("cantidad de fabricantes: "+valor);
                    System.out.println("------------------------------------------------------------------------------------------------------------------>>>");
                    break;
                    
                default:
                    throw new AssertionError();
            }
            System.out.println("1. Consultar Fabricantes\n2. Buscar fabricante por nombre.\n3.Actualizar fabricante \n4. Insertar fabricante. .\n5. Eliminar fabricante."
                + "       \n6.  Listar proveedores .\n7.buscar proveedor por id \n8. modificar proveedor \n9. crear proveedor \n10. elimar proveedor"
                + "\n11. Listar Bicicletas. \n12. Buscar bicileta por id .\n13.Modificar Bicicleta \n14. Crear Bicicleta \n15. eliminar Bicicleta \n16. listar Motos"
                + "\n17. Buscar Moto por id. \n18. modificar Moto .\n19.Crear Moto \n20. Eliminar Moto \n21. listar compras  \n22. buscar posible compra por por alias de cliente"
                + "\n23. modificar intencion de compra. \n24. crear intencion de compra .\n25.eliminar intencion de compra\n26. listar clientes \n27. buscar cliente por alias \n28. actualizar cliente"
                + "\n29. crear cliente \n30. eliminar cliente. \n31. consultar y ordenar fabricants por nombre (consulta 1) .\n32 consulta bicicletas del año mayor o igual a 2019 (consulta 2)"
                + "\n33. seleccionar motocicleta por id del proveedor (consulta 3) \n34. consultar intencion de compra por alias de cliente y ordenado por nombre(consulta 4) \n35. consulta 5 traer de intencion de compra el alias, nombre y appelido del cliente donde el nombre del fabricante sea yeti"
                + "\n36. cantidad de bibicletas donde el año es mayor o igual a 2019 \n37.SALIR");
            opcion = x.nextInt();
        }
                        
    }
    
}
