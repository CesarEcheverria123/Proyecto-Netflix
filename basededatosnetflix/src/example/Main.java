/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example;

import dao.UsuarioDao;
import dto.Usuario;
import factory.FactoryDao;

/**
 *
 * @author josec
 */
public class Main {
    
    public static void main(String[] args) {
        UsuarioDao dao = FactoryDao.getFactoryInstance().getNewUsuarioDao();
        
        Usuario usr = new Usuario();
        usr.setNombreCompleto("Juan Perez");
        usr.setUsername("jperez");
        usr.setPassword("jperez");
        usr.setTipoUsuario("CLIENTE");
        
        try {
            dao.insert(usr);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        
    }
    
}
