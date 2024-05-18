package sv.edu.udb.www.vivero_naturalworld.model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.www.vivero_naturalworld.entities.Productos;


public class ProductosModel {

    SessionFactory factory = HibernateUtil.getSessionFactory();

    //INICIO METODO QUE LISTA TODOS LOS PRODUCTOS
    public List<Productos> listarProductos(){

        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();

        ArrayList<Productos> listaProductos = new ArrayList<Productos>();
        String sql = "from Productos ";

        listaProductos = (ArrayList<Productos>)ses.createQuery(sql).list();
        return listaProductos;
    }
    //FIN METODO QUE LISTA TODOS LOS PRODUCTOS



    //INICIO METODO QUE INSERTAR UN PRODUCTO
    public int insertarProducto(Productos producto) {

        Session ses = factory.openSession();

        try {

            Transaction tran = ses.beginTransaction();
            ses.save(producto);
            tran.commit();
            ses.close();
            return 1;

        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }
    //FIN METODO QUE INSERTAR UN PRODUCTO



    //INICIO METODO QUE OBTIENE UN PRODUCTO POR MEDIO DEL ID
    public Productos obtenerProducto(String codigo) {

        Session ses = factory.openSession();

        try {

            Productos producto = (Productos) ses.get(Productos.class, codigo);
            ses.close();
            return producto;

        }catch(Exception e){
            ses.close();
            return null;
        }
    }
    //FIN METODO QUE OBTIENE UN PRODUCTO POR MEDIO DEL ID



    //INICIO METODO QUE MODIFICA UN PRODUCTO POR MEDIO DEL ID
    public int modificarProducto(Productos producto) {

        Session ses = factory.openSession();

        try {

            Transaction tran = ses.beginTransaction();
            ses.update(producto);
            tran.commit();
            ses.close();
            return 1;

        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }
    //FIN METODO QUE MODIFICA UN PRODUCTO POR MEDIO DEL ID



    //INICIO METODO PARA ELIMINAR UN PRODUCTO POR MEDIO DEL ID
    public int eliminarProducto(String id){

        int filasAfectadas=0;
        Session ses= factory.openSession();

        try{

            Productos producto = (Productos) ses.get(Productos.class, id);
            if(producto != null){

                Transaction tran= ses.beginTransaction();
                ses.delete(producto);
                tran.commit();
                filasAfectadas=1;

            }

            ses.close();
            return filasAfectadas;

        }
        catch(Exception e){
            ses.close();
            return filasAfectadas;
        }
    }
    //FIN METODO PARA ELIMINAR UN PRODUCTO POR MEDIO DEL ID
}
