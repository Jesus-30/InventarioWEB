
package Test;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImplementar;
import Model.Usuario;
import java.util.List;

/**
 *
 * @author Estefany
 */
public class PruebaUsuario {
     public static void main(String[] args) {
    PruebaUsuario evaluar = new PruebaUsuario();
 evaluar.listarUsuario();
}
     public void listarUsuario(){
        UsuarioDAO usuario = new UsuarioDAOImplementar();
        List<Usuario> listar = usuario.Listar();
        System.out.println("LISTADO DE USUARIOS");
        for(Usuario usuarioListar : listar){
            System.out.println("ID: " + usuarioListar.getId() + 
                    " \nNombre: " + usuarioListar.getNombre() + 
                    " \nApellido: " + usuarioListar.getApellido() + 
                    " \nCorreo: " + usuarioListar.getCorreo() + 
                    " \nUsuario: " + usuarioListar.getUsuario() +
                    " \nClave: " + usuarioListar.getClave() +
                    " \nTipo: " + usuarioListar.getTipo() + 
                    " \nEstado: " + usuarioListar.getEstado() + 
                    " \nPregunta: " + usuarioListar.getPregunta() +
                    " \nRespuesta: " + usuarioListar.getRepuesta() +
                    " \nFecha: " + usuarioListar.getFecha_registro());
        }
    }
}
