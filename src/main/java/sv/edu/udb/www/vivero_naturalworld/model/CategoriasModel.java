package sv.edu.udb.www.vivero_naturalworld.model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.www.vivero_naturalworld.entities.Categorias;

public class CategoriasModel {

    SessionFactory factory = HibernateUtil.getSessionFactory();

    //INICIO METODO QUE LISTA TODAS LAS CATEGORIAS
    public List<Categorias> listarCategorias(){

        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();

        ArrayList<Categorias> listaCategorias = new ArrayList<Categorias>();
        String sql = "from Categorias ";

        listaCategorias = (ArrayList<Categorias>)ses.createQuery(sql).list();
        return listaCategorias;
    }
    //FIN METODO QUE LISTA TODAS LAS CATEGORIAS



    //INICIO METODO QUE INSERTAR UNA CATEGORIA
    public int insertarCategoria(Categorias categoria) {

        Session ses = factory.openSession();

        try {

            Transaction tran = ses.beginTransaction();
            ses.save(categoria);
            tran.commit();
            ses.close();
            return 1;

        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }
    //FIN METODO QUE INSERTAR UNA CATEGORIA



    //INICIO METODO QUE OBTIENE UNA CATEGORIA POR MEDIO DEL ID
    public Categorias obtenerCategoria(String codigo) {

        Session ses = factory.openSession();

        try {

            Categorias categoria = (Categorias) ses.get(Categorias.class, codigo);
            ses.close();
            return categoria;

        }catch(Exception e){
            ses.close();
            return null;
        }
    }
    //FIN METODO QUE OBTIENE UNA cATEGORIA POR MEDIO DEL ID



    //INICIO METODO QUE MODIFICA UNA CATEGORIA POR MEDIO DEL ID
    public int modificarCategoria(Categorias categoria) {

        Session ses = factory.openSession();

        try {

            Transaction tran = ses.beginTransaction();
            ses.update(categoria);
            tran.commit();
            ses.close();
            return 1;

        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }
    //FIN METODO QUE MODIFICA UNA CATEGORIA POR MEDIO DEL ID



    //INICIO METODO PARA ELIMINAR UNA CATEGORIA POR MEDIO DEL ID
    public int eliminarCategoria(String id){

        int filasAfectadas=0;
        Session ses= factory.openSession();

        try{

            Categorias categoria = (Categorias) ses.get(Categorias.class, id);
            if(categoria != null){

                Transaction tran= ses.beginTransaction();
                ses.delete(categoria);
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
    //FIN METODO PARA ELIMINAR UNA CATEGORIA POR MEDIO DEL ID
}
