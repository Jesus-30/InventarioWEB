
package Controller;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImplementar;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Estefany
 */
public class Usuario extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
      protected void listarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        //objeto usuario
        UsuarioDAO usuarios = new UsuarioDAOImplementar();
        HttpSession session = request.getSession(true);
        session.setAttribute("lista", usuarios.Listar());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Usuario/listarUsuario.jsp");
        dispatcher.forward(request, response);
    }
       protected void borrarUsuario(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Usuario/listarUsuario.jsp");
        dispatcher.forward(request, response);
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String parametro = request.getParameter("opcion");
        
        if (parametro.equals("crear")) {
            String pagina = "/Vistas-Usuario/crearUsuario.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
            
        } else if(parametro.equals("listar")){
            this.listarUsuario(request, response);
            
        } else if(parametro.equals("modificar")){
            int id = Integer.parseInt(request.getParameter("id_u"));
            String nombre = request.getParameter("nombre_u");
            String apellido = request.getParameter("apellido_u");
            String correo = request.getParameter("correo_u");
            String usuario = request.getParameter("usuario_u");
            String clave = request.getParameter("clave_u");
            int tipo = Integer.parseInt(request.getParameter("tipo_u"));
            int estado = Integer.parseInt(request.getParameter("estado_u"));
            String pregunta = request.getParameter("pregunta_u");
            String respuesta = request.getParameter("respuesta_u");
        
            
            String pagina = "/Vistas-Usuario/crearUsuario.jsp?id_usu="+id+"&&nombre_u="+nombre+"&&apellido_u="+apellido+"&&correo_u="+correo+"&&usuario_u="+usuario+"&&clave_u="+clave+"&&tipo_u="+tipo+"&&estado_u="+estado+"&&pregunta_u="+pregunta+"&&respuesta_u="+respuesta+"&&sirens=1";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
            
        } else if(parametro.equals("eliminar")){
            int eliminar_id = Integer.parseInt(request.getParameter("id"));
            UsuarioDAO usuario = new UsuarioDAOImplementar();
            usuario.borrarUsuario(eliminar_id);
            this.listarUsuario(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Model.Usuario usuario = new Model.Usuario();
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        String nombre_usuario = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String correo = request.getParameter("txtCorreo");
        String usu = request.getParameter("txtUsuario");
        String clave = request.getParameter("txtClave");
        int tipo = Integer.parseInt(request.getParameter("txtTipo"));
        int estado = Integer.parseInt(request.getParameter("txtEstado"));
        String pregunta = request.getParameter("txtPregunta");
        String respuesta = request.getParameter("txtRespuesta");
        
        usuario.setId(id_usuario);
        usuario.setNombre(nombre_usuario);
        usuario.setApellido(apellido);
        usuario.setCorreo(correo);
        usuario.setUsuario(usu);
        usuario.setClave(clave);
        usuario.setTipo(tipo);
        usuario.setEstado(estado);
        usuario.setPregunta(pregunta);
        usuario.setRepuesta(respuesta);
        
        UsuarioDAO guardarUsuario = new UsuarioDAOImplementar();
        guardarUsuario.guardarUsuario(usuario);
        this.listarUsuario(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
