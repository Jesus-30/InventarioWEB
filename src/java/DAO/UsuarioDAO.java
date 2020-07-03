
package DAO;

import Model.Usuario;
import java.util.List;

/**
 *
 * @author Estefany
 */
public interface UsuarioDAO {
    
     public List<Usuario> Listar();
    public List<Usuario> Listar2();
    public Usuario editarUsuario(int id_U_edit);
    public boolean guardarUsuario(Usuario usuario);
    public boolean borrarUsuario(int id_U_borrar);
}
