/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import customade2.Entidades.*;
import BD.Conexion;
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
    p.setEstado(EstadoPedido.PENDIENTEDEENVIO);
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

    Conexion.getInstance().persist(u);
    }
}
