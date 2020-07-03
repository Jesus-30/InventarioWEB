
package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estefany
 */
public class ProductoDAOImplementar implements ProductoDAO  {
ConexionDB conn;

public ProductoDAOImplementar(){

}
    @Override
    public List<Producto> Listar() {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT\n" +
            " p.categoria, p.id_producto, p.nom_producto, p.stock, p.precio, p.unidad_de_medida, p.estado_producto,\n" +
            " c.nom_categoria, p.des_producto, p.fecha_entrada\n" +
            "FROM tb_producto p INNER JOIN tb_categoria c\n" +
            "on p.categoria = c.id_categoria;");
        List<Producto> lista = new ArrayList<Producto>();
       
        try {
            ResultSet resultadoSql = this.conn.cosultaSQL(miSQL.toString());
            while (resultadoSql.next()) {                
                Producto producto = new Producto();
                producto.setId_producto(resultadoSql.getInt("id_producto"));
                producto.setNom_producto(resultadoSql.getString("nom_producto"));
                producto.setStock(resultadoSql.getFloat("stock"));
                producto.setPrecio(resultadoSql.getFloat("precio"));
                producto.setUnidadMedida(resultadoSql.getString("unidad_de_medida"));
                producto.setEstado(resultadoSql.getInt("estado_producto"));
                producto.setCategoria_id(resultadoSql.getString("c.nom_categoria"));
                producto.setDes_producto(resultadoSql.getString("des_producto"));
                producto.setFecha_entrada(resultadoSql.getDate("fecha_entrada"));
                lista.add(producto);
               
            }
        } catch (Exception e) {
          
        } finally {
            this.conn.cerrarConexion();
        }
        return lista;
    }

    @Override
    public List<Producto> Listar2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto editarPro(int id_pro_edit) {
       this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        Producto producto = new Producto();
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT\n" +
            " p.categoria, p.id_producto, p.nom_producto, p.stock, p.precio, p.unidad_de_medida, p.estado_producto,\n" +
            " c.nom_categoria, p.des_producto, p.fecha_entrada\n" +
            "FROM tb_producto p INNER JOIN tb_categoria c\n" +
            "on p.categoria = c.id_categoria;").append(id_pro_edit);
        
        try {
            ResultSet resultadosSql = this.conn.cosultaSQL(miSQL.toString());
            while (resultadosSql.next()) {                
                producto.setId_producto(resultadosSql.getInt("id_producto"));
                producto.setNom_producto(resultadosSql.getString("nom_producto"));
                producto.setStock(resultadosSql.getFloat("stock"));
                producto.setPrecio(resultadosSql.getFloat("precio"));
                producto.setUnidadMedida(resultadosSql.getString("unidad_de_medida"));
                producto.setEstado(resultadosSql.getInt("estado_producto"));
                producto.setCategoria_id(resultadosSql.getString("c.nom_categoria"));
                producto.setDes_producto(resultadosSql.getString("des_producto"));
                producto.setFecha_entrada(resultadosSql.getDate("fecha_entrada"));
                
            }
        } catch (Exception e) {
          
        } finally {
            this.conn.cerrarConexion();
        }
        
        return producto;
    }

    @Override
    public boolean guardarPro(Producto producto) {
       this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean guarda = false;
        try {
            if (producto.getId_producto() == 0) {
                StringBuilder miSQL = new StringBuilder();
                miSQL.append("INSERT INTO tb_producto (nom_producto, stock, precio, unidad_de_medida, estado_producto, categoria, des_producto) values('");
                miSQL.append(producto.getNom_producto() + "', '").append(producto.getStock() + "', '").append(producto.getPrecio()+"', '").append(producto.getUnidadMedida()+ "', '").append(producto.getEstado()+  "', '").append(producto.getCategoria_id()+
                 "', '").append(producto.getDes_producto());
                miSQL.append("');");
                this.conn.ejecutarSQL(miSQL.toString());
                
            } else if(producto.getId_producto() > 0){
                StringBuilder miSql = new StringBuilder();
                miSql.append("update tb_producto set id_producto ='").append(producto.getId_producto());
                miSql.append("', nom_producto = '").append(producto.getNom_producto());
                miSql.append("', stock = '").append(producto.getStock());
                miSql.append("', precio = '").append(producto.getPrecio());
                miSql.append("', unidad_de_medida = '").append(producto.getUnidadMedida());
                miSql.append("', estado_producto = '").append(producto.getEstado());
                miSql.append("', categoria = '").append(producto.getCategoria_id());
                miSql.append("', des_producto = '").append(producto.getDes_producto());
                miSql.append("' where id_producto = ").append(producto.getId_producto()).append(";");
                this.conn.ejecutarSQL(miSql.toString());
            }
            guarda = true;
        } catch (Exception ex) {
           
        } finally {
            this.conn.cerrarConexion();
        }
        return guarda;
    }

    @Override
    public boolean borrarPro(int id_pro_borrar) {
       this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean borrar = false;
        try {
            StringBuilder miSql = new StringBuilder();
            miSql.append("DELETE FROM tb_producto where id_producto =").append(id_pro_borrar);
            this.conn.ejecutarSQL(miSql.toString());
            borrar = true;
        } catch (Exception e) {
          
        } finally {
            this.conn.cerrarConexion();
        }
        return borrar;
    }
}