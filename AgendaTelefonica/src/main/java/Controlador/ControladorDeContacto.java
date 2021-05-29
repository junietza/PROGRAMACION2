/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;

/**
 *
 * @author Ervin
 */
public class ControladorDeContacto {

    private ArrayList<Contacto> miscontactos = new ArrayList<Contacto>();
    private static ControladorDeContacto instance= new ControladorDeContacto();
    private static ControladorDeContacto getInstance(){
        return instance;
    }

    private ControladorDeContacto() {
    }

    public boolean Agregar(String Nombre, String Telefono) {
        Contacto c = new Contacto(Nombre, Telefono);
        if(miscontactos.contains(c)){
            return false;
        }
        return miscontactos.add(c);
    }

    public boolean Eliminar(String Nombre) {
        int i = 0;
        while (i < miscontactos.size()) {
            Contacto c = miscontactos.get(i);
            if (c.getNombre().equals(Nombre)) {
                miscontactos.remove(i);
                return true;
            }
            i++;

        }
        return false;
    }
    
    public String[][] listado(){
        String[][] lista = new String[miscontactos.size()][2];
        int i = 0;
        while(i < miscontactos.size()){
            Contacto c = miscontactos.get(i);
            lista[i][0] = c.getNombre();
            lista[i][1] = c.getTelefono();
            i++;
        }
        return lista;
    }

}
