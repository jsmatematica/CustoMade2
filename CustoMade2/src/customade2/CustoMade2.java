/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customade2;

import BD.Conexion;
import Controladores.*;
import DTO.DatosCliente;
import customade2.Entidades.Articulo;
import customade2.Entidades.DetalleDePedido;
import customade2.Entidades.Disenio;
import customade2.Entidades.EstadoPedido;
import customade2.Entidades.Imagen;
import customade2.Entidades.Pedido;
import customade2.Entidades.Posicion;
import customade2.Entidades.TipoArticulo;
import customade2.Entidades.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jsmat
 */
public class CustoMade2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Primer Commit en desarrollo");
        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CustoMade2PU");
//        EntityManager em = emf.createEntityManager();
//        Articulo a = new Articulo();
//        a.setColor("Negro");
//        byte[] imagenDeFondo = {1,2,3,4,};
//        a.setImagenDeFondo(imagenDeFondo);
//        a.setPrecioUnitario(500);
//        a.setStock(1500);
//        a.setTalle("XXL");
//        a.setTipo(TipoArticulo.TAZA);
//        
//        Usuario u = new Usuario();
//        u.setCi(42296435);
//        u.setDireccion("Enrrique Segoviano");
//        u.setNombreCompleto("Juan Garchon");
//        u.setTelefono("099000000");
//        u.setEmail("juangarc@mail.com");
//        
//        Imagen i = new Imagen();
//        i.setAncho(10);
//        i.setLargo(20);
//        byte[] arr = {1,2,3};
//        i.setImagenProporcionada(arr);
//        i.setMarginLeft(10);
//        i.setMarginTop(50);
//        i.setPosicionBackFront(Posicion.FRONT);
//        
//        Disenio d = new Disenio();
//        List<Articulo> la = new ArrayList<Articulo>();
//        la.add(a);
//        d.setArticulos(la);
//        List<Imagen> imagens = new ArrayList<Imagen>();
//        imagens.add(i);
//        d.setImagens(imagens);
//        d.setNombre("Dis");
//        d.setPrecioUnitario(500);
//        d.setPublico(true);
//        
//        Pedido p = new Pedido();
//        p.setUsuario(u);
//        p.setEstado(EstadoPedido.PENDIENTEDEENVIO);
//        p.setCiCliente(p.getUsuario().getCi());
//        p.setDireccionCLiente(p.getUsuario().getDireccion());
//        p.setEmailCliente(p.getUsuario().getEmail());
//        p.setNombreCompletoCliente(p.getUsuario().getNombreCompleto());
//        p.setTelefonoCliente(p.getUsuario().getTelefono());
//        p.setPrecioTotal(1500);
//        p.setFecha(new Date());
//        
//        
//        em.getTransaction().begin();
//        em.persist(a);
//        em.persist(u);
//        em.persist(i);
//        em.persist(d);
//        em.persist(p);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//        
        
Articulo a = new Articulo();
        a.setColor("Negro");
        byte[] imagenDeFondo = {1,2,3,4,};
        a.setImagenDeFondo(imagenDeFondo);
        a.setPrecioUnitario(500);
        a.setStock(1500);
        a.setTalle("XXL");
        a.setTipo(TipoArticulo.TAZA);
 DatosCliente u = new DatosCliente();
        u.setCi(42296435);
        u.setDireccion("Enrrique Segoviano");
        u.setNombreCompleto("Juan Garchon");
        u.setTelefono("099000000");
        u.setEmail("juangarc@mail.com");
//        
        Imagen i = new Imagen();
        i.setAncho(10);
        i.setLargo(20);
        byte[] arr = {1,2,3};
        i.setImagenProporcionada(arr);
        i.setMarginLeft(10);
        i.setMarginTop(50);
        i.setPosicionBackFront(Posicion.FRONT);
//        
        Disenio d = new Disenio();
        d.setArticulo(a);
        List<Imagen> imagens = new ArrayList<Imagen>();
        i.setDisenio(d);
        imagens.add(i);
        d.setImagens(imagens);
        d.setNombre("Dis");
        d.setPrecioUnitario(500);
        d.setPublico(true);
//        
        DetalleDePedido dp = new DetalleDePedido();
        dp.setCantidad(1);
        dp.setPrecioUnitario(a.getPrecioUnitario());
        dp.setDisneioDelDetalle(d);
        
        List<DetalleDePedido> detalles = new ArrayList<DetalleDePedido>();
        detalles.add(dp);
//        PedidosController pc = new PedidosController();
//        pc.crearPedido(u, detalles);
////        
////        
//    Pedido p = new Pedido();
//    p.setCiCliente(u.getCi());
//    p.setDireccionCLiente(u.getDireccion());
//    p.setEstado(EstadoPedido.PENDIENTEDEENVIO);
//    p.setFecha(new Date());
//    p.setNombreCompletoCliente(u.getNombreCompleto());
//    p.setTelefonoCliente(u.getTelefono());
//    p.setEmailCliente(u.getEmail());
//    p.setUsuario(u);
//    
//    p.setDetalleDePedidos(detalles);
//    dp.setPedido(p);
//    u.getPedidos().add(p);
////
////    Conexion.getInstance().persist(u);
//
    Conexion.getInstance().getControladorDePedidos().crearPedidoNoRegistrado(u, detalles);

        
     
//        Conexion.getInstance().persist(a);
//        Conexion.getInstance().persist(u);
//        Conexion.getInstance().persist(d);
//        Conexion.getInstance().persist(p);
//        u.getPedidos().add(p);
//        Conexion.getInstance().merge(u);
//        List<Disenio> d2 = Conexion.getInstance().select("FROM Disenio WHERE id = 1", Disenio.class);
//        for (Iterator<Disenio> iterator = d2.iterator(); iterator.hasNext();) {
//            Disenio next = iterator.next();
//            System.out.print(next.getArticulo().getPrecioUnitario());
//        }
        
        
        
        
        
    

    }
    
}
