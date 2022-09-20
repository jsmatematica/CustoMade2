/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import customade2.Entidades.*;
import BD.Conexion;
import DTO.DatosCliente;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author jsmat
 */
public class PedidosController {
    public void crearPedido(Usuario u, List<DetalleDePedido> detallesDelPedido){
    Pedido p = new Pedido();
    p.setCiCliente(u.getCi());
    p.setDireccionCLiente(u.getDireccion());
    p.setEstado(EstadoPedido.NOVISTO);
    p.setFecha(new Date());
    p.setNombreCompletoCliente(u.getNombreCompleto());
    p.setTelefonoCliente(u.getTelefono());
    p.setEmailCliente(u.getEmail());
    p.setUsuario(u);
    
    p.setDetalleDePedidos(detallesDelPedido);
        for (Iterator<DetalleDePedido> iterator = detallesDelPedido.iterator(); iterator.hasNext();) {
            DetalleDePedido next = iterator.next();
            next.setPedido(p);
        }
    u.getPedidos().add(p);
//    Conexion.getInstance().persist(p);
    Conexion.getInstance().persist(u);
    }
    
    
    public void crearPedidoNoRegistrado(DatosCliente u,List<DetalleDePedido> detalles){
    
    Pedido p = new Pedido();
    p.setCiCliente(u.getCi());
    p.setDireccionCLiente(u.getDireccion());
    p.setEstado(EstadoPedido.NOVISTO);
    p.setFecha(new Date());
    p.setNombreCompletoCliente(u.getNombreCompleto());
    p.setTelefonoCliente(u.getTelefono());
    p.setEmailCliente(u.getEmail());
     p.setDetalleDePedidos(detalles);
        for (Iterator<DetalleDePedido> iterator = detalles.iterator(); iterator.hasNext();) {
            DetalleDePedido next = iterator.next();
            next.setPedido(p);
        }
    Conexion.getInstance().persist(p);
    }
    
    public List<Pedido> listarPedidos(){
        return Conexion.getInstance().select("FROM Pedido", Pedido.class);
    }
    
    public List<Pedido> listarPedidosDeUsuario(String nombreDeUsuario){
        List<Usuario> us = Conexion.getInstance().select("FROM Usuario WHERE email = '"+nombreDeUsuario+"'", Usuario.class);
        Usuario u = us.get(0);
        return u.getPedidos();
    }
}
