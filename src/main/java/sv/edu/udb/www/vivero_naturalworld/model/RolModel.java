package sv.edu.udb.www.vivero_naturalworld.model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.www.vivero_naturalworld.entities.Rol;

public class RolModel {

    SessionFactory factory = HibernateUtil.getSessionFactory();

    public int insertarRol(Rol rol) {

        Session ses = factory.openSession();

        try {

            Transaction tran = ses.beginTransaction();
            ses.save(rol);
            tran.commit();
            ses.close();
            return 1;

        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }


    public List<Rol> listarRoles() {

        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();

        ArrayList<Rol> listaRoles = new ArrayList<Rol>();
        String sql = "from Rol ";
        listaRoles = (ArrayList<Rol>) ses.createQuery(sql).list();
        return listaRoles;

    }


    public Rol obtenerRol(String codigo) {

        Session ses = factory.openSession();

        try {
            Rol rol = (Rol) ses.get(Rol.class, codigo);
            ses.close();
            return rol;

        } catch (Exception e) {
            ses.close();
            return null;
        }
    }



    public int modificarRol(Rol rol) {

        Session ses = factory.openSession();

        try {

            Transaction tran = ses.beginTransaction();
            ses.update(rol);
            tran.commit();
            ses.close();
            return 1;

        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }



    public int eliminarRol(String id){

        int filasAfectadas=0;
        Session ses= factory.openSession();

        try{
            Rol rol= (Rol) ses.get(Rol.class, id);
            if(rol != null){

                Transaction tran= ses.beginTransaction();
                ses.delete(rol);
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
}
