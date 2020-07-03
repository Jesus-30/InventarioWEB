
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
// evaluar.editarUsuario();
 //evaluar.guardarUsu();
 //evaluar.borrarUsuario();
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
      public void editarUsuario(){
        UsuarioDAO usuario = new UsuarioDAOImplementar();
        Usuario u_edit = usuario.editarUsuario(1);
        System.out.println("Usuario a Editar");
        System.out.println("ID: " + u_edit.getId()+ 
                    " \nNombre: " + u_edit.getNombre() + 
                    " \nApellido: " + u_edit.getApellido() + 
                    " \nCorreo: " + u_edit.getCorreo() + 
                    " \nUsuario: " + u_edit.getUsuario() +
                    " \nClave: " + u_edit.getClave() +
                    " \nTipo: " + u_edit.getTipo() + 
                    " \nEstado: " + u_edit.getEstado() + 
                    " \nPregunta: " + u_edit.getPregunta() +
                    " \nRespuesta: " + u_edit.getRepuesta() +
                    " \nFecha: " + u_edit.getFecha_registro());
    }
    public void guardarUsu(){
         UsuarioDAO usuario = new UsuarioDAOImplementar();
        Usuario guarda_u = new Usuario();
        guarda_u.setId(2);
        guarda_u.setNombre("Jesus");
        guarda_u.setApellido("Henriquez");
        guarda_u.setCorreo("j20@gmail.com");
        guarda_u.setUsuario("administrador");
        guarda_u.setClave("1502");
        guarda_u.setTipo(1);
        guarda_u.setEstado(1);
        guarda_u.setPregunta("Color favorito");
        guarda_u.setRepuesta("Amarillo");
        
        usuario.guardarUsuario(guarda_u);
    }
    public void borrarUsuario(){
        UsuarioDAO usuario = new UsuarioDAOImplementar();
        usuario.borrarUsuario(2);
    }
}




