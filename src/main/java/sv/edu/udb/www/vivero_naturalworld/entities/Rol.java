package sv.edu.udb.www.vivero_naturalworld.entities;

import jakarta.persistence.*;

@Entity
public class Rol {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_rol", nullable = false, length = 50)
    private String idRol;
    @Basic
    @Column(name = "nombre_rol", nullable = false, length = 50)
    private String nombreRol;

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
