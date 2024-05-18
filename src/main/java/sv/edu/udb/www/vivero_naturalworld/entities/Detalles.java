package sv.edu.udb.www.vivero_naturalworld.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Detalles {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_detalles", nullable = false, length = 50)
    private String idDetalles;
    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic
    @Column(name = "precio_unitario", nullable = false, precision = 2)
    private BigDecimal precioUnitario;
    @Basic
    @Column(name = "Total", nullable = false, precision = 2)
    private BigDecimal total;
    @ManyToOne
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta", nullable = false)
    private Ventas ventasByIdVenta;
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false)
    private Productos productosByIdProducto;

    public String getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(String idDetalles) {
        this.idDetalles = idDetalles;
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

    public Ventas getVentasByIdVenta() {
        return ventasByIdVenta;
    }

    public void setVentasByIdVenta(Ventas ventasByIdVenta) {
        this.ventasByIdVenta = ventasByIdVenta;
    }

    public Productos getProductosByIdProducto() {
        return productosByIdProducto;
    }

    public void setProductosByIdProducto(Productos productosByIdProducto) {
        this.productosByIdProducto = productosByIdProducto;
    }
}
