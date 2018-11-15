package mx.com.gm.sga.web;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.servicio.UsuarioService;

@WebServlet("/usuarios")
public class UsuariosServlet extends HttpServlet {

    @Inject
    UsuarioService usuarioServiceEjbLocal;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> usuarios = usuarioServiceEjbLocal.listarUsuarios();
        System.out.println("usuarios:" + usuarios);
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/listadoUsuarios.jsp").forward(request, response);
    }
}
