/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import BD.Conexion;
import customade2.Entidades.Articulo;
import customade2.Entidades.TipoArticulo;
import java.util.List;

/**
 *
 * @author jsmat
 */
public class ArticulosController {
       public void crearArtículo(String color, byte[] imagenDeFondo, float precioUnitario, int stock, TipoArticulo tipo, String talle){
       
        Articulo a = new Articulo();
        a.setColor(color);
        a.setImagenDeFondo(imagenDeFondo);
        a.setPrecioUnitario(precioUnitario);
        a.setStock(stock);
        a.setTalle(talle);
        a.setTipo(tipo);
       Conexion.getInstance().persist(a);
       }
       
       public List<Articulo> listarArticulos(){
       return Conexion.getInstance().select("FROM Articulo",Articulo.class);
       }
       
       public Articulo getArticulo(long idArticulo){
       List<Articulo> arts = Conexion.getInstance().select("FROM Articulo WHERE id ="+idArticulo, Articulo.class);
       return arts.get(0);
       }
       
       public void modificarStock(long idArticulo, int nuevoStock){
       Articulo a  = this.getArticulo(idArticulo);
       a.setStock(nuevoStock);
       Conexion.getInstance().merge(a);
       }
}
