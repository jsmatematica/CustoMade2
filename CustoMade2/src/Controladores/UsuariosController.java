/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import BD.Conexion;
import customade2.Entidades.Usuario;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class UsuariosController {
    public void crearUsuario(String nombreCompleto, int ci, String telefono, String email, String direccion){
    Usuario u = new Usuario();
    u.setNombreCompleto(nombreCompleto);
    u.setCi(ci);
    u.setTelefono(telefono);
    u.setEmail(email);
    u.setDireccion(direccion);
    Conexion.getInstance().persist(u);    
    }
    
    public Usuario buscarUsuario(long idUsuario){
        List<Usuario> usu = Conexion.getInstance().select("FROM Usuario WHERE id ="+idUsuario, Usuario.class);
        return usu.get(0);
    }
    
    public List<Usuario> listarUsuarios() {
        return Conexion.getInstance().select("FROM Usuario", Usuario.class);
    }
    
    public void verificarNombreDeUsuarioDisponible() {
        
    }
}
