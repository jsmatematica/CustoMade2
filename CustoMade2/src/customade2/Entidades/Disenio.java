/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customade2.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author jsmat
 */
@Entity
public class Disenio implements Serializable {

    @OneToMany(mappedBy = "disneioDelDetalle", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<DetalleDePedido> detalleDePedidos;

    @OneToMany(mappedBy = "disenio", cascade = {CascadeType.MERGE, CascadeType.PERSIST},fetch=FetchType.EAGER)
    private List<Imagen> imagens;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private float precioUnitario;
    private boolean publico;

    
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST},fetch=FetchType.EAGER)
    private List<Articulo> articulos;

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
    

    public List<Imagen> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagen> imagens) {
        this.imagens = imagens;
    }

    public List<DetalleDePedido> getDetalleDePedidos() {
        return detalleDePedidos;
    }

    public void setDetalleDePedidos(List<DetalleDePedido> detalleDePedidos) {
        this.detalleDePedidos = detalleDePedidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public boolean isPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disenio)) {
            return false;
        }
        Disenio other = (Disenio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "customade2.Entidades.Disenio[ id=" + id + " ]";
    }
    
}
