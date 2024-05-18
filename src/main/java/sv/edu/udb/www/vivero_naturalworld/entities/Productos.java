package sv.edu.udb.www.vivero_naturalworld.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Productos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_producto", nullable = false, length = 50)
    private String idProducto;
    @Basic
    @Column(name = "foto", nullable = false, length = 100)
    private String foto;
    @Basic
    @Column(name = "nombre_producto", nullable = false, length = 100)
    private String nombreProducto;
    @Basic
    @Column(name = "descripcion", nullable = false, length = -1)
    private String descripcion;
    @Basic
    @Column(name = "precio", nullable = false, precision = 2)
    private BigDecimal precio;
    @Basic
    @Column(name = "existencias", nullable = false)
    private int existencias;
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
    private Categorias categoriasByIdCategoria;

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public Categorias getCategoriasByIdCategoria() {
        return categoriasByIdCategoria;
    }

    public void setCategoriasByIdCategoria(Categorias categoriasByIdCategoria) {
        this.categoriasByIdCategoria = categoriasByIdCategoria;
    }
}
