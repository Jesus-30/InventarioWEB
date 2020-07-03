
package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estefany
 */
public class UsuarioDAOImplementar implements UsuarioDAO {
ConexionDB conn;

    public UsuarioDAOImplementar() {
    }
    
    @Override
    public List<Usuario> Listar() {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        StringBuilder misql = new StringBuilder();
        misql.append("SELECT * FROM tb_usuario");
        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            ResultSet resultadoSql = this.conn.cosultaSQL(misql.toString());
            while (resultadoSql.next()) {                
                Usuario usuario = new Usuario();
                usuario.setId(resultadoSql.getInt("id"));
                usuario.setNombre(resultadoSql.getString("nombre"));
                usuario.setApellido(resultadoSql.getString("apellido"));
                usuario.setCorreo(resultadoSql.getString("correo"));
                usuario.setUsuario(resultadoSql.getString("usuario"));
                usuario.setClave(resultadoSql.getString("clave"));
                usuario.setTipo(resultadoSql.getInt("tipo"));
                usuario.setEstado(resultadoSql.getInt("estado"));
                usuario.setPregunta(resultadoSql.getString("pregunta"));
                usuario.setRepuesta(resultadoSql.getString("respuesta"));
                usuario.setFecha_registro(resultadoSql.getDate("fecha_registro"));
                lista.add(usuario);
            }
        } catch (Exception ex) {
           
        } finally {
            this.conn.cerrarConexion();
        }
        return lista;
    }


    @Override
    public List<Usuario> Listar2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario editarUsuario(int id_U_edit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guardarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrarUsuario(int id_U_borrar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
