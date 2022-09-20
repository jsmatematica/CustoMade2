/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Controladores.ArticulosController;
import Controladores.DiseniosController;
import Controladores.PedidosController;
import customade2.Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class Conexion {
    
    private Conexion() {
    }
    
    public static Conexion getInstance() {
        return ConexionHolder.INSTANCE;
    }
    
    private static class ConexionHolder { //variables para instanciar una unica vez

        private static final Conexion INSTANCE = new Conexion();
        private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CustoMade2PU");
        private static final EntityManager em = emf.createEntityManager();
        private static final PedidosController controladorDePedidos = new PedidosController();
        private static final DiseniosController controladorDeDisenios = new DiseniosController();
        private static final ArticulosController controladorDeArticulos = new ArticulosController();
    }
    
    public ArticulosController getControladorDeArticulos(){
    return ConexionHolder.controladorDeArticulos;
    }
    
    public PedidosController getControladorDePedidos(){
        return ConexionHolder.controladorDePedidos;
    }
    
    public DiseniosController getCOntroladorDeDisenios(){
    return ConexionHolder.controladorDeDisenios;
    }
    
     public EntityManager getEntity(){
        return ConexionHolder.em; 
    }
    
    public void persist(Object object) { //guarda en la base de datos
        EntityManager em = getEntity();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } 
    }
    
//    public void remove(Object object) { //elimina fisicamente de la bd, solo borrar cosas puntuales
//        EntityManager em = getEntity();
//        em.getTransaction().begin();
//        try {
//            em.remove(object);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            em.getTransaction().rollback();
//        } 
//    }
    
    public void merge(Object object) { //actualiza la base de datos con la informacion de la memoria
        EntityManager em = getEntity();
        em.getTransaction().begin();
        try {
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } 
    }
    
//    public void refresh(Object object) { //vuelve a copiar la base de datos a memoria
//        EntityManager em = getEntity();
//        em.getTransaction().begin();
//        try {
//            em.refresh(object);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            em.getTransaction().rollback();
//        } 
//    }

    public <T> List<T> select(String hq1, Class<T> clase){
       EntityManager em = getEntity();
        List<T> resultado = null;
        em.getTransaction().begin();
        try {
            resultado = em.createQuery(hq1, clase).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return resultado;
    }
    
//    public List<Usuario> listaSucursales(){ //copio y pego y cambio el objeto nomas
//        EntityManager em = getEntity();
//        List<Usuario> resultado = null;
//        em.getTransaction().begin();
//        try {
//            resultado = em.createNativeQuery("SELECT * FROM Sucursal", Usuario.class).getResultList();
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//        }
//        return null;
//        
//    }
//    
//    //otra opcion
//     public List<Usuario> listaSucursalesConcatenando(int variable){ //copio y pego y cambio el objeto nomas
//        EntityManager em = getEntity();
//        List<Usuario> resultado = null;
//        em.getTransaction().begin();
//        try {
//            resultado = em.createNativeQuery("SELECT * FROM Sucursal WHERE id="+ variable, Usuario.class).getResultList();
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//        }
//        return null;
//        
//    }
//    
//    //consultas con filtro, tres opciones modificar la parte del select concatenando o lo que fuere, otra opcion es definir una query
//    //e igualar la variable resultado a esta en vez de concatenar hago por ej "SELECT FROM RESERVA WHERE id = :nombre" esto se 
//    //llama parametrizar la consulta
//    public List<Usuario> listaSucursalesUnParametro(int valor){ 
//        EntityManager em = getEntity();
//        List<Usuario> resultado = null;
//        em.getTransaction().begin();
//        try {
//            Query q = em.createNativeQuery("SELECT * FROM Sucursal WHERE id= :nombre", Usuario.class);
//            q.setParameter("nombre", valor);
//            resultado = q.getResultList();
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//        }
//        return null;
//        
//    }
//    
//    
//    public List<Usuario> listaSucursalesVariosParametros(ArrayList valores){ 
//        EntityManager em = getEntity();
//        List<Usuario> resultado = null;
//        em.getTransaction().begin();
//        try {
//            Query q = em.createNativeQuery("SELECT * FROM Sucursal WHERE id= :nombre", Usuario.class);
//            for (int i = 0; i < valores.size(); i++) { //esto carga la variable nombre dentro de la consulta
//                Object obj = valores.get(i);
//                q.setParameter(i, obj);
//            }
//            resultado = q.getResultList();
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//        }
//        return null;
//        
//    }
    
}
