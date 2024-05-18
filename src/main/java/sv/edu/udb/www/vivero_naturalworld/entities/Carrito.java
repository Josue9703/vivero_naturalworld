package sv.edu.udb.www.vivero_naturalworld.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Carrito {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_carrito", nullable = false, length = 50)
    private String idCarrito;
    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic
    @Column(name = "precio_unitario", nullable = false, precision = 2)
    private BigDecimal precioUnitario;
    @Basic
    @Column(name = "total", nullable = false, precision = 2)
    private BigDecimal total;
    @Basic
    @Column(name = "estado", nullable = false)
    private byte estado;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private Usuarios usuariosByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false)
    private Productos productosByIdProducto;

    public String getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(String idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public Usuarios getUsuariosByIdUsuario() {
        return usuariosByIdUsuario;
    }

    public void setUsuariosByIdUsuario(Usuarios usuariosByIdUsuario) {
        this.usuariosByIdUsuario = usuariosByIdUsuario;
    }

    public Productos getProductosByIdProducto() {
        return productosByIdProducto;
    }

    public void setProductosByIdProducto(Productos productosByIdProducto) {
        this.productosByIdProducto = productosByIdProducto;
    }
}
