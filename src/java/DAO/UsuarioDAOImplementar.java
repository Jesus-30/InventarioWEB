
package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
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
      
       this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        Usuario usuario = new Usuario();
        StringBuilder miSQL = new StringBuilder();
        
        miSQL.append("SELECT * FROM tb_usuario where id =").append(id_U_edit);
        try {
            ResultSet resultadoSql = this.conn.cosultaSQL(miSQL.toString());
            while (resultadoSql.next()) {                             
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
            }
        } catch (SQLException ex) {
          
        } finally {
            this.conn.cerrarConexion();
        }
        return usuario;
    }

    @Override
    public boolean guardarUsuario(Usuario usuario) {
         this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean guardar = false;
        try {
            if (usuario.getId() == 0) {
                StringBuilder miSQL = new StringBuilder();
                miSQL.append("INSERT INTO tb_usuario(nombre, apellido, correo, usuario, clave, tipo, estado, pregunta, respuesta) values('");
                miSQL.append(usuario.getNombre() +  "', '").append(usuario.getApellido() + "', '").append(usuario.getCorreo() +  "', '").append(usuario.getUsuario() + 
                "', '").append(usuario.getClave() + "', '").append(usuario.getTipo() +"', '").append(usuario.getEstado() + "', '").append(usuario.getPregunta()+
                "', '").append(usuario.getRepuesta());
                miSQL.append("');");
                this.conn.ejecutarSQL(miSQL.toString());
            } else if(usuario.getId() > 0){
                StringBuilder miSQL = new StringBuilder();
                miSQL.append("update tb_usuario set id ='").append(usuario.getId());
                miSQL.append("', nombre = '").append(usuario.getNombre());
                miSQL.append("', apellido = '").append(usuario.getApellido());
                miSQL.append("', correo = '").append(usuario.getCorreo());
                miSQL.append("', usuario = '").append(usuario.getUsuario());
                miSQL.append("', clave = '").append(usuario.getClave());
                miSQL.append("', tipo = '").append(usuario.getTipo());
                miSQL.append("', estado = '").append(usuario.getEstado());
                miSQL.append("', pregunta = '").append(usuario.getPregunta());
                miSQL.append("', respuesta = '").append(usuario.getRepuesta());
                miSQL.append("' where id = ").append(usuario.getId()).append(";");
                this.conn.ejecutarSQL(miSQL.toString());
            }
            guardar = true;
        } catch (Exception ex) {
           
        } finally {
            this.conn.cerrarConexion();
        }
        return guardar;
    }



    @Override
    public boolean borrarUsuario(int id_U_borrar) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean borrar = false;
        try {
            StringBuilder miSql = new StringBuilder();
            miSql.append("DELETE FROM tb_usuario where id =").append(id_U_borrar);
            this.conn.ejecutarSQL(miSql.toString());
            borrar = true;
        } catch (Exception ex) {
        
        } finally {
            this.conn.cerrarConexion();
        }
        return borrar;
    
}
      }