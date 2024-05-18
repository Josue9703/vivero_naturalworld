package sv.edu.udb.www.vivero_naturalworld.model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.www.vivero_naturalworld.entities.Usuarios;

public class UsuariosModel {

    SessionFactory factory = HibernateUtil.getSessionFactory();

    public int insertarUsuario(Usuarios usuario) {

        Session ses = factory.openSession();

        try {

            Transaction tran = ses.beginTransaction();
            ses.save(usuario);
            tran.commit();
            ses.close();
            return 1;

        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }




    public List<Usuarios> listarUsuarios(){

        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();

        ArrayList<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
        String sql = "from Usuarios ";
        listaUsuarios = (ArrayList<Usuarios>) ses.createQuery(sql).list();
        return listaUsuarios;

    }



    public Usuarios obtenerUsuario(String codigo) {

        Session ses = factory.openSession();

        try {
            Usuarios usuario = (Usuarios) ses.get(Usuarios.class, codigo);
            ses.close();
            return usuario;

        } catch (Exception e) {
            ses.close();
            return null;
        }
    }




    public int modificarUsuario(Usuarios usuario) {

        Session ses = factory.openSession();

        try {

            Transaction tran = ses.beginTransaction();
            ses.update(usuario);
            tran.commit();
            ses.close();
            return 1;

        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }




    public int eliminarUsuario(String id){

        int filasAfectadas = 0;
        Session ses= factory.openSession();

        try{
            Usuarios usuario = (Usuarios) ses.get(Usuarios.class, id);
            if(usuario !=null){

                Transaction tran= ses.beginTransaction();
                ses.delete(usuario);
                tran.commit();
                filasAfectadas = 1;

            }
            ses.close();
            return filasAfectadas;

        }
        catch(Exception e){
            ses.close();
            return filasAfectadas;
        }
    }
}
