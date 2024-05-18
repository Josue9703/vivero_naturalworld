package sv.edu.udb.www.vivero_naturalworld.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Ventas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_venta", nullable = false, length = 50)
    private String idVenta;
    @Basic
    @Column(name = "fecha_venta", nullable = false)
    private Date fechaVenta;
    @Basic
    @Column(name = "total_venta", nullable = false, precision = 2)
    private BigDecimal totalVenta;
    @Basic
    @Column(name = "metodo_pago", nullable = false, length = 50)
    private String metodoPago;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private Usuarios usuariosByIdUsuario;

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Usuarios getUsuariosByIdUsuario() {
        return usuariosByIdUsuario;
    }

    public void setUsuariosByIdUsuario(Usuarios usuariosByIdUsuario) {
        this.usuariosByIdUsuario = usuariosByIdUsuario;
    }
}
