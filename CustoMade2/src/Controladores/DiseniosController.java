/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import BD.Conexion;
import customade2.Entidades.Articulo;
import customade2.Entidades.Disenio;
import customade2.Entidades.Imagen;
import customade2.Entidades.Posicion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jsmat
 */
public class DiseniosController {
    
    public void guardarDisenio(String nombreDelDisenio, long idArticulo, int anchoImagenFRONT, int altoImagenFRONT, int marginLeftFRONT, int marginTopFRONT, byte[] imagenFRONT,int anchoImagenBACK, int altoImagenBACK, int marginLeftBACK, int marginTopBACK, byte[] imagenBACK, boolean publico){
    
        Imagen iFRONT = new Imagen();
        iFRONT.setAncho(anchoImagenFRONT);
        iFRONT.setLargo(altoImagenFRONT);
        iFRONT.setImagenProporcionada(imagenFRONT);
        iFRONT.setMarginLeft(marginLeftFRONT);
        iFRONT.setMarginTop(marginTopFRONT);
        iFRONT.setPosicionBackFront(Posicion.FRONT);
        
        Imagen iBACK = new Imagen();
        iBACK.setAncho(anchoImagenBACK);
        iBACK.setLargo(altoImagenBACK);
        iBACK.setImagenProporcionada(imagenBACK);
        iBACK.setMarginLeft(marginLeftBACK);
        iBACK.setMarginTop(marginTopBACK);
        iBACK.setPosicionBackFront(Posicion.BACK);
////        
        Disenio d = new Disenio();
        List<Articulo> arts = Conexion.getInstance().select("FROM Articulo WHERE id = "+idArticulo, Articulo.class);
        Articulo a = arts.get(0);
        d.setArticulo(a);
        List<Imagen> imagens = new ArrayList<Imagen>();
        iBACK.setDisenio(d);
        iFRONT.setDisenio(d);
        imagens.add(iBACK);
        imagens.add(iFRONT);
        d.setImagens(imagens);
        d.setNombre(nombreDelDisenio);
        d.setPrecioUnitario(a.getPrecioUnitario());
        d.setPublico(publico);
        
        Conexion.getInstance().persist(d);
    }
    
    public List<Disenio> listarDisenios(){
    return Conexion.getInstance().select("FROM Disenio", Disenio.class);
    }
    
    public Disenio getDisenio(long idDisenio){
    List<Disenio> disenios = Conexion.getInstance().select("FROM Disenio WHERE id ="+idDisenio, Disenio.class);
    return disenios.get(0);
    }
    
}
