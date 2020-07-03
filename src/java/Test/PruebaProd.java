
package Test;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import DAO.ProductoDAO;
import DAO.ProductoDAOImplementar;
import Model.Categoria;
import Model.Producto;
import java.util.List;

/**
 *
 * @author Estefany
 */
public class PruebaProd {
     public static void main (String [] args){
           PruebaProd evaluar = new PruebaProd();
      evaluar.listarProducto();
          // evaluar.editarProducto();
       // evaluar.guardarProducto();
          // evaluar.borrarProducto();
    }
     public void listarProducto(){
        ProductoDAO producto = new ProductoDAOImplementar();
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        Categoria ct = new Categoria();
        List<Producto> listar = producto.Listar();
        System.out.println("LISTADO DE PRODUCTOS");
        for(Producto productos : listar){
            System.out.println("ID: " + productos.getId_producto() + 
                    " \nNombre: " + productos.getNom_producto() + 
                    " \nStock: " + productos.getStock() + 
                    " \nPrecio: " + productos.getPrecio() + 
                    " \nUnidad Medida: " + productos.getUnidadMedida() +
                    " \nEstado: " + productos.getEstado() +
                    " \nCategoria: " + productos.getCategoria_id()+
                    " \nDescripcion: " + productos.getDes_producto() + 
                    " \nFecha: " + productos.getFecha_entrada());
        }
    }
      public void editarProducto(){
        ProductoDAO producto = new ProductoDAOImplementar();
        Producto pro_edit = producto.editarPro(2);
        System.out.println("   Producto a Editar   ");
        System.out.println("ID: " + pro_edit.getId_producto() + 
                    " \nNombre: " + pro_edit.getNom_producto() + 
                    " \nStock: " + pro_edit.getStock() + 
                    " \nPrecio: " + pro_edit.getPrecio() + 
                    " \nUM: " + pro_edit.getUnidadMedida() +
                    " \nEstado: " + pro_edit.getEstado() +
                    " \nCategoria: " + pro_edit.getCategoria_id()+
                    " \nDescripcion: " + pro_edit.getDes_producto() + 
                    " \nFecha: " + pro_edit.getFecha_entrada());
    }
       public void guardarProducto(){
        ProductoDAO producto = new ProductoDAOImplementar();
        Producto guardar_Pro = new Producto();
        guardar_Pro.setNom_producto("Crema");
        guardar_Pro.setPrecio(1.5);
        guardar_Pro.setPrecio(1.20);
        guardar_Pro.setUnidadMedida("Botella");
        guardar_Pro.setEstado(1);
        guardar_Pro.setCategoria_id(Integer.toString(4));
        guardar_Pro.setDes_producto("Deliciosa");
        
        producto.guardarPro(guardar_Pro);
    }
       public void borrarProducto(){
        ProductoDAO producto = new ProductoDAOImplementar();
        producto.borrarPro(14);
       }
}
    