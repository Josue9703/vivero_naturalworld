package sv.edu.udb.www.vivero_naturalworld.entities;

import jakarta.persistence.*;

@Entity
public class Categorias {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_categoria", nullable = false, length = 50)
    private String idCategoria;
    @Basic
    @Column(name = "nombre_categoria", nullable = false, length = 50)
    private String nombreCategoria;
    @Basic
    @Column(name = "descripcion", nullable = false, length = -1)
    private String descripcion;

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
